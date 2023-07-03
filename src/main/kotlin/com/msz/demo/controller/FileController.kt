package com.msz.demo.controller

import com.msz.demo.NonStaticResourceHttpRequestHandler
import com.msz.demo.bean.DiskInfo
import com.msz.demo.bean.FileInfo
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.simple
import com.msz.demo.service.impl.FileService
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootExceptionReporter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
//@AllArgsConstructor
class FileController {

    @Autowired
    lateinit var service: FileService

    @PostMapping("/disk/search")
    fun searchDisk(@RequestParam("acceseKey") acceseKey: String): RespondInfo<List<DiskInfo>> {
        return simple(data = service.loaderDiskInfo(acceseKey))
    }

    @PostMapping("/disk/files")
    fun getDirFiles(
        @RequestParam("acceseKey") acceseKey: String,
        @RequestParam("path") path: String
    ): RespondInfo<List<FileInfo>> {
        return simple(data = service.loadDirFiles(acceseKey, path))
    }

    @GetMapping("/disk/file2")
    @Throws(IOException::class)
    fun loadFile(
        @RequestParam("acceseKey") acceseKey: String,
        @RequestParam("path") path: String
    ): ResponseEntity<Resource?>? {
        service.findPath(acceseKey, path)?.apply {

            // 根据文件名获取文件流
            val inputStream: InputStream = FileInputStream(this)
            // 创建文件流资源对象
            val resource: Resource = InputStreamResource(inputStream)

            // 设置响应头信息
            val headers = HttpHeaders()
            headers.setContentDispositionFormData("attachment", this.name)
            headers.contentType = MediaType.APPLICATION_OCTET_STREAM

            // 返回文件流和响应头信息
            return ResponseEntity<Resource?>(resource, headers, HttpStatus.OK)
        }
        return null
    }


    @Autowired
    private var nonStaticResourceHttpRequestHandler: NonStaticResourceHttpRequestHandler? = null

    /**
     * 预览视频文件, 支持 byte-range 请求
     */
    @GetMapping("/disk/file/video")
    @Throws(Exception::class)
    fun videoPreview(
        request: HttpServletRequest,
        response: HttpServletResponse,
        @RequestParam("acceseKey") acceseKey: String,
        @RequestParam("path") path: String
    ) {
        val path = service.findPath(acceseKey, path) ?: return
        val filePath: Path = Paths.get(path.absolutePath)
        if (Files.exists(filePath)) {
            val mimeType = Files.probeContentType(filePath)
            if (!mimeType.isNullOrEmpty()) {
                response.contentType = mimeType
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath)

//            Sprin

            nonStaticResourceHttpRequestHandler!!.handleRequest(request, response)
        } else {
            response.status = HttpServletResponse.SC_NOT_FOUND
            response.characterEncoding = StandardCharsets.UTF_8.toString()
        }
    }

    //    @ApiOperation("单个MP4播放")
//    @GetMapping(value = ["/disk/file/video"], produces = ["application/json;charset=utf-8"])
//    fun aloneVideoPlay(
//        request: HttpServletRequest?,
//        @RequestParam("acceseKey") acceseKey: String, @RequestParam("path") path: String,
//        response: HttpServletResponse
//    ) {
//        var `is`: InputStream? = null
//        var os: OutputStream? = null
//        try {
//            response.contentType = "video/mp4"
//            val file = service.findPath(acceseKey, path) ?: return
//            response.addHeader("Content-Length", "" + file.length())
//            `is` = FileInputStream(file)
//            os = response.outputStream
//            IOUtils.copy(`is`, os)
//        } catch (e: Exception) {
////            log.error("播放MP4失败", e)
//        } finally {
//            if (null != os) {
//                try {
//                    os.close()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }

    fun export(file: File?): ResponseEntity<FileSystemResource?>? {
        if (file == null) {
            return null
        }
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", "attachment; filename=" + file.name)
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")
        headers.add("Last-Modified", Date().toString())
        headers.add("ETag", System.currentTimeMillis().toString())
        return ResponseEntity.ok().headers(headers).contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body<FileSystemResource?>(FileSystemResource(file))
    }

}
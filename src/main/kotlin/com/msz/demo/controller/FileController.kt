package com.msz.demo.controller

import com.msz.demo.bean.DiskInfo
import com.msz.demo.bean.FileInfo
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.simple
import com.msz.demo.service.impl.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


@RestController
class FileController {

    @Autowired
    lateinit var service : FileService

    @PostMapping("/disk/search")
    fun searchDisk(@RequestHeader("acceseKey") acceseKey: String): RespondInfo<List<DiskInfo>> {
        return simple(data = service.loaderDiskInfo(acceseKey))
    }

    @PostMapping("/disk/files")
    fun getDirFiles(@RequestHeader("acceseKey") acceseKey: String, @RequestHeader("path") path: String): RespondInfo<List<FileInfo>> {
        return simple(data = service.loadDirFiles(acceseKey,path))
    }

    @GetMapping("/disk/file2")
    @Throws(IOException::class)
    fun loadFile(@RequestParam("acceseKey") acceseKey: String, @RequestParam("path") path: String): ResponseEntity<Resource?>? {
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
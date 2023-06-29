package com.msz.demo.controller

import com.msz.demo.info.StringChooseBean
import com.msz.demo.info.bean
import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.buildConfigErrorRespond
import com.msz.demo.info.respone.simple
import com.msz.demo.service.AppService
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.lang.Exception
import java.util.*
import javax.servlet.http.HttpServletResponse


@RestController
class AppConfigController {

    @Autowired
    lateinit var appService: AppService

    @GetMapping("/appConfig")
    fun appConfig(@RequestBody token: TokenRequest): RespondInfo<String?> {
        if (token.token == null) {
            return buildConfigErrorRespond()
        }
        return appService.checkTokenAndRespond(token)
    }


    @PostMapping("/testArray")
    fun testArray(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int = 20,
        @RequestParam("lastId") id: String? = null
    ): RespondInfo<MutableList<StringChooseBean>> {
        println()
        var page2 = page
        if (page2 == 0) {
            page2 = 1;
        }
        val start = page2 * size
        if (start - size >= TEST_ARRAYS.size) {
            return simple(data = ArrayList())
        }
        val re = simple<MutableList<StringChooseBean>>(data = mutableListOf())
        var start2 = start - size
        val maxSize = TEST_ARRAYS.size
        while (true) {
            re.data!!.add(TEST_ARRAYS[start2])
            start2++
            if (start2 >= maxSize || start2 == start) {
                break
            }
        }
        return re;
    }

//    @GetMapping("/qianshanwanshui")
//    fun qsws(): File {
//        return File("G:\\idea_web_project\\千山万水.mp3")
//    }

    @GetMapping("/千山万水.mp3")
    fun download千山万水(
        response: HttpServletResponse
    ) {
        downFile(response, "G:\\idea_web_project\\千山万水.mp3","千山万水.mp3")
    }

    @GetMapping("/我的刻苦铭心的恋人.mp3")
    fun download我的刻苦铭心的爱人(
        response: HttpServletResponse
    ) {
        downFile(response, "G:\\idea_web_project\\闪歌_我的刻苦铭心的恋人.mp3","闪歌_我的刻苦铭心的恋人.mp3")
    }

    @GetMapping("/wavTest.wav")
    fun downloadWav1(
        response: HttpServletResponse
    ) {
        downFile(response, "G:\\idea_web_project\\dnsRXV0SUH6ASVysADygTuw80Ak462.wav","dnsRXV0SUH6ASVysADygTuw80Ak462.wav")
    }

    @GetMapping("/wavTest2.wav")
    fun downloadWav2(
        response: HttpServletResponse
    ) {

        downFile(response, "D:\\music\\千山万水.mp3","千山万水.mp3")
    }

    @GetMapping("/text")
    fun getFileString(
        response: HttpServletResponse
    ) {
        downFile(response, "D:\\music\\text2222.txt","text2222.txt")
    }


    @GetMapping("/wavTest2.mp3")
    fun downloadWav3(
        response: HttpServletResponse
    ) {

        downloadWav2(response)
    }

    //G:\idea_web_project



    @PostMapping("/card1")
    fun card1(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int = 20,
        @RequestParam("lastId") id: String? = null
    ): RespondInfo<MutableList<StringChooseBean>> {
        println()
        var page2 = page
        if (page2 == 0) {
            page2 = 1;
        }
        val start = page2 * size
        if (start - size >= TEST_ARRAYS.size) {
            return simple(data = ArrayList())
        }
        val re = simple<MutableList<StringChooseBean>>(data = mutableListOf())
        var start2 = start - size
        val maxSize = TEST_ARRAYS.size
        while (true) {
            re.data!!.add(TEST_ARRAYS[start2])
            start2++
            if (start2 >= maxSize || start2 == start) {
                break
            }
        }
        return re;
    }


    companion object {


        public fun downFile(response: HttpServletResponse, s: String,name:String) {
            response.contentType = "application/x-download"
            response.characterEncoding = "UTF-8"
            response.setHeader("Content-Disposition", "attachment;filename=$name")
            val inputStream = FileInputStream(s)
            val outputStream = response.outputStream
            IOUtils.copy(inputStream, outputStream)
            outputStream.flush()
        }

        val TEST_ARRAYS = arrayOf(
            "a".bean(),
            "1".bean(),
            "2".bean(),
            "3".bean(),
            "4".bean(),
            "5".bean(),
            "6".bean(),
            "7".bean(),
            "8".bean(),
            "9".bean(),
            "10".bean(),
            "11".bean(),
            "12".bean(),
            "13".bean(),
            "14".bean(),
            "15".bean(),
            "16".bean(),
            "17".bean(),
            "18".bean(),
            "19".bean(),
            "20".bean(),
            "21".bean(),
            "22".bean(),
            "23".bean(),
            "24".bean(),
            "25".bean(),
            "26".bean(),
            "27".bean(),
            "28".bean()
        )

        val CARD_ARRAYS = arrayOf(
            "a".bean(),
            "1".bean(),
            "2".bean(),
            "3".bean(),
            "4".bean(),
            "5".bean(),
            "6".bean(),
            "7".bean(),
            "8".bean(),
            "9".bean(),
            "10".bean(),
            "11".bean(),
            "12".bean(),
            "13".bean(),
            "14".bean(),
            "15".bean(),
            "16".bean(),
            "17".bean(),
            "18".bean(),
            "19".bean(),
            "20".bean(),
            "21".bean(),
            "22".bean(),
            "23".bean(),
            "24".bean(),
            "25".bean(),
            "26".bean(),
            "27".bean(),
            "28".bean()
        )

    }

    @PostMapping("/postPath")
    fun postPath(@RequestParam("headerFile") file: MultipartFile): RespondInfo<String>? {
        return if (!file.isEmpty) {
            val uploadPath = "D:\\uploadFile"
            // 如果目录不存在则创建
            val uploadDir = File(uploadPath)
            if (!uploadDir.exists()) {
                uploadDir.mkdir()
            }
            val originalFilename = file.originalFilename //获取原文件名
            val suffixName = originalFilename!!.substring(originalFilename.lastIndexOf(".")) //获取文件后缀名
            //重新随机生成名字
            val filename = UUID.randomUUID().toString() + suffixName
            val localFile = File(uploadPath + "\\" + filename)
            try {
                println("    file.getBytes().length = " + file.bytes.size)
                file.transferTo(localFile) //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */
                simple(200, msg = "上传成功", data = filename) //上传成功，返回保存的文件地址
            } catch (e: IOException) {
                e.printStackTrace()
                println("上传失败")
                simple(-2, "上传失败", data = "")
            }
        } else {
            println("文件为空")
            simple(-1, "文件为空", data = "")
        }
    }


}

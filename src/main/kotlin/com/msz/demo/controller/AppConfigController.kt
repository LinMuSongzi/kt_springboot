package com.msz.demo.controller

import com.msz.demo.info.StringChooseBean
import com.msz.demo.info.bean
import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.buildConfigErrorRespond
import com.msz.demo.info.respone.simple
import com.msz.demo.service.AppService
import com.msz.demo.service.MszServiceManager.Companion.getServiceImpl
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.web.bind.annotation.*
import java.io.FileInputStream
import javax.servlet.http.HttpServletResponse

@RestController
class AppConfigController {
//    constructor(){
//        threadPrint()
//    }

    @GetMapping("/appConfig")
    fun appConfig(@RequestBody token: TokenRequest): RespondInfo<String?> {
        if (token.token == null) {
            return buildConfigErrorRespond()
        }
        return getServiceImpl<AppService>().checkTokenAndRespond(token)
    }


    @PostMapping("/testArray")
    fun testArray(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int = 20,
        @RequestParam("lastId") id:String? = null
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
            if (start2 >= maxSize || start2 == start){
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
        downFile(response,"G:\\idea_web_project\\千山万水.mp3")
    }

    @GetMapping("/我的刻苦铭心的恋人.mp3")
    fun download我的刻苦铭心的爱人(
        response: HttpServletResponse
    ) {
        downFile(response,"G:\\idea_web_project\\闪歌_我的刻苦铭心的恋人.mp3")
    }

    @GetMapping("/wavTest.wav")
    fun downloadWav1(
        response: HttpServletResponse
    ) {
        downFile(response,"G:\\idea_web_project\\dnsRXV0SUH6ASVysADygTuw80Ak462.wav")
    }

    @GetMapping("/wavTest2.wav")
    fun downloadWav2(
        response: HttpServletResponse
    ) {
        downFile(response,"G:\\idea_web_project\\ad7d1d4edff2167163b7303f0fd9f369.wav")
    }

    //G:\idea_web_project

    private fun downFile(response: HttpServletResponse, s: String) {
        response.contentType = "application/x-download"
        response.characterEncoding="UTF-8"
        response.setHeader("Content-Disposition", "attachment;filename=qianshanwans.mp3")
        val inputStream = FileInputStream(s)
        val outputStream = response.outputStream
        IOUtils.copy(inputStream, outputStream)
        outputStream.flush()
    }


    @PostMapping("/card1")
    fun card1(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int = 20,
        @RequestParam("lastId") id:String? = null
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
            if (start2 >= maxSize || start2 == start){
                break
            }
        }
        return re;
    }


    companion object {

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


}
//fun threadPrint() {
//    var sum = 0;
//    val maxCout = 1_000_000
//    val runMethod = {
//        synchronized(ObjectInput::class.java) {
//            if(sum == 5){
//                return@synchronized
//            }
//            println("test: "+sum++)
//        }
//    }
//    val run = {
//        Thread {
//            while (sum < 5) {
//                runMethod()
//            }
//        }.start()
//    }
//    for(i in 0 until maxCout){
//        run()
//    }
//}
//
fun main(args: Array<String>) {
//    threadPrint()
    exeRun()
}

fun exeRun() {


}

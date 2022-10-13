package com.msz.demo.controller

import com.msz.demo.info.request.FileRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.service.AppService
import com.msz.demo.service.MszServiceManager
import com.msz.demo.service.UtilHelpService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UtilHelpController {

    @RequestMapping("/uploadObject")
    fun uploadObject(@RequestBody fileBean: FileRequest, @RequestParam("file_name") file: MultipartFile): RespondInfo<String> {
       // return MszServiceManager.getServiceImpl<UtilHelpService>().uploadObject(token)
        TODO()
    }

}
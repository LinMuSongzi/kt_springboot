package com.msz.demo.controller

import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.buildConfigRespond
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppConfigController {

    @RequestMapping("/appConfig")
    fun appConfig(token: TokenRequest): RespondInfo<String> {
        return buildConfigRespond(token)
    }


}
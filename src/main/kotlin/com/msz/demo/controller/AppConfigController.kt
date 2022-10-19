package com.msz.demo.controller

import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.buildConfigErrorRespond
import com.msz.demo.service.AppService
import com.msz.demo.service.MszServiceManager.Companion.getServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppConfigController {

    @GetMapping("/appConfig")
    fun appConfig(@RequestBody token: TokenRequest): RespondInfo<String?> {
        if (token.token == null) {
            return buildConfigErrorRespond()
        }
        return getServiceImpl<AppService>().checkTokenAndRespond(token)
    }


}
package com.msz.demo.service.impl

import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.buildConfigErrorRespond
import com.msz.demo.info.respone.simple
import com.msz.demo.service.AppService

class AppServiceImpl :AppService{
    override fun checkTokenAndRespond(token: TokenRequest): RespondInfo<String?> {

        if(token.token == "linhui"){
            return simple(data = "1")
        }
        return buildConfigErrorRespond()
    }
}
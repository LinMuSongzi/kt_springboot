package com.msz.demo.service

import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.RespondInfo

interface AppService {
    fun checkTokenAndRespond(token: TokenRequest): RespondInfo<String?>
}
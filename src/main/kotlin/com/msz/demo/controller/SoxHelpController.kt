package com.msz.demo.controller

import com.msz.demo.info.request.TokenRequest
import com.msz.demo.info.respone.EffectsBean
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.service.SoxService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class SoxHelpController {

    @Autowired
    lateinit var soxService:SoxService

    @PostMapping("/getEffects")
    fun getEffects(@RequestBody request: TokenRequest): RespondInfo<List<EffectsBean>> = if (request.token == "msz") {
        soxService.holderEffectsData()
    } else {
        error("token error")
    }

    @GetMapping("/getEffects2")
    fun getEffects2(): RespondInfo<List<EffectsBean>> = soxService.holderEffectsData()


}
package com.msz.demo.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OneController {


    @RequestMapping("/msz1")
    fun helloWorld():String{
        return "hello world"
    }



    @GetMapping("/msz2")
    fun myFirstTest(@RequestParam stringValue:String):String{
        return "hello world show = $stringValue"
    }

}
package com.msz.demo.bean

class FileInfo(
    val name: String,
    val path: String,
    val fileType:Int,
    val cover: String? = null,
    val createTime: Long? = null,
    val fileFormat: String? = null,
    val allName: String? = null,
    token: String
) : TokenInfo(token)

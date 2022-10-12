package com.msz.demo.info.respone

import com.msz.demo.info.request.TokenRequest

data class RespondInfo<T>(var code: Int, var msg: String, var data: T? = null)



@JvmOverloads
fun <T> simple(code: Int = RESULT_CODE_OK, msg: String = DEFAULT_RESPONE_MSG, data: T): RespondInfo<T> {
    return RespondInfo(code, msg, data)
}
fun buildConfigRespond(token: TokenRequest): RespondInfo<String> {
    return simple(data = "");
}

const val RESULT_CODE_OK = 200;
const val DEFAULT_RESPONE_MSG = "1"




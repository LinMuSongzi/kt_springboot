package com.msz.demo.info.respone

import com.msz.demo.info.request.TokenRequest

data class RespondInfo<T>(var code: Int, var msg: String, var data: T? = null)


@JvmOverloads
fun <T> simple(code: Int = RESULT_CODE_OK, msg: String = DEFAULT_RESPONE_MSG, data: T? = null): RespondInfo<T> {
    return RespondInfo(code, msg, data)
}
//
//fun buildConfigRespond(token: TokenRequest): RespondInfo<String> {
//    return simple(data = "");
//}

fun buildConfigErrorRespond(): RespondInfo<String?> {
    return simple(RESULT_CODE_ERROR, TOKEN_ERROR_MSG, null)
}

const val RESULT_CODE_ERROR = -1
const val RESULT_CODE_OK = 200


const val TOKEN_ERROR_MSG = "token error"
const val DEFAULT_RESPONE_MSG = "1"





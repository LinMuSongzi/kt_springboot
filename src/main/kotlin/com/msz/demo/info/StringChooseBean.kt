package com.msz.demo.info


class StringChooseBean(s: String? = null)  {

    var title = s

}

fun String.bean():StringChooseBean{
    return StringChooseBean(this)
}
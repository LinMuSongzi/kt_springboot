package com.msz.demo.info.respone


data class EffectsBean(
    val c_name: String?,
    val content: String?,
    val e_name: String?,
    val r_name:String? = e_name,
    val parent:String? = null,
    val e_child: List<EffectsBean>? = null
){
    constructor(c_name: String?,e_child: List<EffectsBean>?):this(c_name, null, null, null, null,e_child = e_child)
}
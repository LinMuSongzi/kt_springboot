package com.msz.demo.service.impl

import com.msz.demo.bean.DiskInfo
import com.msz.demo.bean.FileInfo
import org.springframework.stereotype.Service
import java.io.File
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


@Service
class FileService {

    companion object {
        const val ROOT = "root_msz"
        const val ROOT_TIME = "-1L"

        const val DIR_TYPE = 1
        const val FILE_TYPE = 2
        const val debug = false
    }

    val cacheAcceseKeyMap = HashMap<String, String>().apply {
        put(ROOT, ROOT_TIME)
    }

    val cacheTokenMap = HashMap<String, String>().apply {
        put(ROOT, ROOT_TIME)
    }


    fun findPath(acceseKey: String, token: String): File? {
        println("findPath:token = $token")
        return cacheAcceseKeyMap[acceseKey]?.let {
            cacheTokenMap[token]?.let { fn ->
                File(fn)
            }
        }
    }


    fun loaderDiskInfo(acceseKey: String): List<DiskInfo> = mutableListOf<DiskInfo>().apply {
        cacheAcceseKeyMap[acceseKey]?.apply {
            File.listRoots().forEach {
                add(DiskInfo(it.absolutePath, getMD5ByPath(it.absolutePath), null))
            }
        }
    }

    fun loadDirFiles(acceseKey: String, pth: String): List<FileInfo> = mutableListOf<FileInfo>().let { list ->
        println("loadDirFiles:  p  =  $pth")
        val path = getPathByMd5(pth)
        if (cacheAcceseKeyMap[acceseKey] != null && path != null) {
            println("loadDirFiles:path = $path")
//            cacheTokenMap[path]?.apply {
            val f = File(path)
            println("loadDirFiles: isexite = " + f.exists())
            f.listFiles()?.filter {
                list.add(
                    FileInfo(
                        it.name,
                        fileType = if (it.isDirectory) 1 else 2,
                        path = getMD5ByPath(it.absolutePath),
                        token = ROOT
                    )
                )
            }
        }
        list
    }

    private fun getPathByMd5(md5: String): String? {
        return if(debug){
            md5
        }else {
            cacheTokenMap[md5]
        }
    }

    private fun getMD5ByPath(absolutePath: String): String {
        return if(debug){
            absolutePath
        }else {
            val md5 = mad5(absolutePath) ?: ""
            cacheTokenMap[md5].run {
                if (isNullOrEmpty()) {

                    cacheTokenMap[md5] = absolutePath
                }
                md5
            }
        }
    }

    fun mad5(key: String): String? {
        val hexDigests = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
        return try {
            val `in` = key.toByteArray()
            val messageDigest: MessageDigest = MessageDigest.getInstance("md5")
            messageDigest.update(`in`)
            // 获得密文
            val md: ByteArray = messageDigest.digest()
            // 将密文转换成16进制字符串形式
            val j = md.size
            val str = CharArray(j * 2)
            var k = 0
            for (i in 0 until j) {
                val b = md[i]
                str[k++] = hexDigests[b.toInt() ushr 4 and 0xf] // >>> 无符号右移。这里将字节b右移4位，低位抛弃，就等于是高4位于0xf做与运算。4位最多表示15。
                str[k++] = hexDigests[b.toInt() and 0xf] //用 1字节=8位，与0xf与运算，高4位必为0，就得到了低四位的数。
            }
            String(str)
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            throw RuntimeException("md5加密失败", e)
        }
    }
}
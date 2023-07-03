package com.msz.demo.service.impl

import com.msz.demo.bean.DiskInfo
import com.msz.demo.bean.FileInfo
import org.springframework.stereotype.Service
import sun.management.FileSystem
import java.io.File
import java.util.Arrays

@Service
class FileService {

    companion object {
        const val ROOT = "root_msz"
        const val ROOT_TIME = -1L

        const val DIR_TYPE = 1
        const val FILE_TYPE = 2
    }

    val cacheAcceseKeyMap = HashMap<String, Long>().apply {
        put(ROOT, ROOT_TIME)
    }

    val cacheTokenMap = HashMap<String, Long>().apply {
        put(ROOT, ROOT_TIME)
    }


    fun findPath(acceseKey: String, token: String): File? {
        return cacheAcceseKeyMap[acceseKey]?.let {
            File(token)
        }
    }


    fun loaderDiskInfo(acceseKey: String): List<DiskInfo> = mutableListOf<DiskInfo>().apply {
        cacheAcceseKeyMap[acceseKey]?.apply {
            File.listRoots().forEach {
                add(DiskInfo(it.name,it.absolutePath,null))
            }
        }
    }

    fun loadDirFiles(acceseKey: String, path: String): List<FileInfo> = mutableListOf<FileInfo>().let { list ->
        val acceseKey = cacheAcceseKeyMap[acceseKey]

        if (acceseKey != null) {
            println("path = $path")
//            cacheTokenMap[path]?.apply {
                val f = File(path)
                println("f isexite = "+f.exists())
                f.listFiles()?.filter {
                    list.add(
                        FileInfo(
                            it.absolutePath,
                            fileType = if (it.isDirectory) 1 else 2,
                            path = it.absolutePath,
                            token = ROOT
                        )
                    )
                    false
                }

//            }
        }
        list
    }

    fun getFilePath(acceseKey: String, token: String): String? {
        TODO("Not yet implemented")
    }
}
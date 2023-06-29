package com.msz.demo.service.impl

import com.msz.demo.bean.DiskInfo
import com.msz.demo.bean.FileInfo
import org.springframework.stereotype.Service
import java.io.File

@Service
class FileService {
    fun findPath(acceseKey: String, token: String): File? {
        TODO("Not yet implemented")
    }


    fun loaderDiskInfo(acceseKey: String):List<DiskInfo> {
        TODO("Not yet implemented")
    }

    fun loadDirFiles(acceseKey: String, dirToken: String): List<FileInfo> {
        TODO("Not yet implemented")
    }

    fun getFilePath(acceseKey: String, token: String): String? {
        TODO("Not yet implemented")
    }
}
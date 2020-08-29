package com.example.androidtest.data.respositories

import com.example.androidtest.data.datasource.network.FileService
import com.example.androidtest.data.models.FileApi
import com.example.androidtest.data.utils.Resource
import com.example.androidtest.interfaces.FileRepository

class FileRepositoryImpl(
    val fileService: FileService
):FileRepository {


    override suspend fun getFile(): Resource<FileApi> {
        TODO("Not yet implemented")
    }
}
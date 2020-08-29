package com.example.androidtest.interfaces

import com.example.androidtest.data.models.FileApi
import com.example.androidtest.data.utils.Resource

interface FileRepository {
    suspend fun getFile(): Resource<FileApi>
}
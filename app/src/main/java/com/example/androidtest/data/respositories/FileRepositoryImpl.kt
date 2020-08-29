package com.example.androidtest.data.respositories

import com.example.androidtest.data.datasource.network.FileService
import com.example.androidtest.data.models.FileApi
import com.example.androidtest.data.utils.Resource
import com.example.androidtest.interfaces.FileRepository
import org.json.JSONException
import java.io.IOException
import java.net.SocketTimeoutException

class FileRepositoryImpl(
    val fileService: FileService
):FileRepository {


    override suspend fun getFile(): Resource<FileApi> {
        val resource = Resource<FileApi>(Resource.Status.LOADING,null,null)
        try {
            val dl=0
            val response = fileService.getFile(dl)
            if(response.isSuccessful && response.body()!=null){
                resource.data=response.body()
                resource.status=Resource.Status.SUCCESS
                resource.message=response.message()
            }else{
                resource.message = response.message()
                resource.status = Resource.Status.ERROR
                resource.data = response.body()
            }
        }catch (ex: JSONException) {
            resource.message = ex.message
            resource.status = Resource.Status.ERROR
            resource.data = null
            ex.printStackTrace()
        } catch (ex: SocketTimeoutException) {
            resource.message = ex.message
            resource.status = Resource.Status.ERROR
            resource.data = null
            ex.printStackTrace()
        }catch (ex: IOException) {
            resource.message = ex.message
            resource.status = Resource.Status.ERROR
            resource.data = null
            ex.printStackTrace()
        }

        return resource
    }
}
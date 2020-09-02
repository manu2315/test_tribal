package com.example.androidtest.data.respositories

import com.example.androidtest.data.datasource.database.Dao.UnsplashDao
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.interfaces.UnsplashRepository
import org.koin.core.KoinComponent

class UnsplashRepositoryImpl(
    val unsplashDao: UnsplashDao
):UnsplashRepository, KoinComponent {
    override fun insertAll(vararg unsplashPhoto: UnsplashPhoto_Entity) {
        unsplashDao.insertAll(*unsplashPhoto)
    }

    override fun insertByList(unsplashPhoto: List<UnsplashPhoto_Entity>) {
        unsplashDao.insertByList(unsplashPhoto)
    }

    override fun delete(unsplashPhoto: UnsplashPhoto_Entity) {
        unsplashDao.delete(unsplashPhoto)
    }

    override suspend fun getAll(): List<UnsplashPhoto_Entity> {
       return unsplashDao.getAll()
    }

    override suspend fun loadAllByIds(userIds: IntArray): List<UnsplashPhoto_Entity> {
        return unsplashDao.loadAllByIds(userIds)
    }

    override suspend fun loadById(id: Int): UnsplashPhoto_Entity {
        return unsplashDao.loadById(id)
    }


}
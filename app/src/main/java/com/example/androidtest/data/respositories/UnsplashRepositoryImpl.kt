package com.example.androidtest.data.respositories

import com.example.androidtest.data.datasource.database.Dao.UnsplashDao
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.interfaces.UnsplashRepository
import org.koin.core.KoinComponent

class UnsplashRepositoryImpl(
    val unsplashDao: UnsplashDao
):UnsplashRepository, KoinComponent {
    override fun insertAll( unsplashPhoto: UnsplashPhoto_Entity): Long {
        return  unsplashDao.insertAll(unsplashPhoto)
    }

    override fun insertByList(unsplashPhoto: List<UnsplashPhoto_Entity>): List<Long> {
        return  unsplashDao.insertByList(unsplashPhoto)
    }

    override fun delete(unsplashPhoto: UnsplashPhoto_Entity): Int {
       return unsplashDao.delete(unsplashPhoto)
    }

    override fun update(unsplashPhoto: UnsplashPhoto_Entity) {
        unsplashDao.update(unsplashPhoto)
    }

    override suspend fun getAll(): List<UnsplashPhoto_Entity> {
       return unsplashDao.getAll()
    }

    override suspend fun findListByIds(userIds: IntArray): List<UnsplashPhoto_Entity> {
        return unsplashDao.findListByIds(userIds)
    }

    override suspend fun findById(id: Int): UnsplashPhoto_Entity {
        return unsplashDao.findById(id)
    }

}
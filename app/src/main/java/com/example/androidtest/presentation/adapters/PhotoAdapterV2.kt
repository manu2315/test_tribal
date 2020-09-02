package com.example.androidtest.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.data.models.UnsplashPhoto
import com.example.androidtest.interfaces.IPhotoAdapterV2

class PhotoAdapterV2 (
    private val iPhotoAdapterV2: IPhotoAdapterV2,
    private val mListOfPhotos: MutableList<UnsplashPhoto_Entity> = mutableListOf()
) :RecyclerView.Adapter<PhotoViewHolderV2>(){

    fun setData(dataSet: MutableList<UnsplashPhoto_Entity>){
        mListOfPhotos.clear()
        mListOfPhotos.addAll(dataSet)
        notifyDataSetChanged()
    }

    fun removeData(position: Int){
        mListOfPhotos.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolderV2 {
        return PhotoViewHolderV2.from(parent)
    }

    override fun onBindViewHolder(holder: PhotoViewHolderV2, position: Int) {
        holder.bind(mListOfPhotos[position],position,iPhotoAdapterV2)
    }

    override fun getItemCount(): Int = mListOfPhotos.size

}
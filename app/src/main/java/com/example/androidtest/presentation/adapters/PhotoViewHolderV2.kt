package com.example.androidtest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.databinding.RowFavoritePictureBinding
import com.example.androidtest.interfaces.IPhotoAdapterV2
import timber.log.Timber

class PhotoViewHolderV2 (val binding:RowFavoritePictureBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(
        item: UnsplashPhoto_Entity,
        position:Int,
        iPhotoAdapterV2: IPhotoAdapterV2
    ){
        binding.item=item
        Timber.e("photo photoViewHolder")
        iPhotoAdapterV2.removeData(position)
        binding.executePendingBindings()
    }

    companion object{
        fun from(parent:ViewGroup):PhotoViewHolderV2{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowFavoritePictureBinding.inflate(layoutInflater,parent,false)
            return PhotoViewHolderV2(binding)
        }
    }
}
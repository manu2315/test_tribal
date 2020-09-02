package com.example.androidtest.presentation.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidtest.R
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.databinding.FragmentPhotosBinding
import com.example.androidtest.domain.PhotosViewModel
import com.example.androidtest.interfaces.IPhotoAdapterV2
import com.example.androidtest.presentation.adapters.PhotoAdapter
import com.example.androidtest.presentation.adapters.PhotoAdapterV2
import com.example.androidtest.presentation.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PhotosFragment : BaseFragment(),IPhotoAdapterV2 {
    private lateinit var mAdapter:PhotoAdapterV2
    val viewModel: PhotosViewModel by sharedViewModel()
    private val binding:FragmentPhotosBinding by lazy {
        FragmentPhotosBinding
            .inflate(LayoutInflater.from(context),null,false)
            //.apply {  }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner=this.viewLifecycleOwner
        observerFavorites()
        setupRecyclerView()
        getFavoritesPhotos()
    }

    private fun setupRecyclerView(){
        binding.favoritesRecyclerView
        binding.favoritesRecyclerView.setHasFixedSize(true)
        binding.favoritesRecyclerView.itemAnimator = null
        binding.favoritesRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        mAdapter = PhotoAdapterV2(this)
        binding.favoritesRecyclerView.adapter = mAdapter
    }
    private fun jobGetFavorites()=viewModel.getAll()
    private fun getFavoritesPhotos(){
        GlobalScope.launch(Dispatchers.Main) {
            showProgressBar()
            jobGetFavorites().join()
            hideProgressBar()
        }
    }

    private fun observerFavorites(){
        viewModel.photoListSaved.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty()){
                binding.containerErrorImages.visibility=View.GONE
                mAdapter.setData(it.toMutableList())
            }else{
                binding.containerErrorImages.visibility=View.VISIBLE
                mAdapter.setData(mutableListOf<UnsplashPhoto_Entity>())
            }
        })
    }

    private fun deleteFavoritesPhotos(item: UnsplashPhoto_Entity){
        fun jobDeletedFavorites()=viewModel.delete(item)
        GlobalScope.launch(Dispatchers.Main) {
            showProgressBar()
            jobDeletedFavorites().join()
            hideProgressBar()
            getFavoritesPhotos()
        }
    }
    override fun setData(dataSet: MutableList<UnsplashPhoto_Entity>) {
        TODO("Not yet implemented")
    }

    override fun removeData(position: Int, item: UnsplashPhoto_Entity) {
        deleteFavoritesPhotos(item)


    }


}
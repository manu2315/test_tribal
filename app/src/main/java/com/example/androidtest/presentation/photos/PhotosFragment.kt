package com.example.androidtest.presentation.photos

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getColor
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidtest.R
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.databinding.FragmentPhotosBinding
import com.example.androidtest.domain.PhotosViewModel
import com.example.androidtest.interfaces.IPhotoAdapterV2
import com.example.androidtest.presentation.adapters.PhotoAdapterV2
import com.example.androidtest.presentation.base.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PhotosFragment : BaseFragment(),IPhotoAdapterV2 {
    private lateinit var mAdapter:PhotoAdapterV2
    val viewModel: PhotosViewModel by sharedViewModel()
    private val binding:FragmentPhotosBinding by lazy {
        FragmentPhotosBinding
            .inflate(LayoutInflater.from(context), null, false)
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
        //setupToolbar(binding.toolbar,getString(R.string.favorite),R.menu.menu_search_picture)
        setupSearchWidget()
        observerFavorites()
        setupRecyclerView()
        getFavoritesPhotos()
        setupCurrentEntity()
    }

    private fun setupSearchWidget(){
        val searchView = binding.search
        val searchEditText =
            searchView.findViewById<View>(androidx.appcompat.R.id.search_src_text) as EditText
        searchEditText.setTextColor(getColor(requireContext(),R.color.colorPrimaryLightColor))
        searchEditText.setHintTextColor(getColor(requireContext(),R.color.colorSecondaryTextColor))
        setupSearchView(binding.search)
    }


    private fun setupSearchView(searchView: SearchView){
        searchViewQuery(
            searchView,
            {viewModel.searchByQuery(it)},
            {viewModel.searchByQuery(it)},
            {getFavoritesPhotos()})
    }


    private fun setupCurrentEntity(){
        if(viewModel.currentEntity.value !=null){
            binding.current=viewModel.currentEntity.value
            Picasso.get().load(viewModel.currentEntity.value!!.user.profile_image.medium).into(
                binding.profileImage
            )
        }
        /*else{
            binding.favoritesDescription.text=getString(R.string.no_description)
        }*/

    }
    private fun setupRecyclerView(){
        binding.favoritesRecyclerView
        binding.favoritesRecyclerView.setHasFixedSize(true)
        binding.favoritesRecyclerView.itemAnimator = null
        binding.favoritesRecyclerView.layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
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
            if (!it.isNullOrEmpty()) {
                binding.containerErrorImages.visibility = View.GONE
                mAdapter.setData(it.toMutableList())
            } else {
                binding.containerErrorImages.visibility = View.VISIBLE
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
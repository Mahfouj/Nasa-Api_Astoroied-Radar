package com.example.nasa_api_astoroied_radar.Views.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nasa_api_astoroied_radar.R
import com.example.nasa_api_astoroied_radar.databinding.FragmentHomeBinding

import androidx.databinding.DataBindingUtil
 import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.nasa_api_astoroied_radar.Adapter.NearEarthAdapter
import com.squareup.picasso.Picasso


class HomeFragment : Fragment() {

      val viewModel by viewModels<HomeViewModel>()
     lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: NearEarthAdapter

     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
         binding.lifecycleOwner = viewLifecycleOwner
         binding.viewModel = viewModel

     return binding.root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.imageOfTheDay.observe(viewLifecycleOwner) { imageOfTheDay ->
            imageOfTheDay?.let {
                Picasso.get()
                    .load(it.url)
                    .into(binding.imageViewOfTheDay)

                binding.tvTitle.text = it.title
            }
        }

        viewModel.getAllImageOfTheDayFromDb().observe(viewLifecycleOwner) { imageOfTheDay ->
            val slideModels = imageOfTheDay.map { image ->
                SlideModel(image.hdurl, image.title)
            }
            binding.imageSlider.setImageList(slideModels)
        }

        viewModel.asteroidList.observe(viewLifecycleOwner){
            adapter = NearEarthAdapter(it){asteroid ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(asteroid)
                findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
        }
    }

}










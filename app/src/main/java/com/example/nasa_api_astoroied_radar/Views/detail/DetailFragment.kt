package com.example.nasa_api_astoroied_radar.Views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
 import com.example.nasa_api_astoroied_radar.databinding.FragmentDetailBinding
import com.example.nasa_api_astoroied_radar.db.model.Asteroid

class DetailFragment : Fragment() {



 lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

      binding = FragmentDetailBinding.inflate(inflater,container,false)



return binding.root

     }


}
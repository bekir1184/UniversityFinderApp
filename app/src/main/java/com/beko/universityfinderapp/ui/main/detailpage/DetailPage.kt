package com.beko.universityfinderapp.ui.main.detailpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.beko.universityfinderapp.R
import com.beko.universityfinderapp.databinding.FragmentDetailPageBinding

class DetailPage : Fragment() {
    private val navArgs :  DetailPageArgs by navArgs()
    private lateinit var binding : FragmentDetailPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPageBinding.inflate(inflater,container,false)

        binding.detailPageTV.text = navArgs.model.name +" : "+ navArgs.model.country+" : "+ navArgs.model.webPages
        return binding.root
    }

}
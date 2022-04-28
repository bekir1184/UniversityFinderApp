package com.beko.universityfinderapp.ui.main.homepage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.beko.universityfinderapp.databinding.FragmentHomepageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Homepage : Fragment() {
    private lateinit var binding : FragmentHomepageBinding
    private val homePageViewModel : HomePageViewModel by viewModels()
    private var homeAdapter = HomepageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater,container,false)
        binding.uniRecyclerView.adapter = homeAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerView()
        setOnClicks()
        homePageViewModel.universityList.value.also {
            if(it.isNullOrEmpty()){
                binding.progressBar.visibility = View.VISIBLE
                homePageViewModel.getUniversities().also { setupObserver() }
            }else{
                homeAdapter.submitList(it).also {
                    binding.progressBar.visibility = View.INVISIBLE
                }

            }
        }
    }

    private fun setOnClicks() {

        homeAdapter.setOnItemClickListener {
            println("skfndfngl")
            val action  = HomepageDirections.actionHomepageToDetailPage(it)
            findNavController().navigate(action)
        }
    }


    private fun setupObserver() {
        homePageViewModel.universityList.observe(this.viewLifecycleOwner, Observer { list ->
            homeAdapter.submitList(list)
            binding.progressBar.visibility = View.INVISIBLE
        })

    }


    @SuppressLint("WrongConstant")
    private fun setRecyclerView() {
        binding.uniRecyclerView.layoutManager  = LinearLayoutManager(context, LinearLayout.VERTICAL,false)

        binding.uniRecyclerView.apply {
            adapter = homeAdapter
        }
    }
}
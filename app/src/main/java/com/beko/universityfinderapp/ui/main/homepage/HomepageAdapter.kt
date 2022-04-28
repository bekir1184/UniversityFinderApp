package com.beko.universityfinderapp.ui.main.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beko.universityfinderapp.R
import com.beko.universityfinderapp.databinding.UniItemBinding
import com.beko.universityfinderapp.model.University


class HomepageAdapter
    :ListAdapter<University,HomepageAdapter.CustomViewHolder>(customCallBack)   {

    private var onItemClickListener : ((university : University) -> Unit) ?= null

    fun setOnItemClickListener(onItemClicklistener :((university : University) -> Unit)?){
        this.onItemClickListener = onItemClicklistener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.uni_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class CustomViewHolder(private val binding: UniItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(
                    getItem(adapterPosition)
                )
            }
        }
        fun bind(university: University){
            binding.model = university
        }
    }

    companion object {
        val customCallBack = object : DiffUtil.ItemCallback<University>(){
            override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
                return oldItem == newItem
            }

        }
    }


}

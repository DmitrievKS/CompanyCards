package com.kirdmt.simpleplayer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kirdmt.companycards.R
import com.kirdmt.companycards.data.Company
import com.kirdmt.companycards.databinding.CompanyItemBinding
import com.kirdmt.simpleplayer.utils.Constants


import com.squareup.picasso.Picasso


class CompanyAdapter(
    private val context: Context,
    private var companyResult: List<Company>,
    private var listener: OnItemClickListener

) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    private var items: List<Company> = companyResult

    /*init{

    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CompanyItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.with(context)
            .load(Constants.BASE_URL + items.get(position).img)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)

        holder.bind(items.get(position), listener)
    }

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int, id: String)
    }

    inner class ViewHolder(private var binding: CompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var imageView: ImageView = binding.companyImg

        fun bind(company: Company?, listener: OnItemClickListener?) {
            binding.company = company

            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition, items.get(layoutPosition).id) })
            }

            binding.executePendingBindings()
        }
    }


}
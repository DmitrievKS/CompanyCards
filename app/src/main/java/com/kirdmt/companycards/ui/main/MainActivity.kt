package com.kirdmt.companycards.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirdmt.companycards.R
import com.kirdmt.companycards.databinding.ActivityMainBinding
import com.kirdmt.companycards.ui.CompanyViewModel
import com.kirdmt.companycards.ui.detail.DetailCompanyActivity
import com.kirdmt.simpleplayer.ui.adapter.CompanyAdapter

class MainActivity : AppCompatActivity(), CompanyAdapter.OnItemClickListener {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = CompanyViewModel()
        bindData()
        getCompanyList()
    }

    private fun bindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        binding.companyRecycler.layoutManager = LinearLayoutManager(this)

    }

    private fun getCompanyList() {

        viewModel.getCompanyList().observe(this, androidx.lifecycle.Observer { resource ->

            binding.companyRecycler.adapter = CompanyAdapter(this, resource, this)
            Log.d("ResultTag", "There are ${resource.toString()} ")
        })
    }

    override fun onItemClick(position: Int, id: String) {

        val detailCompanyActivityIntent: Intent = Intent(this, DetailCompanyActivity::class.java).setFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK
        )
        detailCompanyActivityIntent.putExtra("id", id)
        startActivity(detailCompanyActivityIntent)
    }
}

package com.kirdmt.companycards.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirdmt.companycards.R
import com.kirdmt.companycards.databinding.ActivityDetailCompanyBinding
import com.kirdmt.companycards.databinding.ActivityMainBinding
import com.kirdmt.companycards.ui.CompanyViewModel
import com.kirdmt.simpleplayer.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_company.*

class DetailCompanyActivity : AppCompatActivity() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var binding: ActivityDetailCompanyBinding
    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_company)

        id  = intent.getStringExtra("id")

        viewModel = CompanyViewModel()

        getCompanyDetails()
    }

    private fun getCompanyDetails() {

        viewModel.getDetailedCompany(id).observe(this, androidx.lifecycle.Observer { resource ->

            Picasso.with(this)
                .load(Constants.BASE_URL + resource.img)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(company_img)

            company_name.setText(resource.name)
            company_id.setText(resource.id)
            company_description.setText(resource.description)
            company_www.setText(resource.www)
            company_phone.setText(resource.phone)
            company_lat.setText(resource.lat)
            company_lon.setText(resource.lon)

            Log.d("ActivityResultTag", "There are ${resource.description} ")

        })

    }
}

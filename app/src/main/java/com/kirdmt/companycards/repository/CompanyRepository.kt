package com.kirdmt.simpleplayer.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kirdmt.companycards.data.Company
import com.kirdmt.companycards.data.CompanyDetails
import com.kirdmt.companycards.data.CompanyResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CompanyRepository() {

    fun getCompanyList(): MutableLiveData<List<Company>> {

        val companyResultLiveData: MutableLiveData<List<Company>> = MutableLiveData()

        val retrofitInstance = ApiService.create()
        retrofitInstance.getCompanyList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->

                companyResultLiveData.value = result

            }, { error ->
                //kotlin.error.printStackTrace()
                Log.d("ErrorTag", "There are ${error.toString()} ")
            })
        return companyResultLiveData
    }

    fun getDetailedCompany(id: String): MutableLiveData<CompanyDetails> {

        val companyDetailsLiveData: MutableLiveData<CompanyDetails> = MutableLiveData()

        val retrofitInstance = ApiService.create()
        retrofitInstance.getDetailedCompany(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->

                companyDetailsLiveData.value = result.get(0)
            }, { error ->
                //kotlin.error.printStackTrace()
                Log.d("ErrorTag", "There are ${error.toString()} ")
            })

        return companyDetailsLiveData
    }

}
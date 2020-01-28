package com.kirdmt.companycards.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirdmt.companycards.data.Company
import com.kirdmt.companycards.data.CompanyDetails
import com.kirdmt.simpleplayer.repository.CompanyRepository

class CompanyViewModel(
) : ViewModel() {
    private var companyRepository: CompanyRepository = CompanyRepository()
    var companyDetails: MutableLiveData<CompanyDetails> = MutableLiveData()

    fun getCompanyList(): MutableLiveData<List<Company>> {
        return companyRepository.getCompanyList()
    }

    fun getDetailedCompany(id: String) : MutableLiveData<CompanyDetails> {
        return companyRepository.getDetailedCompany(id)
        //Log.d("ResultTagVM", "There are ${companyDetails.value.toString()} ")
    }

}
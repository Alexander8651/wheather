package com.amatai.weather.ui.viewmodels

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.*
import com.amatai.weather.data.repository.Repository
import com.amatai.weather.databinding.DialogcitieslayoutBinding
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import kotlinx.coroutines.launch

class ViewmodelHomeFragment(private val repository: Repository) : ViewModel(){

    val _getCitiesFromApi = MutableLiveData<List<CitySearchResponse>>()
    val getCitiesFromApi  : LiveData<List<CitySearchResponse>>
        get() = _getCitiesFromApi

    fun setUpSearchView(
        bindingBotonSheetDialog: DialogcitieslayoutBinding
        //adapter: ProductoAdapter
    ) {
        bindingBotonSheetDialog.searchCity.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                viewModelScope.launch {
                    val cities = repository.getCitiesFromApi(query!!)
                    _getCitiesFromApi.postValue(cities)
                }

                //setProducto(query!!)
                bindingBotonSheetDialog.searchCity.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //adapter.filter(newText)
                return false
            }
        })
    }


}
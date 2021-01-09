package com.amatai.weather.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.amatai.weather.R
import com.amatai.weather.data.DataSources
import com.amatai.weather.data.repository.RepositoryImpl
import com.amatai.weather.databinding.DialogcitieslayoutBinding
import com.amatai.weather.databinding.FragmentHomeFragmetnBinding
import com.amatai.weather.ui.adapters.CityAdapter
import com.amatai.weather.ui.viewmodels.VMFactory
import com.amatai.weather.ui.viewmodels.ViewmodelHomeFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragmetnFragment : Fragment() {

    val viewmodelHomeFragment by viewModels<ViewmodelHomeFragment> {
    VMFactory(RepositoryImpl(DataSources()))
    }

    lateinit var bindingBotonSheetDialog: DialogcitieslayoutBinding

    lateinit var cityAdapter:CityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeFragmetnBinding.inflate(inflater, container, false)
        context ?: binding.root

        binding.floatingActionButton.setOnClickListener {
            setUpRecyclerProductosBotonSheet()
            viewmodelHomeFragment.setUpSearchView(bindingBotonSheetDialog)
        }
        return binding.root
    }

    fun setUpRecyclerProductosBotonSheet() {

        cityAdapter = CityAdapter()

        val view = layoutInflater.inflate(R.layout.dialogcitieslayout, null)
        bindingBotonSheetDialog = DialogcitieslayoutBinding.bind(view)

        val dialog = BottomSheetDialog(requireContext(), R.style.DialogStyle)
        val close = bindingBotonSheetDialog.closeDialog
        bindingBotonSheetDialog.searchCity.queryHint = "What city do you want to search?"
        close.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()

        viewmodelHomeFragment.getCitiesFromApi.observe(viewLifecycleOwner, Observer {
            Log.d("cities", it.toString())

            bindingBotonSheetDialog.rvCity.apply {
                adapter = cityAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
            cityAdapter.submitList(it)
            if (it.isEmpty()){
                Toast.makeText(requireContext(), "This city don't exist", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
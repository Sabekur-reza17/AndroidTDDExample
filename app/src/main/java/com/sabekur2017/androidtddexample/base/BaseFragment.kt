package com.sabekur2017.androidtddexample.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.sabekur2017.androidtddexample.loacldata.SpendsDatabase
import com.sabekur2017.androidtddexample.loacldata.SpendsTrackerDataSource
import com.sabekur2017.androidtddexample.ui.SpendViewModel

abstract class BaseFragment(@LayoutRes layout:Int):Fragment(layout) {
    protected lateinit var viewModel: SpendViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = SpendsDatabase(requireContext())
        val dataSource = SpendsTrackerDataSource(db.getSpendDao())
        viewModel = SpendViewModel(dataSource)
    }
}
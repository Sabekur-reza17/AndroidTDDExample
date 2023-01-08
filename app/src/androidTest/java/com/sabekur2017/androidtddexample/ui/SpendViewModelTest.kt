package com.sabekur2017.androidtddexample.ui

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.sabekur2017.androidtddexample.getOrAwaitValue
import com.sabekur2017.androidtddexample.loacldata.SpendsDatabase
import com.sabekur2017.androidtddexample.loacldata.SpendsTrackerDataSource
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class SpendViewModelTest {
    private lateinit var viewModel: SpendViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, SpendsDatabase::class.java)
            .allowMainThreadQueries().build()
        val dataSource = SpendsTrackerDataSource(db.getSpendDao())
        viewModel = SpendViewModel(dataSource)
    }

    @Test
    fun testSpendViewModel() {
        viewModel.addSpend(150, "view model test")
        viewModel.getLast20Spends()
        val result = viewModel.last20SpendsLiveData.getOrAwaitValue().find {
            it.amount == 150 && it.description == "view model test"
        }
        assertThat(result != null).isTrue()
    }

}
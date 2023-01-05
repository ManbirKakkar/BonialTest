package io.bonial.test.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.bonial.test.data.api.ApiHelper
import io.bonial.test.data.repository.MainRepository
import io.bonial.test.ui.main.viewmodel.BrochureViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BrochureViewModel::class.java)) {
            return BrochureViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}


package io.bonial.test.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.bonial.test.data.repository.MainRepository
import io.bonial.test.utils.Resource
import kotlinx.coroutines.Dispatchers

class BrochureViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getBrochure() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getBrochure().Embedded?.contents))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}
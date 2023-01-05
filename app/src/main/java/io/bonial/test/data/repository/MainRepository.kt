package io.bonial.test.data.repository

import io.bonial.test.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getBrochure() = apiHelper.getBrochure()
}
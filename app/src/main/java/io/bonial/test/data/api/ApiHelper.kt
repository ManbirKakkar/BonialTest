package io.bonial.test.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getBrochure() = apiService.getBrochure()
}
package io.bonial.test.data.api

import io.bonial.test.data.model.BrochureData
import retrofit2.http.GET

interface ApiService {
    @GET("stories-test/shelf.json")
    suspend fun getBrochure(): BrochureData
}
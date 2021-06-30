package az.zero.azunsplashimage.api

import az.zero.azunsplashimage.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_ACCESS_KEY = BuildConfig.API_ACCESS_KEY
    }

    @Headers("Accept-Version: v1" ,"Authorization: Client-ID $API_ACCESS_KEY")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnSplashResponse
}
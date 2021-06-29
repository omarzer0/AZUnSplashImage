package az.zero.azunsplashimage.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import az.zero.azunsplashimage.api.UnSplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnSplashRepository @Inject constructor(private val unSplashApi: UnSplashApi) {
    fun getSearchResults(query: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { UnSplashPagingSource(unSplashApi, query) }
    ).liveData
}
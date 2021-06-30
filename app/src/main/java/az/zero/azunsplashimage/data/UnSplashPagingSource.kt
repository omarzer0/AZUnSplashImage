package az.zero.azunsplashimage.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import az.zero.azunsplashimage.api.UnSplashApi

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnSplashPagingSource(
    private val unSplashApi: UnSplashApi,
    private val query: String
) : PagingSource<Int, UnSplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            val response = unSplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                // data is empty then we reached the end of pages
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnSplashPhoto>): Int? = state.anchorPosition
}
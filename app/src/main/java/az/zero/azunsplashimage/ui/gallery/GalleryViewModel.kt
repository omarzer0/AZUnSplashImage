package az.zero.azunsplashimage.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import az.zero.azunsplashimage.data.UnSplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnSplashRepository,
//    @Assisted state: SavedStateHandle
) : ViewModel() {

    //    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { query ->
        repository.getSearchResults(query).cachedIn(viewModelScope)
    }


    fun searchPhotos(query: String) {
        currentQuery.value = query
    }


    companion object {
        //        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "cats"
    }
}
package az.zero.azunsplashimage.api

import az.zero.azunsplashimage.data.UnSplashPhoto

data class UnSplashResponse(
    val results: List<UnSplashPhoto>
)
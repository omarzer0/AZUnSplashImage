package az.zero.azunsplashimage.data

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class UnSplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnSplashPhotoUrls,
    val user: UnSplashUser,
) : Parcelable {
    @kotlinx.parcelize.Parcelize
    data class UnSplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable

    @kotlinx.parcelize.Parcelize
    data class UnSplashUser(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl
            get() = "https://unsplash.com/$username?utm_source-AZUnSplashImage&utm_medium-referral"
    }
}
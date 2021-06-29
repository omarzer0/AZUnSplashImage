package az.zero.azunsplashimage.data

import android.content.res.Resources
import android.os.Parcelable
import az.zero.azunsplashimage.R

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
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable

    @kotlinx.parcelize.Parcelize
    data class UnSplashUser(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl
            get() = "https://unsplash.com/$username?utm_source-${
                Resources.getSystem().getString(R.string.app_name)
            }&utm_medium-referral"
    }
}
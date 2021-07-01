# AZUnSplashImage

App for searching wonderful images using [UnSplash Api](https://unsplash.com/)


## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- Dagger Hilt for dependency injection.
- JetPack
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - ViewBinding - Interact with XML views in safeway and avoid findViewById() 
  - Navigation Component - Make it easy to navigate betwwen different screens and pass data in type-safe way
- Architecture
  - MVVM Architecture (View - ViewModel - Model)
  - Repository pattern
- [Glide](https://github.com/bumptech/glide) for loading images.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like cardView

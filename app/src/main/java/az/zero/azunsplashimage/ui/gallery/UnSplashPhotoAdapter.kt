package az.zero.azunsplashimage.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.zero.azunsplashimage.R
import az.zero.azunsplashimage.data.UnSplashPhoto
import az.zero.azunsplashimage.databinding.ItemUnsplashPhotoBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class UnSplashPhotoAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<UnSplashPhoto, UnSplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemUnsplashPhotoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) holder.bind(currentItem)
    }

    // inner to access parent properties or we can pass it to viewHolder constructor
    inner class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) listener.onItemClick(item)
                }
            }
        }

        fun bind(photo: UnSplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewUserName.text = photo.user.name
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(photo: UnSplashPhoto)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnSplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto) =
                oldItem == newItem
        }
    }
}
package com.worldcup.almondial.ui_.home_screen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldcup.almondial.R
import com.worldcup.almondial.database.entities.NewsEntity
import com.worldcup.almondial.databinding.ItemNewsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsAdapter(val clickListener: NewsListener) :
    ListAdapter<NewsDataItem, RecyclerView.ViewHolder>(NewsDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val ITEM_VIEW_TYPE_FOOTER = 2
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<NewsEntity>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(NewsDataItem.Header)
                else -> listOf(NewsDataItem.Header) + list.map { NewsDataItem.NewsItem(it) } + listOf(NewsDataItem.Footer)
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NewsAdapter.ViewHolder -> {
                val newsItem = getItem(position) as NewsDataItem.NewsItem
                holder.bind(clickListener, newsItem.newsEntity)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_FOOTER -> FooterViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.news_header, parent, false)
                return TextViewHolder(view)
            }
        }
    }
    class FooterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): FooterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.match_footer, parent, false)
                return FooterViewHolder(view)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is NewsDataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is NewsDataItem.NewsItem -> ITEM_VIEW_TYPE_ITEM
            is NewsDataItem.Footer -> ITEM_VIEW_TYPE_FOOTER
        }
    }
    class ViewHolder private constructor(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: NewsListener, item: NewsEntity) {
            binding.news = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class NewsDiffCallback : DiffUtil.ItemCallback<NewsDataItem>() {
        override fun areItemsTheSame(oldItem: NewsDataItem, newItem: NewsDataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: NewsDataItem, newItem: NewsDataItem): Boolean {
            return oldItem == newItem
        }
    }
    class NewsListener(val clickListener: (selectedNews: NewsEntity) -> Unit) {
        fun onClick(selectedNews: NewsEntity) = clickListener(selectedNews)
    }


}

sealed class NewsDataItem {
    data class NewsItem(val newsEntity: NewsEntity): NewsDataItem() {
        override val id: Long
            get() = newsEntity.Match_id.toLong() //TODO: needs change
    }

    object Header: NewsDataItem() {
        override val id = Long.MIN_VALUE
    }
    object Footer: NewsDataItem() {
        override val id = Long.MAX_VALUE
    }
    abstract val id: Long
}


package com.worldcup.almondial.ui_.home_screen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldcup.almondial.R
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.databinding.ItemMatchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

    enum class MatchAdapterScreen(val screen: Int) {
        HOMESCREEN(0),
        MATCHESCREEN(1)
    }
class MatchAdapter(val clickListener: MatchListener, val screen: MatchAdapterScreen) :
    ListAdapter<DataItem, RecyclerView.ViewHolder>(MatchDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<MatchEntity>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map { DataItem.MatchItem(it) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MatchAdapter.ViewHolder -> {
                val matchItem = getItem(position) as DataItem.MatchItem
                holder.bind(clickListener, matchItem.matchEntity)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (screen == MatchAdapterScreen.HOMESCREEN) {
            return when (viewType) {
                ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
                ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
                else -> throw ClassCastException("Unknown viewType ${viewType}")
            }
        } else {
            return when (viewType) {
                ITEM_VIEW_TYPE_HEADER -> TextViewHolder_2.from(parent)
                ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
                else -> throw ClassCastException("Unknown viewType ${viewType}")
            }
        }
    }
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.match_header_homescreen, parent, false)
                return TextViewHolder(view)
            }
        }
    }
    class TextViewHolder_2(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.match_header_matchscreen, parent, false)
                return TextViewHolder(view)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.MatchItem -> ITEM_VIEW_TYPE_ITEM
        }
    }
    class ViewHolder private constructor(val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: MatchListener, item: MatchEntity) {
            binding.match = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMatchBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class MatchDiffCallback : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }
    }
    class MatchListener(val clickListener: (selectedMatch: MatchEntity) -> Unit) {
        fun onClick(selectedMatch: MatchEntity) = clickListener(selectedMatch)
    }


}

sealed class DataItem {
    data class MatchItem(val matchEntity: MatchEntity): DataItem() {
        override val id: Long
            get() = matchEntity.match_id.toLong()
    }

    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }


    abstract val id: Long
}


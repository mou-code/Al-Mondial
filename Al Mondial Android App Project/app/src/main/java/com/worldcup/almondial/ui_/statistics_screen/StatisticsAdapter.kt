package com.worldcup.almondial.ui_.statistics_screen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldcup.almondial.R
import com.worldcup.almondial.database.entities.StatisticsEntity
import com.worldcup.almondial.databinding.ItemStatisticBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StatisticsAdapter() :
    ListAdapter<Statistics_DataItem, RecyclerView.ViewHolder>(StatDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val adapterScope = CoroutineScope(Dispatchers.Default)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is StatisticsAdapter.ViewHolder -> {
                val statisticsItem = getItem(position) as Statistics_DataItem.StatItem
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.match_footer, parent, false)
                return TextViewHolder(view)
            }
        }
    }
    fun addHeaderAndSubmitList(list: List<StatisticsEntity>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(Statistics_DataItem.Header)
                else ->  list.map { Statistics_DataItem.StatItem(it) } + listOf(Statistics_DataItem.Header)
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Statistics_DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is Statistics_DataItem.StatItem -> ITEM_VIEW_TYPE_ITEM
        }
    }
    class ViewHolder private constructor(val binding: ItemStatisticBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StatisticsEntity) {
            binding.stat = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStatisticBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class StatDiffCallback : DiffUtil.ItemCallback<Statistics_DataItem>() {
        override fun areItemsTheSame(oldItem: Statistics_DataItem, newItem: Statistics_DataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Statistics_DataItem, newItem: Statistics_DataItem): Boolean {
            return oldItem == newItem
        }
    }

}

sealed class Statistics_DataItem {
    data class StatItem(val statisticsEntity: StatisticsEntity): Statistics_DataItem() {
        override val id: Long
            get() = statisticsEntity.stat_name.toLong() //TODO
    }

    object Header: Statistics_DataItem() {
        override val id = Long.MIN_VALUE
    }


    abstract val id: Long
}


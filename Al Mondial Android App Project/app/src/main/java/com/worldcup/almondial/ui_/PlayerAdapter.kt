package com.worldcup.almondial.ui_
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldcup.almondial.R
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.database.entities.PlayerEntity
import com.worldcup.almondial.databinding.ItemMatchBinding
import com.worldcup.almondial.databinding.ItemPlayerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PlayerAdapter(val clickListener: PlayerListener) :
    ListAdapter<DataItem, RecyclerView.ViewHolder>(PlayerDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<PlayerEntity>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map { DataItem.PlayerItem(it) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PlayerAdapter.ViewHolder -> {
                val playerItem = getItem(position) as DataItem.PlayerItem
                holder.bind(clickListener, playerItem.playerEntity)
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
                val view = layoutInflater.inflate(R.layout.players_header, parent, false)
                return TextViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.PlayerItem -> ITEM_VIEW_TYPE_ITEM
        }
    }
    class ViewHolder private constructor(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: PlayerListener, item: PlayerEntity) {
            binding.player = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPlayerBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class PlayerDiffCallback : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }
    }
    class PlayerListener(val clickListener: (selectedPlayer: PlayerEntity) -> Unit) {
        fun onClick(selectedPlayer: PlayerEntity) = clickListener(selectedPlayer)
    }


}

sealed class DataItem {
    data class PlayerItem(val playerEntity: PlayerEntity): DataItem() {
        override val id: Long
            get() = playerEntity.Player_id.toLong()
    }

    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}


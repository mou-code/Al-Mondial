package com.worldcup.almondial.ui_.groups_screen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worldcup.almondial.R
import com.worldcup.almondial.database.entities.GroupEntity
import com.worldcup.almondial.databinding.ItemGroupBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupAdapter() :
    ListAdapter<Group_DataItem, RecyclerView.ViewHolder>(GroupDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val ITEM_VIEW_TYPE_FOOTER = 2
    private val adapterScope = CoroutineScope(Dispatchers.Default)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GroupAdapter.ViewHolder -> {
                val groupItem = getItem(position) as Group_DataItem.GroupItem
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            ITEM_VIEW_TYPE_FOOTER -> FooterViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }
    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.group_header, parent, false)
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
    fun addHeaderAndSubmitList(list: List<GroupEntity>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(Group_DataItem.Header)
                else -> listOf(Group_DataItem.Header) + list.map { Group_DataItem.GroupItem(it) } + listOf(Group_DataItem.Footer)
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Group_DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is Group_DataItem.GroupItem -> ITEM_VIEW_TYPE_ITEM
            is Group_DataItem.Footer -> ITEM_VIEW_TYPE_FOOTER
        }
    }
    class ViewHolder private constructor(val binding: ItemGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GroupEntity) {
            binding.group = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGroupBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class GroupDiffCallback : DiffUtil.ItemCallback<Group_DataItem>() {
        override fun areItemsTheSame(oldItem: Group_DataItem, newItem: Group_DataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Group_DataItem, newItem: Group_DataItem): Boolean {
            return oldItem == newItem
        }
    }

}

sealed class Group_DataItem {
    data class GroupItem(val groupEntity: GroupEntity): Group_DataItem() {
        override val id: Long
            get() = groupEntity.Group_id.toLong()
    }

    object Header: Group_DataItem() {
        override val id = Long.MIN_VALUE
    }
    object Footer: Group_DataItem() {
        override val id = Long.MAX_VALUE
    }


    abstract val id: Long
}


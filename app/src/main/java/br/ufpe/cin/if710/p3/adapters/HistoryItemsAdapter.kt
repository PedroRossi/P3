package br.ufpe.cin.if710.p3.adapters

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.models.HistoryItem
import br.ufpe.cin.if710.p3.views.ItemViewHolder

class HistoryItemsAdapter(private val inflater: LayoutInflater) :
    ListAdapter<HistoryItem, ItemViewHolder>(ItemDiffer) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private object ItemDiffer : DiffUtil.ItemCallback<HistoryItem>() {
        override fun areItemsTheSame(p0: HistoryItem, p1: HistoryItem): Boolean {
            return p0.id == p1.id
        }

        override fun areContentsTheSame(p0: HistoryItem, p1: HistoryItem): Boolean {
            return p0.description == p1.description
        }
    }
}
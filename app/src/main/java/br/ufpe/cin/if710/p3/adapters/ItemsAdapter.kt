package br.ufpe.cin.if710.p3.adapters

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.models.Item
import br.ufpe.cin.if710.p3.views.ItemViewHolder

class ItemsAdapter(private val inflater: LayoutInflater) :
    ListAdapter<Item, ItemViewHolder>(ItemDiffer) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private object ItemDiffer : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(p0: Item, p1: Item): Boolean {
            return p0.title == p1.title
        }

        override fun areContentsTheSame(p0: Item, p1: Item): Boolean {
            return p0.description == p1.description
        }
    }
}
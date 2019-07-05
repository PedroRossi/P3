package br.ufpe.cin.if710.p3.views

import android.app.Activity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import br.ufpe.cin.if710.p3.models.Item
import kotlinx.android.synthetic.main.item.view.*

class ItemViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
    private val title: TextView = row.title
    private val description: TextView = row.description

    fun bindTo(item: Item) {
        title.text = item.title
        description.text = item.description
        row.setOnClickListener {
            // do stuff
            // val manager : FragmentManager

        }
    }
}
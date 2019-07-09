package br.ufpe.cin.if710.p3.views

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import br.ufpe.cin.if710.p3.database.models.Item
import br.ufpe.cin.if710.p3.database.models.Meal
import kotlinx.android.synthetic.main.item.view.*

class MealViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
    private val title: TextView = row.title
    private val description: TextView = row.description

    fun bindTo(item: Meal) {
        title.text = item.getTitle()
        description.text = item.description
    }
}
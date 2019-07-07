package br.ufpe.cin.if710.p3.adapters

import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.fragments.MealDetailsFragment
import br.ufpe.cin.if710.p3.database.models.Meal
import br.ufpe.cin.if710.p3.views.HistoryItemViewHolder

class HistoryItemsAdapter(private val inflater: LayoutInflater, private val activity: FragmentActivity) :
    ListAdapter<Meal, HistoryItemViewHolder>(ItemDiffer) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryItemViewHolder {
        return HistoryItemViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo(item)
        holder.row.setOnClickListener {
            val fragment = MealDetailsFragment.newInstance(item)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private object ItemDiffer : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(p0: Meal, p1: Meal): Boolean {
            return p0.id == p1.id
        }

        override fun areContentsTheSame(p0: Meal, p1: Meal): Boolean {
            return p0.description == p1.description
        }
    }
}
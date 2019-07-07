package br.ufpe.cin.if710.p3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Insight
import br.ufpe.cin.if710.p3.views.InsightItemViewHolder

class InsightsAdapter(private val inflater: LayoutInflater) :
    RecyclerView.Adapter<InsightItemViewHolder>() {

    private var insights = emptyList<Insight>()

    fun setInsights(data : List<Insight>) {
        insights = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InsightItemViewHolder {
        return InsightItemViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: InsightItemViewHolder, position: Int) {
        holder.bindTo(this.insights.get(position))
    }

    override fun getItemCount(): Int = insights.size
}
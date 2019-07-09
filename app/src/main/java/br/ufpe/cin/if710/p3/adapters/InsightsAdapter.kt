package br.ufpe.cin.if710.p3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Insight
import br.ufpe.cin.if710.p3.views.InsightViewHolder

class InsightsAdapter(private val inflater: LayoutInflater) :
    RecyclerView.Adapter<InsightViewHolder>() {

    private var insights = emptyList<Insight>()

    fun setInsights(data : List<Insight>) {
        insights = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InsightViewHolder {
        return InsightViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: InsightViewHolder, position: Int) {
        holder.bindTo(this.insights.get(position))
    }

    override fun getItemCount(): Int = insights.size
}
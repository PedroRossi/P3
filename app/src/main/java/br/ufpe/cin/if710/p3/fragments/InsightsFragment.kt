package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.adapters.InsightItemsAdapter
import br.ufpe.cin.if710.p3.database.models.Insight
import br.ufpe.cin.if710.p3.utils.DB
import br.ufpe.cin.if710.p3.utils.DoAsync

class InsightsFragment : Fragment() {

    private var insights : RecyclerView? = null
    private var myAdapter : InsightItemsAdapter? = null

    companion object {
        fun newInstance() = InsightsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.insights, container, false)
        insights = view.findViewById(R.id.insights_items)
        myAdapter = InsightItemsAdapter(layoutInflater)
        val db = DB.getInstance(this.context!!.applicationContext, "p3").appDatabase!!
        val dao = db.insightDao()
        DoAsync {
            dao.insert(Insight(2, "Um Rango Legal", "Carne mal passada"))
        }//.execute()
        val items = dao.getAll()
        items.observe(this, Observer { it ->
            myAdapter?.apply {
                setInsights(it)
            }
        })
        insights?.apply {
            layoutManager = LinearLayoutManager(super.getContext())
            addItemDecoration(
                DividerItemDecoration(
                    super.getContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            addItemDecoration(
                DividerItemDecoration(
                    super.getContext(),
                    DividerItemDecoration.HORIZONTAL
                )
            )
            adapter = myAdapter
        }
        return view
    }
}
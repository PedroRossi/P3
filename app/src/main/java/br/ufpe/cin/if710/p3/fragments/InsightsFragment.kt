package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.adapters.InsightsAdapter
import br.ufpe.cin.if710.p3.database.models.Insight
import br.ufpe.cin.if710.p3.utils.API
import br.ufpe.cin.if710.p3.utils.DB
import br.ufpe.cin.if710.p3.utils.DoAsync
import com.android.volley.Response

class InsightsFragment : Fragment() {

    private var insights : RecyclerView? = null
    private var myAdapter : InsightsAdapter? = null

    companion object {
        fun newInstance() = InsightsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.insights, container, false)
        insights = view.findViewById(R.id.insights_items)
        myAdapter = InsightsAdapter(layoutInflater)
        val db = DB.getInstance(this.context!!.applicationContext).appDatabase!!
        val dao = db.insightDao()
        val api = API(this.context!!)
        api.getInsights(Response.Listener {
            val title = it.getString("title")
            val description = it.getString("description")
            val insight = Insight(title, description)
            Log.d("a", insight.toString())
            DoAsync {
                dao.insert(insight)
            }.execute()
        }, Response.ErrorListener {
            Log.d("error", it.toString())
        })
        val items = dao.getAll()
        items.observe(this, Observer {
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
            adapter = myAdapter
        }
        return view
    }
}
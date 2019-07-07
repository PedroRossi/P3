package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.adapters.HistoryItemsAdapter
import br.ufpe.cin.if710.p3.database.models.Meal

class HistoryFragment : Fragment() {

    private var history: RecyclerView? = null

    companion object {
        fun newInstance() = HistoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.history, container, false)
        history = view.findViewById(R.id.history_items)
        val items = ArrayList<Meal>()
        val ref: FragmentActivity = this.activity!!
        items.add(Meal(1, "test_1", "test longo a"))
        history?.apply {
            layoutManager = LinearLayoutManager(super.getContext())
            addItemDecoration(
                DividerItemDecoration(
                    super.getContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = HistoryItemsAdapter(layoutInflater, ref).apply {
                submitList(items)
            }
        }
        return view
    }

}
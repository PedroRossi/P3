package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.adapters.HistoryItemsAdapter
import br.ufpe.cin.if710.p3.models.HistoryItem

class HistoryFragment : Fragment() {

    private var history: RecyclerView? = null

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.history, container, false)
        history = view.findViewById(R.id.history_items)
        val items = ArrayList<HistoryItem>()
        items.add(HistoryItem("test_1", "test longo a", 1))
        items.add(HistoryItem("test_2", "test longo b", 2))
        items.add(HistoryItem("test_3", "test longo c", 3))
        items.add(HistoryItem("test_4", "test longo d", 4))
        items.add(HistoryItem("test_5", "test longo e", 5))
        items.add(HistoryItem("test_6", "test longo f", 6))
        items.add(HistoryItem("test_7", "test longo j", 7))
        items.add(HistoryItem("test_8", "test longo k", 8))
        items.add(HistoryItem("test_9", "test longo l", 9))
        items.add(HistoryItem("test_10", "test longo m", 10))
        history?.apply {
            layoutManager = LinearLayoutManager(super.getContext())
            addItemDecoration(
                DividerItemDecoration(super.getContext(), DividerItemDecoration.VERTICAL)
            )
            adapter = HistoryItemsAdapter(layoutInflater).apply {
                submitList(items)
            }
        }
        return view
    }

}
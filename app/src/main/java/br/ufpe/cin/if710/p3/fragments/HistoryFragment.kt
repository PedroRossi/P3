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
import br.ufpe.cin.if710.p3.adapters.ItemsAdapter
import br.ufpe.cin.if710.p3.models.Item

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
        val items = ArrayList<Item>()
        items.add(Item("test_1", "test longo a"))
        items.add(Item("test_2", "test longo b"))
        items.add(Item("test_3", "test longo c"))
        history?.apply {
            layoutManager = LinearLayoutManager(super.getContext())
            addItemDecoration(
                DividerItemDecoration(super.getContext(), DividerItemDecoration.VERTICAL)
            )
            adapter = ItemsAdapter(layoutInflater).apply {
                print(items)
                submitList(items)
            }
        }
        return view
    }

}
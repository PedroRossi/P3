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

class InsightsFragment  : Fragment() {

    private var insights: RecyclerView? = null

    companion object {
        fun newInstance(): InsightsFragment {
            return InsightsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.insights, container, false)
        insights = view.findViewById(R.id.insights_items)
        val items = ArrayList<Item>()
        items.add(Item("test_1", "test longo a"))
        items.add(Item("test_2", "test longo b"))
        items.add(Item("test_3", "test longo c"))
        items.add(Item("test_4", "test longo d"))
        items.add(Item("test_5", "test longo e"))
        items.add(Item("test_6", "test longo f"))
        items.add(Item("test_7", "test longo j"))
        items.add(Item("test_8", "test longo k"))
        items.add(Item("test_9", "test longo l"))
        items.add(Item("test_10", "test longo m"))
        insights?.apply {
            layoutManager = LinearLayoutManager(super.getContext())
            addItemDecoration(
                DividerItemDecoration(super.getContext(), DividerItemDecoration.VERTICAL)
            )
            addItemDecoration(
                DividerItemDecoration(super.getContext(), DividerItemDecoration.HORIZONTAL)
            )
            adapter = ItemsAdapter(layoutInflater).apply {
                print(items)
                submitList(items)
            }
        }
        return view
    }
}
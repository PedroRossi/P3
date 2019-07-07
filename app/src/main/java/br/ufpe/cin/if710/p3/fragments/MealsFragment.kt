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
import androidx.lifecycle.Observer
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.adapters.MealsAdapter
import br.ufpe.cin.if710.p3.database.models.Meal
import br.ufpe.cin.if710.p3.utils.DB
import br.ufpe.cin.if710.p3.utils.DoAsync

class MealsFragment : Fragment() {

    private var meals: RecyclerView? = null
    private var myAdapter: MealsAdapter? = null

    companion object {
        fun newInstance() = MealsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.history, container, false)
        meals = view.findViewById(R.id.meals_items)
        this.activity?.apply {
            myAdapter = MealsAdapter(layoutInflater, this)
        }
        val db = DB.getInstance(this.context!!.applicationContext).appDatabase!!
        val dao = db.mealDao()
        val items = dao.getAll()
        items.observe(this, Observer {
            myAdapter?.apply {
                setMeals(it)
            }
        })
        meals?.apply {
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
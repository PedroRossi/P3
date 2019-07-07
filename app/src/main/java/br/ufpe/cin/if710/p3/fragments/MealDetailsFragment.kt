package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Meal
import kotlinx.android.synthetic.main.meal.view.*

class MealDetailsFragment : androidx.fragment.app.Fragment() {

    private lateinit var item : Meal

    companion object {
        fun newInstance(itemToBe : Meal) = MealDetailsFragment().apply {
            item = itemToBe
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.meal, container, false)
        view.foodTitle.text = item.title
        view.foodDescription.text = item.description
        return view
    }
}
package br.ufpe.cin.if710.p3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Meal
import kotlinx.android.synthetic.main.meal.view.*

class MealDetailsFragment : Fragment() {

    private lateinit var meal : Meal

    companion object {
        fun newInstance(item : Meal) = MealDetailsFragment().apply {
            meal = item
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.meal, container, false)
        view.findViewById<ImageView>(R.id.img).setImageURI(meal.getPhotoURI())
        view.title.text = meal.getTitle()
        view.description.text = meal.description
        return view
    }
}
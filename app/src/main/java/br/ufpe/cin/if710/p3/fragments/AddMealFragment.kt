package br.ufpe.cin.if710.p3.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Meal
import kotlinx.android.synthetic.main.meal.view.*

class AddMealFragment : Fragment() {

    private lateinit var photoURI : Uri

    companion object {
        fun newInstance(photo: Uri) = AddMealFragment().apply {
            photoURI = photo
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_meal, container, false)
        view.findViewById<ImageView>(R.id.foodImg).setImageURI(photoURI)
        // get timestamp and photoURI from item also
        return view
    }
}
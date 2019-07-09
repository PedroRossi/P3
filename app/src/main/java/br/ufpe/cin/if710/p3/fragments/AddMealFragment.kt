package br.ufpe.cin.if710.p3.fragments

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.database.models.Meal
import br.ufpe.cin.if710.p3.utils.DB
import br.ufpe.cin.if710.p3.utils.DoAsync
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDateTime
import java.util.*

class AddMealFragment : Fragment() {

    private lateinit var photoPath : String

    private var descriptionEditText : EditText? = null
    private var saveButton : Button? = null
    private var bottomNav: BottomNavigationView? = null

    companion object {
        fun newInstance(
            photo: String,
            nav: BottomNavigationView
        ) = AddMealFragment().apply {
            photoPath = photo
            bottomNav = nav
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_meal, container, false)
        view.findViewById<ImageView>(R.id.img).setImageURI(Uri.parse(photoPath))
        saveButton = view.findViewById(R.id.save)
        descriptionEditText = view.findViewById(R.id.description)
        saveButton?.setOnClickListener {
            val description = descriptionEditText!!.text.toString()
            val date = LocalDateTime.now()
            val meal = Meal(description, date, photoPath)
            DoAsync {
                val db = DB.getInstance(this.context!!).appDatabase!!
                val dao = db.mealDao()
                dao.insert(meal)
                // send to api also
            }.execute()
            bottomNav?.also {
                this.activity!!.supportFragmentManager.beginTransaction()
                    .remove(this)
                    .commit()
                it.selectedItemId = R.id.navigation_history
            }
        }
        return view
    }
}
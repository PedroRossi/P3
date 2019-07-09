package br.ufpe.cin.if710.p3.adapters

import androidx.fragment.app.FragmentActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.if710.p3.R
import br.ufpe.cin.if710.p3.fragments.MealDetailsFragment
import br.ufpe.cin.if710.p3.database.models.Meal
import br.ufpe.cin.if710.p3.views.MealViewHolder

class MealsAdapter(private val inflater: LayoutInflater, private val activity: FragmentActivity) :
    RecyclerView.Adapter<MealViewHolder>() {

    private var meals = emptyList<Meal>()

    fun setMeals(data: List<Meal>) {
        meals = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealViewHolder {
        return MealViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val item = meals.get(position)
        holder.bindTo(item)
        holder.row.setOnClickListener {
            val fragment = MealDetailsFragment.newInstance(item)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = meals.size
}
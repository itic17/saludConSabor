package com.iunis.programacionmovil.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.iunis.programacionmovil.R
import com.iunis.programacionmovil.models.RecipesModel
import kotlinx.android.synthetic.main.list_recipes.view.*

class RecipesAdapter(private val context: Context, private val recipesArrayList: ArrayList<RecipesModel>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val recipe_item = this.recipesArrayList[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var recipesListView = inflator.inflate(R.layout.list_recipes, null)
        recipesListView.name_recipe.setText(recipe_item.recipe_name)
        recipesListView.numero_raciones.setText(recipe_item.raciones)
        recipesListView.image_recipe.setImageResource(recipe_item.imageRecipe)
        return recipesListView
    }

    override fun getCount(): Int {
        return recipesArrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
package com.iunis.programacionmovil.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.iunis.programacionmovil.R
import com.iunis.programacionmovil.models.DetailsModel
import kotlinx.android.synthetic.main.detail_recipe.view.*
import kotlinx.android.synthetic.main.list_recipes.view.*

class DetailsAdapter(private val context: Context, private val detailsArrayList: ArrayList<DetailsModel>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val detail_item = this.detailsArrayList[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var detailsListView = inflator.inflate(R.layout.detail_recipe, null)
        detailsListView.name_recipedetail.setText(detail_item.recipe_name)
        detailsListView.numeroderaciones.setText(detail_item.raciones)
        detailsListView.image_detailrecipe.setBackgroundResource(detail_item.image_recipe)
        detailsListView.ingredientes.setText(detail_item.ingredientes)
        detailsListView.preparacion.setText(detail_item.preparacion)
        detailsListView.image_tablerecipe.setImageResource(detail_item.tabla)
        return detailsListView

    }

    override fun getCount(): Int {
        return detailsArrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
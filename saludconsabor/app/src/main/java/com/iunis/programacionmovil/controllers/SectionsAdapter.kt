package com.iunis.programacionmovil.controllers

import android.content.Context
import com.iunis.programacionmovil.models.SectionsModel

class SectionsAdapter(context: Context, categoriesArrayList: ArrayList<SectionsModel>) {
    /*override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //sacar cada alumno para ubicarlo en el ListView
        val category_item = this.categoriesArrayList[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var categoriesListView = inflator.inflate(R.layout.list_categories, null)
        categoriesListView.idcategory.setId(category_item.id)
        categoriesListView.name_category.setText(category_item.category_name)
        categoriesListView.numbers_recipes.setText(category_item.numbers_recipes)
        categoriesListView.imgitem_category.setImageResource(category_item.image_category)

        return categoriesListView
    }

    override fun getCount(): Int {
        return categoriesArrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }*/
}
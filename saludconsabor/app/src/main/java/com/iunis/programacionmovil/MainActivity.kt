package com.iunis.programacionmovil

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_categories.view.*

class MainActivity : AppCompatActivity() {
    var adapter:ListCategoriesAdapter?=null
    var categoriesList = ArrayList<ListCategories>()

    override fun onCreate(savedInstanceState: Bundle?) {
        //INICIALIZA EL SPLASHSCREEN
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namesCategories = arrayOf<String>(R.string.categoria1.toString(), R.string.categoria2.toString(), R.string.categoria3.toString(),
            R.string.categoria4.toString(), R.string.categoria5.toString())

        categoriesList.add(ListCategories(namesCategories[0], R.drawable.image2))
        categoriesList.add(ListCategories(namesCategories[1], R.drawable.image1))
        categoriesList.add(ListCategories(namesCategories[2], R.drawable.imagen3))
        categoriesList.add(ListCategories(namesCategories[3], R.drawable.imagen4))
        categoriesList.add(ListCategories(namesCategories[4], R.drawable.imagen5))

        adapter = ListCategoriesAdapter(this,categoriesList)
        gv_food.adapter = adapter
    }

    class ListCategoriesAdapter : BaseAdapter {
        var categoriesList_adapter = ArrayList<ListCategories>()
        var context: Context? = null

        constructor(contextparam: Context, categoriesListParam: ArrayList<ListCategories>) :super(){
            this.context = contextparam
            this.categoriesList_adapter = categoriesListParam
        }

        override fun getCount(): Int {
            return categoriesList_adapter.size
        }

        override fun getItem(position: Int): Any {
            return categoriesList_adapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val category_item = this.categoriesList_adapter[position]
            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var categoryView = inflator.inflate(R.layout.list_categories, null)

            categoryView.imgitem_category.setImageResource(category_item.image!!)
            categoryView.name_category.text = category_item.name

            return categoryView
        }
    }
}
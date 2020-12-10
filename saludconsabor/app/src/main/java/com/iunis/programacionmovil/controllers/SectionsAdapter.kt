package com.iunis.programacionmovil.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.iunis.programacionmovil.R
import com.iunis.programacionmovil.models.SectionsModel
import kotlinx.android.synthetic.main.list_sections.view.*

class SectionsAdapter(private val context: Context, private val sectionsArrayList: ArrayList<SectionsModel>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //sacar cada alumno para ubicarlo en el ListView
        val section_item = this.sectionsArrayList[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var sectionsListView = inflator.inflate(R.layout.list_sections, null)
        sectionsListView.name_section.setText(section_item.section_name)
        sectionsListView.imgitem_category.setImageResource(section_item.image_section)

        return sectionsListView
    }

    override fun getCount(): Int {
        return sectionsArrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
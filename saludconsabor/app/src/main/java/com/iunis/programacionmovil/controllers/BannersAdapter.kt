package com.iunis.programacionmovil.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.iunis.programacionmovil.R
import com.iunis.programacionmovil.models.BannersModel
import kotlinx.android.synthetic.main.banner_recipe.view.*

class BannersAdapter(private val context: Context, private val bannersArrayList: ArrayList<BannersModel>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val banner_item = this.bannersArrayList[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var bannerListView = inflator.inflate(R.layout.banner_recipe, null)
        bannerListView.imageSection.setBackgroundResource(banner_item.imageSection)
        return bannerListView
    }

    override fun getCount(): Int {
        return bannersArrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
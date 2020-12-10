package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ListView
import com.iunis.programacionmovil.controllers.BannersAdapter
import com.iunis.programacionmovil.models.BannersModel
import org.json.JSONArray
import org.json.JSONObject

/***
 * Esta funcion obtiene los datos de sections.json
 */
fun getDataJsonBanners(context: Context, id:Int, dataBannersListView: ListView): ArrayList<BannersModel>{
    var bannersArrayList = ArrayList<BannersModel>()
    var adapter: BannersAdapter?=null
    var recursos: Resources? = context.resources


    val jsonObjetCategory = JSONObject(readJSON(context, "banners.json"))
    val recipesList = JSONArray(jsonObjetCategory.get("banners").toString())

    for(index in 0 until recipesList.length()){
        var dataInner : JSONObject = recipesList.getJSONObject(index)

        if (dataInner.getInt("idsection").equals(id)){
            var id_banner: Int = dataInner.getInt("idbanner")
            var id_section: Int = dataInner.getInt("idsection")
            var image_section: String = dataInner.getString("image_path")

            //identifica la ruta de los recusos
            val identifierImage = recursos?.getIdentifier(image_section, "drawable", context.packageName)


            var bannersItem = BannersModel(id_banner, id_section, identifierImage!!)

            bannersArrayList.add(bannersItem)
        }
    }


    adapter = BannersAdapter(context, bannersArrayList)
    dataBannersListView.adapter = adapter

    return bannersArrayList
}

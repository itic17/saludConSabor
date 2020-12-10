package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ListView
import com.iunis.programacionmovil.controllers.SectionsAdapter
import com.iunis.programacionmovil.models.SectionsModel
import org.json.JSONArray
import org.json.JSONObject

/***
 * Esta funcion obtiene los datos de sections.json
 */
fun getDataJsonSections(context: Context, id:Int, dataSectionsListView: ListView): ArrayList<SectionsModel>{
    var sectionsArrayList = ArrayList<SectionsModel>()
    var adapter: SectionsAdapter?=null
    var recursos: Resources? = context.resources


    val jsonObjetCategory = JSONObject(readJSON(context, "sections.json"))
    val categoriesList = JSONArray(jsonObjetCategory.get("sections").toString())

    for(index in 0 until categoriesList.length()){
        var dataInner : JSONObject = categoriesList.getJSONObject(index)

        if (dataInner.getInt("idcategory").equals(id)){
            var id_section: Int = dataInner.getInt("idsection")
            var section_name: String = dataInner.getString("section_name")
            var image_path: String = dataInner.getString("image_section")
            var id_category: Int = dataInner.getInt("idcategory")

            //identifica la ruta de los recusos
            val identifierNameSection = recursos?.getIdentifier(section_name, "string", context.packageName)
            val identifierImage = recursos?.getIdentifier(image_path, "drawable", context.packageName)


            var sectionItem = SectionsModel(id_section, identifierNameSection!!, identifierImage!!, id_category)

            sectionsArrayList.add(sectionItem)
        }
    }


    adapter = SectionsAdapter(context, sectionsArrayList)
    dataSectionsListView.adapter = adapter

    return sectionsArrayList
}

package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ListView
import com.iunis.programacionmovil.controllers.DetailsAdapter
import com.iunis.programacionmovil.models.DetailsModel
import org.json.JSONArray
import org.json.JSONObject

/***
 * Esta funcion obtiene los datos de details.json
 */
fun getDataJsonDetails(context: Context, id:Int, dataDetailsListView: ListView): ArrayList<DetailsModel>{
    var detailsArrayList = ArrayList<DetailsModel>()
    var adapter: DetailsAdapter?=null
    var recursos: Resources? = context.resources


    val jsonObjetCategory = JSONObject(readJSON(context, "details.json"))
    val detailsList = JSONArray(jsonObjetCategory.get("details").toString())

    for(index in 0 until detailsList.length()){
        var dataInner : JSONObject = detailsList.getJSONObject(index)

        if (dataInner.getInt("idreceta").equals(id)){
            var id_detail: Int = dataInner.getInt("iddetail")
            var id_receta: Int = dataInner.getInt("idreceta")
            var recipe_name: String = dataInner.getString("recipe_name")
            var raciones: String = dataInner.getString("raciones")
            var image_recipe: String = dataInner.getString("image_recipe")
            var ingredientes: String = dataInner.getString("ingredientes")
            var preparacion: String = dataInner.getString("preparacion")
            var tabla: String = dataInner.getString("tabla")

            //identifica la ruta de los recusos
            val identifierNameRecipe = recursos?.getIdentifier(recipe_name, "string", context.packageName)
            val identifierRaciones = recursos?.getIdentifier(raciones, "string", context.packageName)
            val identifierImageRecipe = recursos?.getIdentifier(image_recipe, "drawable", context.packageName)
            val identifierIngredientes =  recursos?.getIdentifier(ingredientes,"string", context.packageName)
            val identifierPreparacion =  recursos?.getIdentifier(preparacion,"string", context.packageName)
            val identifierTabla =  recursos?.getIdentifier(tabla,"drawable", context.packageName)


            var detailsItem = DetailsModel(id_detail, id_receta, identifierNameRecipe!!, identifierRaciones!!, identifierImageRecipe!!, identifierIngredientes!!, identifierPreparacion!!, identifierTabla!!)

            detailsArrayList.add(detailsItem)
        }
    }


    adapter = DetailsAdapter(context, detailsArrayList)
    dataDetailsListView.adapter = adapter

    return detailsArrayList
}

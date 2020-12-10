package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ListView
import com.iunis.programacionmovil.controllers.CategoriesAdapter
import com.iunis.programacionmovil.models.CategoriesModel
import org.json.JSONArray
import org.json.JSONObject

/***
 * Esta funcion obtiene los datos de categories.json
 */
fun getDataJsonCategories(context: Context, dataCategoriesListView: ListView): ArrayList<CategoriesModel>{
    var categoriesArrayList = ArrayList<CategoriesModel>()
    var adapter: CategoriesAdapter?=null
    var recursos: Resources? = context.resources


    val jsonObjetCategory = JSONObject(readJSON(context, "categories.json"))
    val categoriesList = JSONArray(jsonObjetCategory.get("categories").toString())

    for(index in 0 until categoriesList.length()){
        var dataInner : JSONObject = categoriesList.getJSONObject(index)
        var id_category: Int = dataInner.getInt("idcategory")
        var category_name: String = dataInner.getString("category_name")
        var numbers_recipes: String = dataInner.getString("numbers_recipes")
        var image_path: String = dataInner.getString("image_category")

        //identifica la ruta de los recusos
        val identifierNameCategory = recursos?.getIdentifier(category_name, "string", context.packageName)
        val identifierNumberRecipe = recursos?.getIdentifier(numbers_recipes, "string", context.packageName)
        val identifierImage = recursos?.getIdentifier(image_path, "drawable", context.packageName)

        var categoryItem = CategoriesModel(id_category, identifierNameCategory!!, identifierNumberRecipe!!,identifierImage!!)

        categoriesArrayList.add(categoryItem)
    }


    adapter = CategoriesAdapter(context, categoriesArrayList)
    dataCategoriesListView.adapter = adapter

    return categoriesArrayList
}

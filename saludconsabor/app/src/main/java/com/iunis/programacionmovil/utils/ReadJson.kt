package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.iunis.programacionmovil.R
import com.iunis.programacionmovil.controllers.CategoriesAdapter
import com.iunis.programacionmovil.models.CategoriesModel
import kotlinx.android.synthetic.main.list_categories.view.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException



/***
 * Esta funcion abre y lee un archivo de tipo json
 * Context: param de la app
 * file_name: el nombre como se llama el archivo
 */
fun readJSON(context: Context, file_name:String):String?{
    val json:String

    try {
        val inputStream = context.getAssets().open(file_name)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.use { it.read(buffer) }
        json = String(buffer)

    }catch (e: IOException){
        e.printStackTrace()
        return null
    }

    Log.i("saludconsabor",json)

    return json
}


/***
 * Esta funcion obtiene los datos de categories.json
 */
fun getDataJsonCategories(context: Context, dataCategoriesListView: ListView){
    var categoriesArrayList = ArrayList<CategoriesModel>()
    var adapter:CategoriesAdapter?=null
    var recursos: Resources? = context.resources
    val jsonObjetCategory = JSONObject(readJSON(context, "categories.json"))
    val categoriesList = JSONArray(jsonObjetCategory.get("categories").toString())

    for(index in 0 until categoriesList.length()){
        var dataInner : JSONObject = categoriesList.getJSONObject(index)
        var id_category: Int = dataInner.getInt("idCategory")
        var category_name: String = dataInner.getString("category_name")
        var numbers_recipes: String = dataInner.getString("numbers_recipes")
        var image_path: String = dataInner.getString("image_category")

        //identifica la ruta de los recusos
        val idenfifierIdCategory = recursos?.getIdentifier(id_category.toString(), "+id"+"idCategoria", context.packageName)
        val identifierNameCategory = recursos?.getIdentifier(category_name, "string", context.packageName)
        val identifierNumberRecipe = recursos?.getIdentifier(numbers_recipes, "string", context.packageName)
        val identifierImage = recursos?.getIdentifier(image_path, "drawable", context.packageName)

        var categoryItem = CategoriesModel(idenfifierIdCategory!!, identifierNameCategory!!, identifierNumberRecipe!!,identifierImage!!)

        categoriesArrayList.add(categoryItem)
    }


    adapter = CategoriesAdapter(context, categoriesArrayList)
    dataCategoriesListView.adapter = adapter

    /*
    dataCategoriesListView.setOnItemClickListener(){adapterView, view, position, id->
        val itempositionById = adapterView.getItemIdAtPosition(position)
        Toast.makeText(context, "El ID es $itempositionById", Toast.LENGTH_SHORT).show()

    }*/
}
package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.ListView
import com.iunis.programacionmovil.controllers.CategoriesAdapter
import com.iunis.programacionmovil.controllers.SectionsAdapter
import com.iunis.programacionmovil.models.CategoriesModel
import com.iunis.programacionmovil.models.SectionsModel
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
        println("el id es $id_category")
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


    dataCategoriesListView.setOnItemClickListener(){adapterView, view, position, id->
        val itempositionById = adapterView.getItemIdAtPosition(position)
        CategoryController(itempositionById)

        //Toast.makeText(context, "El ID es $itempositionById", Toast.LENGTH_SHORT).show()

    }
}

fun CategoryController(idselecionado: Long): Long {
    var newId=idselecionado+1
    println("el id selecionado es $newId")
    return newId
}


/***
 * Esta funcion obtiene los datos de categories.json
 *//*
fun getDataJsonSections(context: Context, dataSectionsListView: ListView){
    var categoriesArrayList = ArrayList<SectionsModel>()
    var adapter:SectionsAdapter?=null
    var recursos: Resources? = context.resources
    val jsonObjetCategory = JSONObject(readJSON(context, "section.json"))
    val categoriesList = JSONArray(jsonObjetCategory.get("sections").toString())

    for(index in 0 until categoriesList.length()){
        var dataInner : JSONObject = categoriesList.getJSONObject(index)
        var id_category: Int = dataInner.getInt("idSection")
        var category_name: String = dataInner.getString("section_name")
        var numbers_recipes: String = dataInner.getString("image_section")
        var image_path: Int= dataInner.getInt("fk_idCategory")

        //identifica la ruta de los recusos
        val idenfifierIdCategory = recursos?.getIdentifier(id_category.toString(), "+id"+"idCategoria", context.packageName)
        val identifierNameCategory = recursos?.getIdentifier(category_name, "string", context.packageName)
        val identifierNumberRecipe = recursos?.getIdentifier(numbers_recipes, "string", context.packageName)
        val identifierImage = recursos?.getIdentifier(image_path.toString(), "drawable", context.packageName)

        var categoryItem = SectionsModel(idenfifierIdCategory!!, identifierNameCategory!!, identifierNumberRecipe!!,identifierImage!!)

        categoriesArrayList.add(categoryItem)
    }


    adapter = SectionsAdapter(context, categoriesArrayList)
    dataSectionsListView.adapter = adapter


    dataSectionsListView.setOnItemClickListener(){adapterView, view, position, id->
        val itempositionById = adapterView.getItemIdAtPosition(position)
        CategoryController(itempositionById)

        //Toast.makeText(context, "El ID es $itempositionById", Toast.LENGTH_SHORT).show()

    }
}*/
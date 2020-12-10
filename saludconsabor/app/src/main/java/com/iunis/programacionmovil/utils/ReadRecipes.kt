package com.iunis.programacionmovil.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ListView
import com.iunis.programacionmovil.controllers.RecipesAdapter
import com.iunis.programacionmovil.models.RecipesModel
import org.json.JSONArray
import org.json.JSONObject

/***
 * Esta funcion obtiene los datos de recetas.json
 */
fun getDataJsonRecipes(context: Context, id:Int, dataRecipesListView: ListView): ArrayList<RecipesModel>{
    var recipesArrayList = ArrayList<RecipesModel>()
    var adapter: RecipesAdapter?=null
    var recursos: Resources? = context.resources


    val jsonObjetCategory = JSONObject(readJSON(context, "recetas.json"))
    val recipesList = JSONArray(jsonObjetCategory.get("recipes").toString())

    for(index in 0 until recipesList.length()){
        var dataInner : JSONObject = recipesList.getJSONObject(index)

        if (dataInner.getInt("idsection").equals(id)){
            var id_recipe: Int = dataInner.getInt("idreceta")
            var id_section: Int = dataInner.getInt("idsection")
            var recipe_name: String = dataInner.getString("recipe_name")
            var raciones: String = dataInner.getString("raciones")
            var image_recipe: String = dataInner.getString("image_recipe")

            //identifica la ruta de los recusos
            val identifierNameRecipe = recursos?.getIdentifier(recipe_name, "string", context.packageName)
            val identifierRaciones = recursos?.getIdentifier(raciones, "string", context.packageName)
            val identifierImageRecipe = recursos?.getIdentifier(image_recipe, "drawable", context.packageName)


            var recipesItem = RecipesModel(id_recipe, id_section, identifierNameRecipe!!, identifierRaciones!!, identifierImageRecipe!!)

            recipesArrayList.add(recipesItem)
        }
    }


    adapter = RecipesAdapter(context, recipesArrayList)
    dataRecipesListView.adapter = adapter

    return recipesArrayList
}

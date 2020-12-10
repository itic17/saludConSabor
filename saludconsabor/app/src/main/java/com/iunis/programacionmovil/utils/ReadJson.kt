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

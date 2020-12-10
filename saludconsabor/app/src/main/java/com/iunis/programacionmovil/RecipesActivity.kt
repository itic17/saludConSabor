package com.iunis.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iunis.programacionmovil.utils.getDataJsonRecipes
import com.iunis.programacionmovil.utils.getDataJsonSections
import kotlinx.android.synthetic.main.activity_recipes.*
import kotlinx.android.synthetic.main.activity_section.*

class RecipesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        val bundle: Bundle? = intent.extras
        val idseccion = bundle?.get("idsection")
        var recipesArrayList = getDataJsonRecipes(this, idseccion as Int, dataView_recipes)

    }
}
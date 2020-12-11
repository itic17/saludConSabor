package com.iunis.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.iunis.programacionmovil.utils.getDataJsonBanners
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
        getDataJsonBanners(this, idseccion as Int, dataView_banner)

        dataView_recipes.setOnItemClickListener{parent, view, position, id->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("idreceta", recipesArrayList.get(position).idreceta)

            startActivity(intent)
        }

        var btn_close = findViewById(R.id.buttonClose3) as ImageView
        btn_close.setOnClickListener{
            var intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            //finish()
            //System.exit(0)
        }


        var btn_return = findViewById(R.id.buttonBack2) as ImageView
        btn_return.setOnClickListener{
            finish()
            System.exit(0)
        }

        var btn_home = findViewById(R.id.buttonHome2) as ImageView
        btn_home.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
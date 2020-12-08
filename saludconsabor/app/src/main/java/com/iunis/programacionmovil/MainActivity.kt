package com.iunis.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.iunis.programacionmovil.utils.getDataJsonCategories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //INICIALIZA EL SPLASHSCREEN
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataJsonCategories(this,dataView_categories)
/*
        var ly_idcategoria = findViewById(R.id.idcategory) as LinearLayout


        ly_idcategoria.setOnClickListener{

            Toast.makeText(this@MainActivity, "sdfsdfsdfsdf", Toast.LENGTH_LONG).show()
        }*/
    }
}
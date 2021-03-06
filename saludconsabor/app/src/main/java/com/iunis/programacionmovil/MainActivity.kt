package com.iunis.programacionmovil

import android.content.Intent
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

        var categoryArrayList = getDataJsonCategories(this,dataView_categories)

        dataView_categories.setOnItemClickListener{parent, view, position, id->
            val intent = Intent(this, SectionActivity::class.java)
            intent.putExtra("idcategory", categoryArrayList.get(position).idCategoria)

            startActivity(intent)
        }

        var btn_close = findViewById(R.id.buttonClose1) as ImageView
        btn_close.setOnClickListener{
            var intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            //finish()
            //System.exit(0)
        }


    }
}
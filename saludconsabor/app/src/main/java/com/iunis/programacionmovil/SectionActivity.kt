package com.iunis.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.iunis.programacionmovil.utils.getDataJsonSections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_section.*

class SectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)

        val bundle: Bundle? = intent.extras
        val idcategoria = bundle?.get("idcategory")
        var sectionArrayList = getDataJsonSections(this, idcategoria as Int, dataView_sections)


        dataView_sections.setOnItemClickListener{parent, view, position, id->
            val intent = Intent(this, RecipesActivity::class.java)
            intent.putExtra("idsection", sectionArrayList.get(position).idSection)

            startActivity(intent)
        }

        var btn_close = findViewById(R.id.buttonClose2) as ImageView
        btn_close.setOnClickListener{
            var intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            //finish()
            //System.exit(0)
        }


        var btn_return = findViewById(R.id.buttonBack1) as ImageView
        btn_return.setOnClickListener{
            finish()
            System.exit(0)
        }


    }
}
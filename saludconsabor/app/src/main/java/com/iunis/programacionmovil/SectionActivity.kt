package com.iunis.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}
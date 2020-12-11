package com.iunis.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.iunis.programacionmovil.utils.getDataJsonBanners
import com.iunis.programacionmovil.utils.getDataJsonDetails
import com.iunis.programacionmovil.utils.getDataJsonRecipes
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_recipes.*
import kotlinx.android.synthetic.main.activity_recipes.dataView_recipes

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras
        val idreceta = bundle?.get("idreceta")
        var detailArrayList = getDataJsonDetails(this, idreceta as Int, dataView_detail)

        var btn_close = findViewById(R.id.buttonClose4) as ImageView
        btn_close.setOnClickListener{
            var intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            //finish()
            //System.exit(0)
        }


        var btn_return = findViewById(R.id.buttonBack3) as ImageView
        btn_return.setOnClickListener{
            finish()
            System.exit(0)
        }

        var btn_home = findViewById(R.id.buttonHome3) as ImageView
        btn_home.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
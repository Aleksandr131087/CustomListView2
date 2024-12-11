package com.example.customlistview2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityThree : AppCompatActivity() {

    private lateinit var toolbarThree: Toolbar
    private lateinit var productPriceETThree: TextView
    private lateinit var productNameETThree: TextView
    private lateinit var editImageIVThree: ImageView
private lateinit var productDescriptionETThree:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        productDescriptionETThree = findViewById(R.id.productDescriptionETThree)
        toolbarThree = findViewById(R.id.toolbarThree)
        productPriceETThree = findViewById(R.id.productPriceETThree)
        productNameETThree = findViewById(R.id.productNameETThree)
        editImageIVThree = findViewById(R.id.editImageIVThree)
        title = "Описание продукта"
        setSupportActionBar(toolbarThree)

        val name = intent.getStringExtra("PRODUCT_NAME")
        val price = intent.getStringExtra("PRODUCT_PRICE")
        val description = intent.getStringExtra("PRODUCT_DESCRIPTION")

        productNameETThree.text = name
        productPriceETThree.text = price
        productDescriptionETThree.text = description


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_exit -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}

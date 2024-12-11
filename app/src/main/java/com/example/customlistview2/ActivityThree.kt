package com.example.customlistview2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityThree : AppCompatActivity() {

    private lateinit var toolbarThree: Toolbar
    private lateinit var productPriceETThree: EditText
    private lateinit var productNameETThree: EditText
    private lateinit var editImageIVThree: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        toolbarThree = findViewById(R.id.toolbarThree)
        productPriceETThree = findViewById(R.id.productPriceETThree)
        productNameETThree = findViewById(R.id.productNameETThree)
        editImageIVThree = findViewById(R.id.editImageIVThree)
        title = "Описание продукта"
        setSupportActionBar(toolbarThree)




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

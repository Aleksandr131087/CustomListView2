package com.example.customlistview2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import java.io.IOException

class ActivityTwo : AppCompatActivity() {

    val GALERRY_REQUEST = 1

    var photoUri: Uri? = null

    val products: MutableList<Product> = mutableListOf()

    private lateinit var toolbar: Toolbar
    private lateinit var listViewLW: ListView
    private lateinit var saveBTN: Button
    private lateinit var productPriceET: EditText
    private lateinit var productNameET: EditText
    private lateinit var editImageIV: ImageView
private lateinit var productDescriptionET: EditText

    private lateinit var moveBTN: Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        init()
        title = "Корзина с продуктами"
        setSupportActionBar(toolbar)


        moveBTN = findViewById(R.id.moveBTN)
        moveBTN.setOnClickListener {
            val intent = Intent(this, ActivityThree::class.java)
            startActivity(intent)

        }

        editImageIV.setOnClickListener{
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, GALERRY_REQUEST)
        }
        saveBTN.setOnClickListener {
            createProduct()
            val ListAdapter = ListAdapter(this@ActivityTwo, products)
            listViewLW.adapter = ListAdapter
            ListAdapter.notifyDataSetChanged()


        }
    }

    private fun init() {
        listViewLW = findViewById(R.id.listViewLW)
        saveBTN = findViewById(R.id.saveBTN)
        productNameET = findViewById(R.id.productNameET)
        productPriceET = findViewById(R.id.productPriceET)
        editImageIV = findViewById(R.id.editImageIV)
        productDescriptionET = findViewById(R.id.productDescriptionET)

        toolbar = findViewById(R.id.toolbar)
    }

    private fun createProduct() {
        val productName = productNameET.text.toString()
        val productPrice = productPriceET.text.toString()
        val productimage = photoUri.toString()
        val descriptionimage = productDescriptionET.text.toString()
        val product = Product(productName, productPrice, productimage, descriptionimage)
        products.add(product)
        clearEditField()
        photoUri=null
    }

    private fun clearEditField() {
        productNameET.text.clear()
        productPriceET.text.clear()
        productDescriptionET.text.clear()
        editImageIV.setImageResource(R.drawable.ic_launcher_foreground
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            GALERRY_REQUEST -> if (resultCode == RESULT_OK) {
                photoUri = data?.data
                editImageIV.setImageURI(photoUri)

            }
        }
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
package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.thesign.adapter.GalleryAdapter
import com.kuliah.thesign.model.GalleryItem

class Design : AppCompatActivity() {

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ? = null
    private var arrayList:ArrayList<GalleryItem> ? = null
    private var galleryAdapter:GalleryAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        val extras = intent.extras
        val category = extras?.getString("category")

        if(category!=null) {
            var text = findViewById<TextView>(R.id.categoryText)
            text.setVisibility(View.VISIBLE)
            text.text = category
        }

        recyclerView = findViewById(R.id.gallery_recycler)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList(category)
        galleryAdapter = GalleryAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = galleryAdapter


        val categoryBtn = findViewById<ImageButton>(R.id.category)
        categoryBtn.setOnClickListener {
            val intent = Intent(this, Category::class.java)
            startActivity(intent)
            finish()
        }
        val homeBtn = findViewById<ImageButton>(R.id.home)
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val accountBtn = findViewById<ImageButton>(R.id.account)
        accountBtn.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setDataInList(category: String?) : ArrayList<GalleryItem> {
        var items:ArrayList<GalleryItem> = ArrayList()

        if (category == "Bathroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal2, "Modern Bathroom Monochrome", "Alifia","0812356823332"))
        }
        if (category == "Livingroom" || category == "Colorful" || category == null) {
            items.add(GalleryItem(R.drawable.gal4, "Countryside Kitchen Style", "Ninet","0812442323394"))
        }
        if (category == "Livingroom" || category == "Luxury" || category == null) {
            items.add(
                GalleryItem(
                    R.drawable.gal1,
                    "Volumizing Brow Waterproof ",
                    "Alifia",
                    "0812356823332"
                )
            )
            items.add(
                GalleryItem(
                    R.drawable.gal3,
                    "La Casa 16th Century ",
                    "Ninet",
                    "0812442323394"
                )
            )
        }
        if (category == "Bedroom" || category == "Luxury" || category == null) {
            items.add(
                GalleryItem(
                    R.drawable.gal5,
                    "Brightening Toner Summer Collection",
                    "Alifia",
                    "0812356823332"
                )
            )
        }
        return items
    }
}
package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        var category = extras?.getString("category")
        var fav = extras?.getStringArrayList("favourite")
//        fav ?:listOf("0")
        val teks = "My Favourite"

        if(category!=null) {
            var text = findViewById<TextView>(R.id.categoryText)
            text.setVisibility(View.VISIBLE)
            text.text = category
            fav = arrayListOf("-1")
        } else if(fav!=null) {
            var text = findViewById<TextView>(R.id.categoryText)
            text.setVisibility(View.VISIBLE)
            category = "-1"
            text.text = teks
        } else {
            fav = arrayListOf("-1")
            category = null
        }

        recyclerView = findViewById(R.id.gallery_recycler)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList(category, fav)
        galleryAdapter = GalleryAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = galleryAdapter
        recyclerView?.adapter!!.notifyDataSetChanged()

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

    private fun setDataInList(category: String?, fav: ArrayList<String>) : ArrayList<GalleryItem> {
        var items:ArrayList<GalleryItem> = ArrayList()

        if ("1" in fav || category == "Bathroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal2,
                1,
                "Modern Bathroom Monochrome", "Alifia","0812356823332"))
        }
        if ("2" in fav || category == "Livingroom" || category == "Colorful" || category == null) {
            items.add(GalleryItem(R.drawable.gal4,
                2,
                "Countryside Kitchen Style", "Ninet","0812442323394"))
        }
        if ("3" in fav || category == "Livingroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal1,
                3,
                "Volumizing Brow Waterproof ", "Alifia", "0812356823332"))
        }
        if ("4" in fav || category == "Livingroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal3,
                4,
                "La Casa 16th Century ", "Ninet", "0812442323394"))
        }
        if ("5" in fav || category == "Bedroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal5,
                5,
                "Brightening Toner Summer Collection", "Alifia", "0812356823332"))
        }
        if ("6" in fav || category == "Bedroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal6,
                6,
                "Black Doom Bedroom", "Febrina", "081346331232"))
        }
        if ("7" in fav || category == "Bedroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal7,
                7,
                "Cozy Minimalist Bedroom", "Alifia", "0812356823332"))
        }
        if ("8" in fav || category == "Bedroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal8,
                8,
                "Girl Luxury Bedroom", "Alifia", "0812356823332"))
        }
        if ("9" in fav || category == "Bedroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal9,
                9,
                "Cozy Minimalist Bedroom", "Febrina", "081346331232"))
        }
        if ("10" in fav || category == "Bedroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal10,
                10,
                "Small Light Bedroom", "Alifia", "0812356823332"))
        }
        if ("12" in fav || category == "Bathroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal12,
                12,
                "Wooden Minimalist Bathroom", "Ninet", "081244232339"))
        }
        if ("13" in fav || category == "Bathroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal13,
                13,
                "Luxury Master Bathroom ", "Febrina", "081346331232"))
        }
        if ("14" in fav || category == "Bathroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal14,
                14,
                "Simple Small Bathroom ", "Febrina", "081346331232"))
        }
        if ("15" in fav || category == "Bathroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal15,
                15,
                "Brown Minimalist Bathroom", "Ninet", "081244232339"))
        }
        if ("16" in fav || category == "Bathroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal16,
                16,
                "Luxury Minimalist Bathroom", "Ninet", "081244232339"))
        }
        if ("17" in fav || category == "Livingroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal17,
                17,
                "Sphere Chandelier", "Ninet", "081244232339"))
        }
        if ("18" in fav || category == "Livingroom" || category == "Luxury" || category == null) {
            items.add(GalleryItem(R.drawable.gal18,
                18,
                "Human Sans Livingroom", "Ninet", "081244232339"))
        }
        if ("19" in fav || category == "Livingroom" || category == "Monochrome" || category == null) {
            items.add(GalleryItem(R.drawable.gal19,
                19,
                "Monogrey Livingroom", "Ninet", "081244232339"))
        }
        return items
    }
}
package com.kuliah.thesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        recyclerView = findViewById(R.id.gallery_recycler)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        galleryAdapter = GalleryAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = galleryAdapter
    }

    private fun setDataInList() : ArrayList<GalleryItem> {
        var items:ArrayList<GalleryItem> = ArrayList()

        items.add(GalleryItem(R.drawable.gal1, "Volumizing Brow Waterproof ", "Alifia","0812356823332"))
        items.add(GalleryItem(R.drawable.gal2, "Modern Bathroom Monochrome", "Alifia","0812356823332"))
        items.add(GalleryItem(R.drawable.gal3, "La Casa 16th Century ", "Ninet","0812442323394"))
        items.add(GalleryItem(R.drawable.gal4, "Countryside Kitchen Style", "Ninet","0812442323394"))
        items.add(GalleryItem(R.drawable.gal5, "Brightening Toner Summer Collection", "Alifia","0812356823332"))

        return items
    }
}
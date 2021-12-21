package com.kuliah.thesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.thesign.R
import com.kuliah.thesign.model.GalleryItem

class GalleryAdapter(var context: Context, var arrayList: ArrayList<GalleryItem>) :
    RecyclerView.Adapter<GalleryAdapter.ItemHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.gallery_grid, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var galleryItem : GalleryItem = arrayList.get(position)

        holder.img.setImageResource(galleryItem.imgGallery!!)
        holder.text.text = galleryItem.textGallery
        holder.creator.text = galleryItem.creatorGallery
        holder.phone.text = galleryItem.phoneGallery

        holder.img.setOnClickListener {
            Toast.makeText(context, galleryItem.creatorGallery, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.img)
        var text = itemView.findViewById<TextView>(R.id.text)
        var creator = itemView.findViewById<TextView>(R.id.creator)
        var phone = itemView.findViewById<TextView>(R.id.phone)
    }
}
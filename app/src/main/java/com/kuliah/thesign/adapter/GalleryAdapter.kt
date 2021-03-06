package com.kuliah.thesign.adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.thesign.R
import com.kuliah.thesign.model.GalleryItem
import androidx.core.content.ContextCompat.startActivity

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.kuliah.thesign.Design
import com.kuliah.thesign.database.DatabaseHandler

import android.content.DialogInterface
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.*
import com.kuliah.thesign.NewsDetail


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
        holder.id.text = galleryItem.idGallery.toString()
        holder.text.text = galleryItem.textGallery
        holder.creator.text = galleryItem.creatorGallery
        holder.phone.text = galleryItem.phoneGallery

        holder.img.setOnClickListener {
            val context = holder.img.context
            val alertadd = AlertDialog.Builder(context)
            val factory = LayoutInflater.from(context)
            val view: View = factory.inflate(R.layout.image_detail, null)
            view.findViewById<ImageView>(R.id.dialog_imageview).setImageResource(galleryItem.imgGallery!!)
            alertadd.setView(view)
            alertadd.show()
        }
        holder.favourite.setOnClickListener {
            val databaseHandler: DatabaseHandler = DatabaseHandler(holder.img.context)
            if(databaseHandler.favourite(databaseHandler.checkAccount(), galleryItem.idGallery!!)) {
                Toast.makeText(context, "Sukses menambahkan ke favorit", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(context, "Sukses menghapus dari favorit", Toast.LENGTH_SHORT).show()
            }
        }

        holder.phone.setOnClickListener {
            val context = holder.phone.context
            val Url: String = "https://api.whatsapp.com/send?phone=${galleryItem.phoneGallery}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(Url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.img)
        var id = itemView.findViewById<TextView>(R.id.id)
        var text = itemView.findViewById<TextView>(R.id.text)
        var creator = itemView.findViewById<TextView>(R.id.creator)
        var phone = itemView.findViewById<TextView>(R.id.phone)
        var favourite = itemView.findViewById<ImageButton>(R.id.favouriteBtn)
    }
}
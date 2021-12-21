package com.kuliah.thesign.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.thesign.Category
import com.kuliah.thesign.NewsDetail
import com.kuliah.thesign.R
import com.kuliah.thesign.model.NewsItem

class NewsAdapter(var context: Context, var arrayList: ArrayList<NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.ItemHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_grid, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val newsItem : NewsItem = arrayList.get(position)

        holder.img.setImageResource(newsItem.imgNews!!)
        holder.text.text = newsItem.textNews
        holder.title.text = newsItem.titleNews

        holder.img.setOnClickListener {
            val context = holder.title.context
            val intent = Intent( context, NewsDetail::class.java)
            intent.putExtra("img", newsItem.imgNews);
            intent.putExtra("text", newsItem.textNews);
            intent.putExtra("title", newsItem.titleNews);
            context.startActivity(intent)

//            context.startActivity(Intent(context, NewsDetail::class.java))
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.img)
        var text = itemView.findViewById<TextView>(R.id.text)
        var title = itemView.findViewById<TextView>(R.id.title)
    }
}
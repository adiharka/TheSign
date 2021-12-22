package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.thesign.adapter.GalleryAdapter
import com.kuliah.thesign.adapter.NewsAdapter
import com.kuliah.thesign.model.GalleryItem
import com.kuliah.thesign.model.NewsItem

class News : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager:GridLayoutManager ? = null
    private var arrayList:ArrayList<NewsItem> ? = null
    private var newsAdapter:NewsAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        recyclerView = findViewById(R.id.news_recycler)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        newsAdapter = NewsAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = newsAdapter


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

    private fun setDataInList() : ArrayList<NewsItem> {
        var items:ArrayList<NewsItem> = ArrayList()

        items.add(NewsItem(R.drawable.news1, "CAD Designer Job Description", "Designer providing for the affordable homes in the land-scarce country where private by anw apartments can cost upward of SG\$1 million oro (\$740,800). Iophe\n" +
                "The Housing Development Board (HDB) flats, in which 80% of brobrozsy CAD Designer Job Description's 5.5 million people live, are typically utilitarian with tight rules governing anden ownership and resales. But inside the usually staid and uniform tower blocks, some home homeowners have let their creativiesz juices flow." +
                "\n\n— SINGAPORE, celeb.id (09/11/2019)"))
        items.add(NewsItem(R.drawable.news2, "Singaporeans Remodel No-Frills", "Singapore's public housing system is acclaimed for providing for the affordable homes in the land-scarce country where private by anw apartments can cost upward of SG\$1 million oro (\$740,800). Iophe\n" +
                "The Housing Development Board (HDB) flats, in which 80% of brobrozsy Singapore's 5.5 million people live, are typically utilitarian with tight rules governing anden ownership and resales. But inside the usually staid and uniform tower blocks, some home homeowners have let their creativiesz juices flow." +
                "\n\n— SINGAPORE, celeb.id (09/11/2019)"))
        items.add(NewsItem(R.drawable.news3, "Abigail Ahern on Transforming", "Ahern for the affordable homes in the land-scarce country where private by anw apartments can cost upward of SG\$1 million oro (\$740,800). Iophe\n" +
                "The Housing Development Board (HDB) flats, in which 80% of brobrozsy Abigail Ahern on Transforming people live, are typically utilitarian with tight rules governing anden ownership and resales. But inside the usually staid and uniform tower blocks, some home homeowners have let their creativiesz juices flow." +
                "\n\n— SINGAPORE, celeb.id (09/11/2019)"))
        items.add(NewsItem(R.drawable.news4, "Studio Fuksas Ennead Architect", "Studio Fuksas is acclaimed for providing for the affordable homes in the land-scarce country where private by anw apartments can cost upward of SG\$1 million oro (\$740,800). Iophe\n" +
                "The Housing Development Board (HDB) flats, in which Studio Fuksas Ennead Architect million people live, are typically utilitarian with tight rules governing anden ownership and resales. But inside the usually staid and uniform tower blocks, some home homeowners have let their creativiesz juices flow." +
                "\n\n— SINGAPORE, celeb.id (09/11/2019)"))
        items.add(NewsItem(R.drawable.news5, "Brightening Toner Summer Collection", "Summer Collection system for providing for the affordable homes in the land-scarce country where private by anw apartments can cost upward of SG\$1 million oro (\$740,800). Iophe\n" +
                "The Housing Development Board (HDB) flats, in which 80% of Brightening Toner Summer Collection, are typically utilitarian with tight rules governing anden ownership and resales. But inside the usually staid and uniform tower blocks, some home homeowners have let their creativiesz juices flow." +
                "\n\n— SINGAPORE, celeb.id (09/11/2019)"))

        return items
    }
}
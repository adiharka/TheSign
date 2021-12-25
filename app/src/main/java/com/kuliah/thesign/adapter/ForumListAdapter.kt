package com.kuliah.thesign.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kuliah.thesign.R
import com.kuliah.thesign.model.ForumModelClass

class ForumListAdapter(var mCtx: Context, var resource:Int, var items:List<ForumModelClass>)
    : ArrayAdapter<ForumModelClass>( mCtx , resource , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        var forum: ForumModelClass = items[position]

        val view: View = layoutInflater.inflate(resource, null)
        val replies = forum.replies.toString() + " balasan"

        view.findViewById<TextView>(R.id.forum_id).text = forum.id.toString()
        view.findViewById<TextView>(R.id.username).text = forum.username
        view.findViewById<TextView>(R.id.topic).text = forum.topic
        view.findViewById<TextView>(R.id.content).text = forum.content
        view.findViewById<TextView>(R.id.replies).text = replies

        return view
    }
}

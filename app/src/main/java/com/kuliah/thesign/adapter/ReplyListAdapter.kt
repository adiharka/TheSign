package com.kuliah.thesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kuliah.thesign.R
import com.kuliah.thesign.model.ReplyModelClass

class ReplyListAdapter(var mCtx: Context, var resource:Int, var items:List<ReplyModelClass>)
    : ArrayAdapter<ReplyModelClass>( mCtx , resource , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        var forum: ReplyModelClass = items[position]

        val view: View = layoutInflater.inflate(resource, null)

        view.findViewById<TextView>(R.id.username).text = forum.username
        view.findViewById<TextView>(R.id.reply).text = forum.reply

        return view
    }
}
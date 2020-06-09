package com.example.volley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(context : Context, var list : List<newsModel>) : ArrayAdapter<newsModel>(context,0) {

    lateinit var view: View
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): newsModel? {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.countrieslayout,parent,false)
            val model = list[position]
            val country = view.findViewById<TextView>(R.id.country)
            val region  = view.findViewById<TextView>(R.id.region)
            country.text = model.country
            region.text = model.region

        }
        view.tag = convertView
        return view
    }
}
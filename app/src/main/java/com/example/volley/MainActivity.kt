package com.example.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var requestQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        requestQueue = Volley.newRequestQueue(this)
        listview.adapter = CustomAdapter(this,getData())
    }

    fun getData() : ArrayList<newsModel>{
        val list = ArrayList<newsModel>()
        val url  = "https://api.first.org/data/v1/countries?region=africa"

        var jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener<JSONObject> { response ->
                val data  = response.getJSONObject("data")
                val codes = data.getJSONObject("DZ")
                list.add(newsModel(codes.getString("country"),codes.getString("region")))
            },
            Response.ErrorListener { error -> Log.d("TG","error ${error.toString()}") })
        requestQueue.add(jsonObjectRequest)
        return list

    }
}
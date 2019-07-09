package br.ufpe.cin.if710.p3.utils

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.io.IOException

class API (val context: Context) {

    private val baseURL = "https://healthierlife.herokuapp.com"
    private val mealsPathURL = "/meals"
    private val insightsPathURL = "/insights"
    private val queue: RequestQueue = Volley.newRequestQueue(context)

    private fun getURL(path: String) : String {
        return baseURL + path
    }

    private fun request(url: String, data: JSONObject?, listener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) : Boolean{
        try {
            val stringRequest = JsonObjectRequest(url, data, listener, errorListener)
            queue?.add(stringRequest)
            return true
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }

    fun getInsights(listener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) : Boolean {
        val url = getURL(insightsPathURL)
        return request(url, null, listener, errorListener)
    }

    fun sendMeal(listener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) : Boolean {
        val url = getURL(mealsPathURL)
        return request(url, null, listener, errorListener)
    }

}
package com.projects.infralayertask

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import okhttp3.OkHttpClient
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private val API_BASE_URL = "https://arabic.cnn.com/api/v1/rss/world/"
    private val newsfeed: NewsFeed? = null
    private var newsList: List<NewsFeed>? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager


        getNews()
        // print();
    }

    private fun getNews() {
        val loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false)

        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

        val api = retrofit.create<NewsAPI>(NewsAPI::class.java)

        val call = api.news
        call.enqueue(object : Callback<Responsee> {
            override fun onResponse(call: Call<Responsee>, response: Response<Responsee>) {
                newsList = response.body().news
                val p = ArrayList(newsList!!)
                adapter = NewsAdapter(p, applicationContext)
                recyclerView!!.adapter = adapter
                loading.dismiss()
            }

            override fun onFailure(call: Call<Responsee>, t: Throwable) {
                loading.dismiss()
                println(t.localizedMessage)
            }
        })
    }
}

package com.projects.infralayertask

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

internal class NewsAdapter(private val planetList: ArrayList<NewsFeed>, context: Context) : RecyclerView.Adapter<NewsAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.PlanetViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        val viewHolder = PlanetViewHolder(inflater)
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsAdapter.PlanetViewHolder, position: Int) {
        //        holder.image.setImageResource(R.drawable.planetimage);

        var detail = ""
        // detail += "ID: "+planetList.get(position).getId() + "\n";
        detail += "Title: " + planetList[position].title + "\n"
        detail += "Image: " + planetList[position].url + "\n"
        detail += "Description: " + planetList[position].description + "\n"
        detail += "Category: " + planetList[position].category + "\n"
        detail += "Publishing Date: " + planetList[position].pubDate + "\n"
        holder.text.text = detail
        ImageLoadTask(planetList[position].url, holder.image).execute()

    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    internal class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var text: TextView

        init {
            image = itemView.findViewById(R.id.image_id) as ImageView
            text = itemView.findViewById(R.id.text_id) as TextView
        }
    }
}
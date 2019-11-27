package com.huda.submission_1_made

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FilmAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var film = arrayListOf<Film>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val film = getItem(position) as Film
        viewHolder.bind(film)
        return itemView
    }

    override fun getCount(): Int = film.size

    override fun getItem(i: Int): Any = film[i]

    override fun getItemId(i: Int): Long = i.toLong()

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
        internal fun bind(film: Film) {
            txtName.text = film.name
            txtDescription.text = film.description
            Glide.with(context).load(film.photo).override(512, 512).into(imgPhoto)
        }
    }

}
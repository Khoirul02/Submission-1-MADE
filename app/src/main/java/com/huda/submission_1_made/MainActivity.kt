package com.huda.submission_1_made

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FilmAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: Array<String>
    private var daftarfilm = arrayListOf<Film>()

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_list)
        adapter = FilmAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_FILM, daftarfilm[position])
            startActivity(intent)

        }
    }
    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.getStringArray(R.array.data_photo)
    }
    private fun addItem() {
        for (position in dataName.indices) {
            val film = Film(
                dataPhoto[position],
                dataName[position],
                dataDescription[position]
            )
            daftarfilm.add(film)
        }
        adapter.film = daftarfilm
    }
}

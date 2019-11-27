package com.huda.submission_1_made

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama: TextView = findViewById(R.id.txt_name_detail)
        val deskripsi: TextView = findViewById(R.id.txt_description_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_photo_detail)


        val film = intent.getParcelableExtra(EXTRA_FILM) as? Film
        val nametext = "${film?.name}"
        val deskripsitext = "${film?.description}"
        val photo = "${film?.photo}"

        nama.text = nametext
        deskripsi.text = deskripsitext
        Glide.with(this).load(film?.photo).override(512, 512).into(imgPhoto)

    }
}

package com.example.hanrry

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_DESC = "key_desc"
        const val KEY_IMAGE = "key_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailactivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = intent.getParcelableExtra<Foo>("DATA")
        Log.d("Detail Data", data?.name.toString())

        val name = intent.getStringExtra(KEY_NAME)
        val desc = intent.getStringExtra(KEY_DESC)
        val imageResId = intent.getIntExtra(KEY_IMAGE, 0)

        findViewById<TextView>(R.id.detail_name).text = name
        findViewById<TextView>(R.id.detail_desc).text = desc
        findViewById<ImageView>(R.id.detail_img).setImageResource(imageResId)


//        val hero = intent.getParcelableExtra<Foo>(KEY_HERO)
//        val intent = Intent(this, DetailActivity::class.java)
//        intent.putExtra(DetailActivity.KEY_HERO, hero)
//        startActivity(intent)
//
//        val title = intent.getStringExtra("TITLE")
//        val description = intent.getStringExtra("DESCRIPTION")
//        val image = intent.getIntExtra("IMAGE", 0)
//
//        val titleTextView: TextView = findViewById(R.id.detail_name)
//        val descriptionTextView: TextView = findViewById(R.id.detail_desc)
//        val imageView: ImageView = findViewById(R.id.detail_img)
//
//        titleTextView.text = title
//        descriptionTextView.text = description
//        imageView.setImageResource(image)
    }

}
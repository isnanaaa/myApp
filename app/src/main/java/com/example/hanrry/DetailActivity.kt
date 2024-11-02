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
        const val KEY_WHERE = "key_where"
        const val KEY_TYPE = "key_type"
        const val KEY_HISTORY = "key_history"
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
        val where = intent.getStringExtra(KEY_WHERE)
        val type = intent.getStringExtra(KEY_TYPE)
        val history = intent.getStringExtra(KEY_HISTORY)

        findViewById<TextView>(R.id.detail_name).text = name
        findViewById<TextView>(R.id.detail_desc).text = desc
        findViewById<ImageView>(R.id.detail_img).setImageResource(imageResId)
        findViewById<TextView>(R.id.detail_name).text = where
        findViewById<TextView>(R.id.detail_name).text = type
        findViewById<TextView>(R.id.detail_name).text = history
    }
}
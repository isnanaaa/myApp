package com.example.hanrry

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<Foo>()
    private fun showSelectedItem(hero: Foo) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_heroes)
        rvFoods.setHasFixedSize(true)

        list.addAll(getListFoods())
        showRecyclerList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFoods.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFoods.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFoods(): ArrayList<Foo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFoo = ArrayList<Foo>()
        for (i in dataName.indices) {
            val hero = Foo(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFoo.add(hero)
        }
        return listFoo
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val fooAdapter = FooAdapter(list)

        rvFoods.adapter = fooAdapter

        fooAdapter.setOnItemClickCallback(object : FooAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Foo) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
                showSelectedItem(data)
            }
        })
    }
}
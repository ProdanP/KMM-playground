package com.prodan.kmm_playground.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prodan.kmm_playground.Greeting
import com.prodan.kmm_playground.data.ApiService
import com.prodan.kmm_playground.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()*/
        lifecycleScope.launchWhenCreated {
            withContext(Dispatchers.IO) {
                val users = ApiService().getRandomUsers()
                runOnUiThread {
                    initAdapter(users.results)
                }
            }
        }
    }

    private fun initAdapter(users: List<User>) {
        val recycler: RecyclerView = findViewById(R.id.recycleView)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AdapterMain(users)
    }

}

package com.example.contactcategory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactcategory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    lateinit var recycler: RecyclerView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        toolbar = bind.toolbar
        toolbar.title = "Contact Group"
        setSupportActionBar(toolbar)

        val list = listOf("Family", "Friends", "Colleague", "Tutor", "Business")
        recycler = bind.recycler
        val layout = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false)
        val adapt = CustomAdapter(this, list)

        recycler.layoutManager = layout
        recycler.adapter = adapt

    }
}
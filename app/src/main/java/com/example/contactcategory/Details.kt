package com.example.contactcategory




import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import com.example.contactcategory.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    lateinit var bind: ActivityDetailsBinding
    lateinit var toolbar: Toolbar
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseCompatLoadingForDrawables")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailsBinding.inflate(layoutInflater)

        val intent = intent

        setContentView(bind.root)
        toolbar = bind.toolbar
        toolbar.title = intent.getStringExtra("CATEGORY")

        setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.navigationIcon = getDrawable(R.drawable.back_icon)

        toolbar.setNavigationOnClickListener {
            setResult(0, intent)
            finish()
        }
    }
}
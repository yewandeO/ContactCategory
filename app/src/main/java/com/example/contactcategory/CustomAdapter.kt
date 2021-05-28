package com.example.contactcategory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val context: Context, private val list: List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    inner class ViewHolder(private val textView: View): RecyclerView.ViewHolder(textView) {
        val text1: TextView
        val text2: TextView

        init{
            text1 = itemView.findViewById(R.id.text1)
            text2 = itemView.findViewById(R.id.text2)
            itemView.setOnClickListener {
                callDetailsActivity()
            }
        }

        private fun callDetailsActivity() {
            val intent = Intent(context, Details::class.java).apply {
                putExtra("CATEGORY",itemView.findViewById<TextView>(R.id.text2).text.toString())
            }
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_custom_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text = list[position].first().toUpperCase().toString()
        holder.text2.text = list[position]
    }

    override fun getItemCount() = list.size
}

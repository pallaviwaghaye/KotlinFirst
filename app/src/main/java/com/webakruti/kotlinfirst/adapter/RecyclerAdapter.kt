package com.webakruti.kotlinfirst.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.webakruti.kotlinfirst.MainActivity
import com.webakruti.kotlinfirst.R


/**
 * Created by DELL on 1/29/2019.
 */
internal class RecyclerAdapter(private val ctx: Context, private val size: Int) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater


    init {

        inflater = LayoutInflater.from(ctx)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.item_recycler_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        /*holder.iv.setImageResource(imageModelArrayList[position].getImage_drawables())
        holder.time.setText(imageModelArrayList[position].getNames())*/

        /*holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(ctx, MainActivity::class.java)
            startActivity(intent)
            //ctx.startActivity(Intent(ctx, MainActivity::class.java))
        })*/

        holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(ctx, MainActivity::class.java)
            ctx.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return size
    }

    inner internal class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewSubcategoryName: TextView
        var cardView: CardView

        init {

            textViewSubcategoryName = itemView.findViewById<TextView>(R.id.textViewSubcategoryName) //as TextView
            //iv = itemView.findViewById(R.id.iv) //as ImageView
            cardView = itemView.findViewById<CardView>(R.id.cardView)
        }

    }
}

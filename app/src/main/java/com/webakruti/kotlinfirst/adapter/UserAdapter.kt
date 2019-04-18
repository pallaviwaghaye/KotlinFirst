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
import com.webakruti.kotlinfirst.R.id.cardView
import com.webakruti.kotlinfirst.model.User

/**
 * Created by DELL on 1/29/2019.
 */
internal class UserAdapter( val context: Context,val postList: List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater


    init {

        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.item_user, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtPostTitle.setText(postList[position].getTitle())
        holder.txtPostBody.setText(postList[position].getBody())

        /*holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(ctx, MainActivity::class.java)
            startActivity(intent)
            //ctx.startActivity(Intent(ctx, MainActivity::class.java))
        })*/

        /*holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        })*/

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner internal class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtPostTitle: TextView
        var txtPostBody: TextView

        init {

            txtPostTitle = itemView.findViewById<TextView>(R.id.txtPostTitle) //as TextView
            //iv = itemView.findViewById(R.id.iv) //as ImageView
            txtPostBody = itemView.findViewById<TextView>(R.id.txtPostBody)
        }

    }
}
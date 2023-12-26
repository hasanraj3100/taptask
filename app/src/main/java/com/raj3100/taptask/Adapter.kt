package com.raj3100.taptask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.graphics.Color
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataList: ArrayList<Task>): RecyclerView.Adapter<Adapter.ViewHolderClass>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.title.text = currentItem.title
        holder.priority.text = currentItem.priority.toString()

        if(currentItem.priority == 1) {
            holder.card.setBackgroundColor(Color.parseColor("#f6d167"))

        }
        else if(currentItem.priority == 0) holder.card.setBackgroundColor(Color.parseColor("#297f87"))
        else if(currentItem.priority == 2) holder.card.setBackgroundColor(Color.parseColor("#df2e2e"))



    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val priority: TextView = itemView.findViewById(R.id.priority)
        val card: LinearLayout = itemView.findViewById(R.id.card)
    }


}
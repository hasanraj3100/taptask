package com.raj3100.taptask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.graphics.Color
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.widget.LinearLayout
import androidx.compose.foundation.layout.Row
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        holder.priority.text = getPriorityString(currentItem.priority)





        toggleStrikeThrough(holder.title, holder.priority, currentItem.isFinished, holder, currentItem.priority)

        holder.card.setOnClickListener {

            currentItem.isFinished = if (currentItem.isFinished == 1)  0 else 1
            toggleStrikeThrough(holder.title, holder.priority, currentItem.isFinished, holder, currentItem.priority)
            UpdateRepository.updateTheTask(currentItem.id, currentItem.isFinished)
        }

    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val priority: TextView = itemView.findViewById(R.id.priority)
        val card: LinearLayout = itemView.findViewById(R.id.card)
    }


    fun toggleStrikeThrough(title:TextView, priority: TextView, isFinished:Int, holder:ViewHolderClass, prioInt: Int) {
        if(isFinished == 1) {
            title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG
            priority.paintFlags = priority.paintFlags or STRIKE_THRU_TEXT_FLAG
            holder.card.setBackgroundColor(Color.rgb(45,45,45))
          //  holder.card.setBackgroundColor(Color.rgb(45,45,45))
        } else {
            title.paintFlags = title.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
            priority.paintFlags = priority.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

            holder.card.setBackgroundColor(Color.parseColor(getColorFromPriority(prioInt)))
            if(prioInt == 1) {
                holder.title.setTextColor(Color.rgb(0,0,0,))
                holder.priority.setTextColor(Color.rgb(0,0,0,))
            }
        }
    }

    fun getColorFromPriority(priority:Int) : String {

        when(priority) {
            0 -> return "#297f87"
            1 -> return "#f6d167"
            2 -> return "#df2e2e"
        }

        return "#00000"

    }

    fun getPriorityString(priority: Int): String {
        when(priority) {
            0 -> return "Priority : Low"
            1 -> return "Priority : Medium"
            2 -> return "Priority : High"
        }

        return ""
    }

    fun clearList() {
        dataList.removeAll {
            it.id > 0
        }
        notifyDataSetChanged()
    }
}
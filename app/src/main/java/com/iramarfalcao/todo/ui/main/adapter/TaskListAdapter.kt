package com.iramarfalcao.todo.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iramarfalcao.todo.R
import com.iramarfalcao.todo.model.TaskList

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapterViewHolder>() {

    private var taskList = emptyList<TaskList>()

    inner class TaskListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListAdapterViewHolder =
        TaskListAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )

    override fun getItemCount(): Int = taskList.size

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        val title: String = taskList[position].title
        val description: String = taskList[position].description
        val color: String = taskList[position].color

        holder.itemView.findViewById<TextView>(R.id.tvTitle).text = title
        holder.itemView.findViewById<TextView>(R.id.tvDescription).text = description
        holder.itemView.background.setTint(Color.parseColor(color))
    }

    fun setData(newTaskList: List<TaskList>) {
        taskList = newTaskList
        notifyDataSetChanged()
    }
}

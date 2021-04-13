package com.iramarfalcao.todo.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iramarfalcao.todo.R
import com.iramarfalcao.todo.model.TaskList
import com.iramarfalcao.todo.ui.main.adapter.TaskListAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var ivNoContent: ImageView
    private lateinit var noContent: View
    private lateinit var rvList: RecyclerView

    private lateinit var homeViewModel: HomeViewModel
    private val taskListAdapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList = findViewById(R.id.rvList)
        rvList.adapter = taskListAdapter
        rvList.layoutManager = LinearLayoutManager(this)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.taskList.observe(this, Observer { taskListAdapter(it) })
//        taskListAdapter.setData(homeViewModel.taskList.observe())

//        val swipeHandler = object : SwipeToDeleteCallback(this) {
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val adapter = recyclerView.adapter as SimpleAdapter
//                adapter.removeAt(viewHolder.adapterPosition)
//            }
//        }
//        val itemTouchHelper = ItemTouchHelper(swipeHandler)
//        itemTouchHelper.attachToRecyclerView(recyclerView)
//
//        addItemBtn.setOnClickListener(this)


        setNoContentWhenEmptyList(taskListAdapter.itemCount)
    }

    private fun setNoContentWhenEmptyList(listSize: Int) {
        noContent = findViewById(R.id.noContent)
        ivNoContent = findViewById(R.id.ivNoContent)

        if (listSize > 0) ivNoContent.visibility = View.GONE
        else ivNoContent.visibility = View.VISIBLE

        when (resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> ivNoContent.setImageResource(R.drawable.ic_image_no_content_dark)
            else -> ivNoContent.setImageResource(R.drawable.ic_image_no_content)
        }
    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.addItemBtn -> simpleAdapter.addItem("New item")
//        }
//    }
}

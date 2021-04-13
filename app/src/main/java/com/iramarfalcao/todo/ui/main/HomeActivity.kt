package com.iramarfalcao.todo.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.iramarfalcao.todo.R

class HomeActivity : AppCompatActivity() {

    private lateinit var ivNoContent: ImageView
    private lateinit var noContent: View
    private lateinit var rvList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList = findViewById(R.id.rvList)
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

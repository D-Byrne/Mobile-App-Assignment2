package org.wit.soulsbuildplanner.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_build_list.*
import kotlinx.android.synthetic.main.card_build.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.main.MainApp
import org.wit.soulsbuildplanner.models.BuildModel

class BuildListActivity : AppCompatActivity(), BuildListener {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_list)
        app = application as MainApp

        toolbar.title = title
        setSupportActionBar(toolbar)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = BuildAdapter(app.builds.findAll(), this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        recyclerView.adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> startActivityForResult<BuildPlannerActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBuildClick(build: BuildModel) {
        startActivityForResult(intentFor<BuildPlannerActivity>().putExtra("build_edit", build), 0)
    }

}
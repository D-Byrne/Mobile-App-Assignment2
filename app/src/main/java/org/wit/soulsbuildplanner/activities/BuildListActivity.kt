package org.wit.soulsbuildplanner.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_build_info.*
import kotlinx.android.synthetic.main.activity_build_list.*
import kotlinx.android.synthetic.main.activity_build_planner.*
import kotlinx.android.synthetic.main.activity_build_planner.toolbarAdd
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
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadBuilds()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadBuilds()
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {startActivityForResult<BuildPlannerActivity>(0)}
            R.id.item_info -> {startActivityForResult<BuildPlannerInfoActivity>(0)}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBuildClick(build: BuildModel) {
        startActivityForResult(intentFor<BuildPlannerActivity>().putExtra("build_edit", build), 0)
    }

    private fun loadBuilds(){
        showBuilds(app.builds.findAll())
    }

    fun showBuilds(builds: List<BuildModel>){
        recyclerView.adapter = BuildAdapter(builds, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }

}
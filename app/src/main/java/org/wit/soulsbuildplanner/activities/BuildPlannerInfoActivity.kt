package org.wit.soulsbuildplanner.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_build_info.*
import kotlinx.android.synthetic.main.activity_build_list.*
import org.jetbrains.anko.startActivityForResult
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.main.MainApp

class BuildPlannerInfoActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_info)

        app = application as MainApp

        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        //toolbar.setTitle("No. of Builds: " + app.builds.findAll().size)
        toolbarAdd.setTitle("Info")

        val textView: TextView = findViewById(R.id.buildNumber)
        textView.setText(getString(R.string.buildNumConcat, app.builds.findAll().size))



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_build_planner, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
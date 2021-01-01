package org.wit.soulsbuildplanner.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import kotlinx.android.synthetic.main.activity_build_planner.*
import org.jetbrains.anko.toast
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.models.BuildModel

class BuildPlannerActivity : AppCompatActivity(), AnkoLogger {

    var build = BuildModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_planner)
        info("Build Planner Activity Started...")

        btnAdd.setOnClickListener(){
            build.title = buildTitle.text.toString()
            if(build.title.isNotEmpty()) {
                info { "Add Button Pressed: $buildTitle" }
            }
            else{
                toast("Please Enter a Title")
            }
        }


    }
}
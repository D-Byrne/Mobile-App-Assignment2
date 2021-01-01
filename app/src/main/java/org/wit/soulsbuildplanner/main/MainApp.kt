package org.wit.soulsbuildplanner.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.soulsbuildplanner.models.BuildModel

class MainApp: Application(), AnkoLogger {

    val builds = ArrayList<BuildModel>()


    override fun onCreate(){
        super.onCreate()
        info("Souls Build Planner Started")

       // builds.add(BuildModel("Quality", 20, 15, 35, 40, 40, 35, 7, 7, 7, 213, 111111111, 22222222))
       // builds.add(BuildModel("Strength", 20, 15, 35, 40, 40, 35, 7, 7, 7, 213, 111111111, 22222222))
       // builds.add(BuildModel("Dexterity", 20, 15, 35, 40, 40, 35, 7, 7, 7, 213, 111111111, 22222222))

    }
}
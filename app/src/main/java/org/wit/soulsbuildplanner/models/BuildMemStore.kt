package org.wit.soulsbuildplanner.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class BuildMemStore: BuildStore, AnkoLogger {

    val builds = ArrayList<BuildModel>()

    override fun findAll(): List<BuildModel> {
        return builds
    }

    override fun create(build: BuildModel){
        builds.add(build)
        logAll()
    }

    fun logAll(){
        builds.forEach{ info("${it}")}
    }
}
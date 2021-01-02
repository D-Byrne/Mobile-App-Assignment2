package org.wit.soulsbuildplanner.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class BuildMemStore: BuildStore, AnkoLogger {

    val builds = ArrayList<BuildModel>()

    override fun findAll(): List<BuildModel> {
        return builds
    }

    override fun create(build: BuildModel){
        build.id = getId()
        builds.add(build)
        logAll()
    }

    override fun update(build: BuildModel){
        var foundBuild: BuildModel? = builds.find { p -> p.id == build.id }
        if(foundBuild != null) {
            foundBuild.title = build.title
            foundBuild.vigor = build.vigor
            foundBuild.attunement = build.attunement
            foundBuild.endurance = build.endurance
            foundBuild.vitality = build.vitality
            foundBuild.strength = build.strength
            foundBuild.dexterity = build.dexterity
            foundBuild.intelligence = build.intelligence
            foundBuild.faith = build.faith
            foundBuild.luck = build.luck
            foundBuild.level = build.level
            foundBuild.nextLevel = build.nextLevel
            foundBuild.totalSouls = build.totalSouls
            foundBuild.image = build.image
        }
    }

    fun logAll(){
        builds.forEach{ info("${it}")}
    }
}
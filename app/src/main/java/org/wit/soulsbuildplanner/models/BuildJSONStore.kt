package org.wit.soulsbuildplanner.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.wit.soulsbuildplanner.helpers.*
import java.util.*

val JSON_FILE = "builds.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<BuildModel>>() {}.type

fun generateRandomId(): Long{
    return Random().nextLong()
}

class BuildJSONStore : BuildStore, AnkoLogger {

    val context: Context
    var builds = mutableListOf<BuildModel>()

    constructor(context: Context) {
        this.context = context
        if(exists(context, JSON_FILE)) {
                deserialize()
            }
    }

    override fun findAll(): MutableList<BuildModel> {
        return builds
    }

    override fun create(build: BuildModel){
        build.id = generateRandomId()
        builds.add(build)
        serialize()
    }

    override fun update(build: BuildModel){
        val buildsList = findAll() as ArrayList<BuildModel>
        var foundBuild: BuildModel? = buildsList.find { p -> p.id == build.id }
        if(foundBuild != null){
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
        serialize()
    }

    override fun delete(build: BuildModel){
        builds.remove(build)
        serialize()
    }

    private fun serialize(){
        val jsonString = gsonBuilder.toJson(builds, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(context, JSON_FILE)
        builds = Gson().fromJson(jsonString, listType)
    }

}
package org.wit.soulsbuildplanner.models

interface BuildStore {
    fun findAll(): List<BuildModel>
    fun create(build: BuildModel)
    fun update (build: BuildModel)
}
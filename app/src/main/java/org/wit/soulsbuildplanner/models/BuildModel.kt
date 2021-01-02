package org.wit.soulsbuildplanner.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BuildModel(var title: String = "",
                      var vigor: Int = 0,
                      var attunement: Int = 0,
                      var endurance: Int = 0,
                      var vitality: Int = 0,
                      var strength: Int = 0,
                      var dexterity: Int = 0,
                      var intelligence: Int = 0,
                      var faith: Int = 0,
                      var luck: Int =0,
                      var level: Int = 0,
                      var nextLevel: Int = 0,
                      var totalSouls: Long = 0
) : Parcelable
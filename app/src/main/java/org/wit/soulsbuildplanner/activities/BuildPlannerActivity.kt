package org.wit.soulsbuildplanner.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import kotlinx.android.synthetic.main.activity_build_planner.*
import org.jetbrains.anko.toast
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.main.MainApp
import org.wit.soulsbuildplanner.models.BuildModel

class BuildPlannerActivity : AppCompatActivity(), AnkoLogger {

    var build = BuildModel()
    //val builds = ArrayList<BuildModel>()
    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_planner)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)

        app = application as MainApp

        var edit = false

        if(intent.hasExtra("build_edit")) {
            edit = true
            build = intent.extras?.getParcelable<BuildModel>("build_edit")!!
            buildTitle.setText(build.title)
            buildVigor.setText(build.vigor.toString())
            buildAttunement.setText(build.attunement.toString())
            buildEndurance.setText(build.endurance.toString())
            buildVitality.setText(build.vitality.toString())
            buildStrength.setText(build.strength.toString())
            buildDexterity.setText(build.dexterity.toString())
            buildIntelligence.setText(build.intelligence.toString())
            buildFaith.setText(build.faith.toString())
            buildLuck.setText(build.luck.toString())

            btnAdd.setText(R.string.save_build)
        }

        btnAdd.setOnClickListener(){
            build.title = buildTitle.text.toString()
            build.vigor = buildVigor.text.toString().toInt()
            build.attunement = buildAttunement.text.toString().toInt()
            build.endurance = buildEndurance.text.toString().toInt()
            build.vitality = buildVitality.text.toString().toInt()
            build.strength = buildStrength.text.toString().toInt()
            build.dexterity = buildDexterity.text.toString().toInt()
            build.intelligence = buildIntelligence.text.toString().toInt()
            build.faith = buildIntelligence.text.toString().toInt()
            build.luck = buildLuck.text.toString().toInt()
            build.level = build.vigor + build.attunement + build.endurance + build.vitality + build.strength + build.dexterity + build.intelligence + build.faith + build.luck
            build.nextLevel = calcNextLevel(build.level)
            build.totalSouls = totalSouls(build.level)

            if(build.title.isEmpty()){
                toast(R.string.enter_build_title)
            } else {
                if(edit){
                    app.builds.update(build.copy())
                } else{
                    app.builds.create(build.copy())
                }
            }
            info("Add Button Pressed: $buildTitle")
            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
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

    fun calcNextLevel(lvl: Int): Int {
        val numCalc = (0.02*(lvl*lvl*lvl)) + (3.06*(lvl*lvl)) + (105.6*(lvl)) - (895)
        return numCalc.toInt()
    }

    fun totalSouls(lvl: Int): Long {
        var totSouls: Int = 0

        for (i in 1..lvl){
            totSouls += calcNextLevel(totSouls)
        }

        return totSouls.toLong()
    }
}
package org.wit.soulsbuildplanner.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_build_list.*
import kotlinx.android.synthetic.main.card_build.view.*
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.main.MainApp
import org.wit.soulsbuildplanner.models.BuildModel

class BuildListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = BuildAdapter(app.builds)

    }

}

class BuildAdapter constructor(private var builds: List<BuildModel>) :
        RecyclerView.Adapter<BuildAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_build, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int){
        val build = builds[holder.adapterPosition]
        holder.bind(build)
    }


override fun getItemCount(): Int = builds.size

class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(build: BuildModel) {
        itemView.buildTitle.text = build.title
        itemView.vigor.text = "Vigor: " + build.vigor.toString()
        itemView.attunement.text = "Attunement: " +build.attunement.toString()
        itemView.endurance.text = "Endurance: " +build.endurance.toString()
        itemView.vitality.text = "Vitality: " +build.vitality.toString()
        itemView.strength.text = "Strength: " +build.strength.toString()
        itemView.dexterity.text = "Dexterity: " +build.dexterity.toString()
        itemView.intelligence.text = "Intelligence: " +build.intelligence.toString()
        itemView.faith.text = "Faith: " +build.faith.toString()
        itemView.luck.text = "Luck: " +build.luck.toString()
        itemView.level.text = build.level.toString()
        itemView.nextLevel.text = build.nextLevel.toString()
        itemView.totalSouls.text = build.totalSouls.toString()

    }
}
}
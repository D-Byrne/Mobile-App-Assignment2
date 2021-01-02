package org.wit.soulsbuildplanner.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_build.view.*
import org.wit.soulsbuildplanner.R
import org.wit.soulsbuildplanner.models.BuildModel

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
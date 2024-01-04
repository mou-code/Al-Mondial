package com.worldcup.almondial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.database.entities.PlayerEntity
import com.worldcup.almondial.database.entities.TeamEntity
import com.worldcup.almondial.databinding.ActivityDetailTeamBinding
import com.worldcup.almondial.ui_.PlayerAdapter
import com.worldcup.almondial.ui_.home_screen.MatchAdapterScreen
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.fragment_homescreen.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class TeamDetailActivity : BaseActivity() {

    companion object {
        fun start(context: Context, teamId: String) {
            context.startActivity(
                Intent(context, TeamDetailActivity::class.java)
                    .putExtra(BundleKeys.TEAM_ID, teamId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailTeamBinding>(this, R.layout.activity_detail_team)
        setupToolbar(toolbar, getString(R.string.label_detail_team), true)
        tvToolbarTitle.text = getString(R.string.label_detail_team)
        val teamId = intent.getStringExtra(BundleKeys.TEAM_ID)
        binding.team = TeamEntity(3,"Brazil",4,"Coca-Cola","Adenor Leonardo")

        when(teamId){
            "Argentina" -> binding.team = TeamEntity(0,"Argentina",1,"Adidas","Lionel Scaloni")
            "France" -> binding.team = TeamEntity(1,"France",2,"Qatar Energys","Didier Claude")
            "Germany" -> binding.team = TeamEntity(2,"Germany",3,"Wanda Group","Hansi Flick")
            "Brazil" -> binding.team = TeamEntity(3,"Brazil",4,"Coca-Cola","Adenor Leonardo")
        }
        val playerAdapter =
            PlayerAdapter(PlayerAdapter.PlayerListener { player ->
                player.let {
                    PlayerDetailActivity.start(this, it.Name)
                }
            })

        val testplayer = PlayerEntity(1,"Moustafa","20","Egypt",1,2,3,"STRIKER")
        playerAdapter.addHeaderAndSubmitList(
            listOf(
                testplayer,
                testplayer,
                testplayer,
                testplayer,
                testplayer
            )
        )
        PlayersList.adapter = playerAdapter
        binding.cardViewCoach.setOnClickListener{
            CoachDetailActivity.start(this, binding.team!!.Coach_Name)
        }
        binding.button.setOnClickListener{
            TeamMatchesActivity.start(this, binding.team!!.id.toString())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}

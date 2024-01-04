package com.worldcup.almondial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.database.entities.TeamEntity
import com.worldcup.almondial.databinding.ActivityDetailMatchBinding
import com.worldcup.almondial.databinding.ActivityMainBinding
import com.worldcup.almondial.databinding.ActivityTeamMatchesBinding
import com.worldcup.almondial.ui_.home_screen.MatchAdapterScreen
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.fragment_homescreen.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class TeamMatchesActivity : BaseActivity() {

    companion object {
        fun start(context: Context, teamId: String) {
            context.startActivity(
                Intent(context, TeamMatchesActivity::class.java)
                    .putExtra(BundleKeys.TEAM_ID, teamId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTeamMatchesBinding>(this, R.layout.activity_team_matches)

        setupToolbar(toolbar, getString(R.string.label_detail_teammatches), true)
        tvToolbarTitle.text = getString(R.string.label_detail_teammatches)
        val teamId = intent.getStringExtra(BundleKeys.TEAM_ID)

        val matchAdapter =
            com.worldcup.almondial.ui_.home_screen.MatchAdapter(com.worldcup.almondial.ui_.home_screen.MatchAdapter.MatchListener { news ->
                news.let {
                    MatchDetailActivity.start(this, it.match_id.toString())
                }
            }, MatchAdapterScreen.HOMESCREEN)

        val testmatch = MatchEntity(1,"17-3-2002","6:00 PM","Argentina","France","2 - 2", "Alghandor","Cairo Stadium","Nike","Adidas","Micheal","Ahmed","GROUPS | A")
        matchAdapter.addHeaderAndSubmitList(
            listOf(
                testmatch,
                testmatch,
                testmatch,
                testmatch,
                testmatch
            )
        )
        HomeScreenList.setAdapter(matchAdapter);
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

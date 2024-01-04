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
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.layout_toolbar.*

class MatchDetailActivity : BaseActivity() {

    companion object {
        fun start(context: Context, matchId: String) {
            context.startActivity(
                Intent(context, MatchDetailActivity::class.java)
                    .putExtra(BundleKeys.MATCH_ID, matchId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailMatchBinding>(this, R.layout.activity_detail_match)
        val matchId = intent.getStringExtra(BundleKeys.MATCH_ID)

        setupToolbar(toolbar, getString(R.string.label_detail_match), true)
        tvToolbarTitle.text = getString(R.string.label_detail_match)
        val testmatch1 = MatchEntity(1,"17-3-2022","3:00 PM","Argentina","France","2 - 2", "Szymon Marciniak","Stadium 974","Adidas","Qatar Energy","Lionel Scaloni","Didier Claude","Quarter Final")
        val testmatch2 = MatchEntity(2,"18-3-2022","6:00 PM","Brazil","Germany","0 - 2", "Stéphanie Frappart","Al Bayt Stadium","Coca-Cola","Wanda Group","Adenor Leonardo","Hansi Flick","Round of 16")
        val testmatch3 = MatchEntity(3,"19-3-2022","9:00 PM","Argentina","France","0 - 1", "Daniele Orsato","Al Janoub Stadium","Wanda Group","Adidas","Lionel Scaloni","Didier Claude","Group C")
        val testmatch4 = MatchEntity(4,"20-3-2022","3:00 PM","Brazil","France","1 - 0", "Salima Mukansanga","Ahmad bin Ali Stadium","Qatar Energy","Adidas","Adenor Leonardo","Didier Claude","Group B")
        val testmatch5 = MatchEntity(5,"21-3-2022","6:00 PM","Argentina","Germany","3 - 3", "Antonio Mateu Lahoz","Khalifa  Stadium","Visa","Qatar Energy","Lionel Scaloni","Hansi Flick","Group A")
        when(matchId){
            "1" -> binding.match = testmatch1
            "2" -> binding.match = testmatch2
            "3" -> binding.match = testmatch3
            "4" -> binding.match = testmatch4
            "5" -> binding.match = testmatch5
        }
        binding.imgTeamHome.setOnClickListener{
            TeamDetailActivity.start(this, binding.match!!.team1name)
        }
        binding.imgTeamAway.setOnClickListener{
            TeamDetailActivity.start(this, binding.match!!.team2name)
        }
        binding.cardViewStadium.setOnClickListener{
            StadiumDetailActivity.start(this, binding.match!!.stadium)
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

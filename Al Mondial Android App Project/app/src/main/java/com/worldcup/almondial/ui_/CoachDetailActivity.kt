package com.worldcup.almondial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.database.entities.CoachEntity
import com.worldcup.almondial.databinding.ActivityDetailCoachBinding
import com.worldcup.almondial.databinding.ActivityDetailCoachBindingImpl
import com.worldcup.almondial.databinding.ActivityDetailPlayerBinding
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.layout_toolbar.*

class CoachDetailActivity : BaseActivity() {

    companion object {
        fun start(context: Context, teamId: String) {
            context.startActivity(
                Intent(context, CoachDetailActivity::class.java)
                    .putExtra(BundleKeys.COACH_ID, teamId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailCoachBinding>(this, R.layout.activity_detail_coach)
        setupToolbar(toolbar, getString(R.string.label_detail_coach), true)
        tvToolbarTitle.text = getString(R.string.label_detail_coach)
        val coachId = intent.getStringExtra(BundleKeys.COACH_ID)
        when(coachId){
            "Lionel Scaloni" -> binding.coach = CoachEntity("Lionel Scaloni","Argentina",44)
            "Didier Claude" -> binding.coach = CoachEntity("Didier Claude","France",	54)
            "Hansi Flick" -> binding.coach = CoachEntity("Hansi Flick","\tGermany",57)
            "Adenor Leonardo" -> binding.coach = CoachEntity("Adenor Leonardo","Brazil ",61)
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

package com.worldcup.almondial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.database.entities.StadiumEntity
import com.worldcup.almondial.databinding.ActivityDetailPlayerBinding
import com.worldcup.almondial.databinding.ActivityDetailStadiumBinding
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.layout_toolbar.*

class StadiumDetailActivity : BaseActivity() {

    companion object {
        fun start(context: Context, teamId: String) {
            context.startActivity(
                Intent(context, StadiumDetailActivity::class.java)
                    .putExtra(BundleKeys.STADIUM_ID, teamId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailStadiumBinding>(this, R.layout.activity_detail_stadium)
        setupToolbar(toolbar, getString(R.string.label_detail_stadium), true)
        tvToolbarTitle.text = getString(R.string.label_detail_stadium)
        val stadiumId = intent.getStringExtra(BundleKeys.STADIUM_ID)
        binding.stadium = StadiumEntity(stadiumId!!,88966,"Doha")
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

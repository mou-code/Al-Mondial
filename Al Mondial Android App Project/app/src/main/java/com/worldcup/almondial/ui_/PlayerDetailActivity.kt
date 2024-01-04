package com.worldcup.almondial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.database.entities.PlayerEntity
import com.worldcup.almondial.databinding.ActivityDetailPlayerBinding
import com.worldcup.almondial.utils.BundleKeys
import kotlinx.android.synthetic.main.layout_toolbar.*

class PlayerDetailActivity : BaseActivity() {

    companion object {
        fun start(context: Context, teamId: String) {
            context.startActivity(
                Intent(context, PlayerDetailActivity::class.java)
                    .putExtra(BundleKeys.PLAYER_ID, teamId)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailPlayerBinding>(this, R.layout.activity_detail_player)
        setupToolbar(toolbar, getString(R.string.label_detail_player), true)
        tvToolbarTitle.text = getString(R.string.label_detail_player)
        val playerId = intent.getStringExtra(BundleKeys.PLAYER_ID)
        binding.player = PlayerEntity(1,"Moustafa","20","Egypt",1,2,3,"STRIKER")

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

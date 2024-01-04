package com.worldcup.almondial.ui_

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.worldcup.almondial.R
import com.worldcup.almondial.base.BaseActivity
import com.worldcup.almondial.databinding.ActivityMainBinding
import com.worldcup.almondial.ui_.favteam_screen.FavTeamScreenFragment
import com.worldcup.almondial.ui_.groups_screen.GroupScreenFragment
import com.worldcup.almondial.ui_.home_screen.HomeScreenFragment
import com.worldcup.almondial.ui_.matches_screen.MatchScreenFragment
import com.worldcup.almondial.ui_.statistics_screen.StatisticsScreenFragment
import com.worldcup.almondial.utils.replaceFragment

class MainActivity : BaseActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(
                Intent(context, MainActivity::class.java)
            )
        }
        const val HOME_SCREEN = 1
        const val MATCHES_SCREEN = 2
        const val GROUPS_SCREEN = 3
        const val FAVTEAM_SCREEN = 4
        const val STATISTICS_SCREEN = 5
    }

    lateinit var homeScreenFragment: HomeScreenFragment
    lateinit var matchFragment: MatchScreenFragment
    lateinit var groupFragment: GroupScreenFragment
    lateinit var favteamFragment: FavTeamScreenFragment
    lateinit var statisticsScreenFragment: StatisticsScreenFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        homeScreenFragment = HomeScreenFragment()
        matchFragment = MatchScreenFragment()
        groupFragment = GroupScreenFragment()
        favteamFragment = FavTeamScreenFragment()
        statisticsScreenFragment = StatisticsScreenFragment()

        binding.bottomNavigation.apply {
            add(
                MeowBottomNavigation.Model(
                    GROUPS_SCREEN,
                    R.drawable.ic_groups
                )
            )
            add(
                MeowBottomNavigation.Model(
                    MATCHES_SCREEN,
                    R.drawable.ic_soccer
                )
            )
            add(
                MeowBottomNavigation.Model(
                    HOME_SCREEN,
                    R.drawable.ic_home
                )
            )
            add(
                MeowBottomNavigation.Model(
                    FAVTEAM_SCREEN,
                    com.worldcup.almondial.R.drawable.ic_favorite
                )
            )
            add(
                MeowBottomNavigation.Model(
                    STATISTICS_SCREEN,
                    R.drawable.ic_statistics
                )
            )
        }

        val fragmentManager: FragmentManager = supportFragmentManager
        binding.bottomNavigation.setOnShowListener {
            replaceFragment(R.id.frameMain, HomeScreenFragment.newInstance(), false)
        }

        binding.bottomNavigation.show(HOME_SCREEN)

        binding.bottomNavigation.setOnClickMenuListener {
            when (it.id) {

                2 -> {
                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.setCustomAnimations(
                        R.anim.fade_in, R.anim.exit
                    )
                    transaction.replace(R.id.frameMain, matchFragment)
                    transaction.commit()
                }
                3 -> {

                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.setCustomAnimations(
                        R.anim.fade_in, R.anim.exit
                    )
                    transaction.replace(R.id.frameMain, groupFragment)
                    transaction.commit()
                }
                4 -> {

                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.setCustomAnimations(
                        R.anim.fade_in, R.anim.exit
                    )
                    transaction.replace(R.id.frameMain, favteamFragment)
                    transaction.commit()
                }
                5 -> {

                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.setCustomAnimations(
                        R.anim.fade_in, R.anim.exit
                    )
                    transaction.replace(R.id.frameMain, statisticsScreenFragment)
                    transaction.commit()
                }

            }
        }
    }
}
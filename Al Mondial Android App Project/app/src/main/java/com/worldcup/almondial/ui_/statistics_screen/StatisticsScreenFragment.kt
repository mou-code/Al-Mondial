package com.worldcup.almondial.ui_.statistics_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worldcup.almondial.database.entities.GroupEntity
import com.worldcup.almondial.database.entities.StatisticsEntity
import com.worldcup.almondial.databinding.FragmentGroupscreenBinding
import com.worldcup.almondial.databinding.FragmentStatisticscreenBinding
import kotlinx.android.synthetic.main.fragment_groupscreen.*


class StatisticsScreenFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            StatisticsScreenFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStatisticscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val statAdapter =StatisticsAdapter()


        val testgroup = StatisticsEntity("mostgoals","1","2","3",1,2,3)
        statAdapter.addHeaderAndSubmitList(                    listOf(
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup
        ))
        GroupScreenList.setAdapter(statAdapter)
    }
}

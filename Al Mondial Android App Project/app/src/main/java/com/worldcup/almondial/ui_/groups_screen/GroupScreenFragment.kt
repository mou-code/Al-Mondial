package com.worldcup.almondial.ui_.groups_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worldcup.almondial.database.entities.GroupEntity
import com.worldcup.almondial.databinding.FragmentGroupscreenBinding
import kotlinx.android.synthetic.main.fragment_groupscreen.*


class GroupScreenFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            GroupScreenFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGroupscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val groupAdapter =GroupAdapter()


        val testgroup = GroupEntity(1, 2, 1, 2, 3, 2, 1, 3, 2, 1)
        groupAdapter.addHeaderAndSubmitList(                    listOf(
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup,
            testgroup
        ))
        GroupScreenList.setAdapter(groupAdapter)
    }
}

package com.worldcup.almondial.ui_.matches_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.databinding.FragmentMatchscreenBinding
import com.worldcup.almondial.ui.MatchDetailActivity
import com.worldcup.almondial.ui_.home_screen.MatchAdapterScreen
import kotlinx.android.synthetic.main.fragment_homescreen.*

class MatchScreenFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            MatchScreenFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMatchscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val matchAdapter =
            com.worldcup.almondial.ui_.home_screen.MatchAdapter(com.worldcup.almondial.ui_.home_screen.MatchAdapter.MatchListener { news ->
                news.let {
                    MatchDetailActivity.start(requireContext(), it.match_id.toString())
                }
            },MatchAdapterScreen.MATCHESCREEN)

        val testmatch1 = MatchEntity(1,"17-3-2022","3:00 PM","Argentina","France","2 - 2", "Szymon Marciniak","Stadium 974","Adidas","Qatar Energy","Lionel Scaloni","Didier Claude","Quarter Final")
        val testmatch2 = MatchEntity(2,"18-3-2022","6:00 PM","Brazil","Germany","0 - 2", "Stéphanie Frappart","Al Bayt Stadium","Coca-Cola","Wanda Group","Adenor Leonardo","Hansi Flick","Round of 16")
        val testmatch3 = MatchEntity(3,"19-3-2022","9:00 PM","Argentina","France","0 - 1", "Daniele Orsato","Al Janoub Stadium","Wanda Group","Adidas","Lionel Scaloni","Didier Claude","Group C")
        val testmatch4 = MatchEntity(4,"20-3-2022","3:00 PM","Brazil","France","1 - 0", "Salima Mukansanga","Ahmad bin Ali Stadium","Qatar Energy","Adidas","Adenor Leonardo","Didier Claude","Group B")
        val testmatch5 = MatchEntity(5,"21-3-2022","6:00 PM","Argentina","Germany","3 - 3", "Antonio Mateu Lahoz","Khalifa  Stadium","Visa","Qatar Energy","Lionel Scaloni","Hansi Flick","Group A")
        val matches = listOf(
            testmatch1,
            testmatch2,
            testmatch3,
            testmatch4,
            testmatch5
        )
        matchAdapter.addHeaderAndSubmitList(matches)
        HomeScreenList.setAdapter(matchAdapter);
    }

}
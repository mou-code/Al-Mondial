package com.worldcup.almondial.ui_.home_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.worldcup.almondial.base.BaseFragment
import com.worldcup.almondial.database.entities.MatchEntity
import com.worldcup.almondial.database.entities.NewsEntity
import com.worldcup.almondial.databinding.FragmentHomescreenBinding
import com.worldcup.almondial.ui.MatchDetailActivity
import kotlinx.android.synthetic.main.fragment_homescreen.*

class HomeScreenFragment : BaseFragment() {
//    private val homescreenviewModel: HomeScreenViewModel by viewModels()
    val matchAdapter = MatchAdapter(MatchAdapter.MatchListener { matches ->
        matches.let {
            MatchDetailActivity.start(requireContext(), it.match_id.toString())
        }
    },MatchAdapterScreen.HOMESCREEN)
    companion object {
        @JvmStatic
        fun newInstance() =
            HomeScreenFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomescreenBinding.inflate(inflater)

            return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val testnews1 = NewsEntity("https://www.mirror.co.uk/sport/football/news/emiliano-martinez-kylian-mbappe-worldcup-28830889", "Emiliano Martinez", "Emiliano Martinez faces awkward World Cup reunion after brutally mocking Kylian Mbappe",false, 1, true, 2)
        val testnews2 = NewsEntity("https://edition.cnn.com/2022/12/28/football/lionel-messi-neymar-kylian-mbappe-psg-spt-intl/index.html", "Lionel Messi", "Lionel Messi isn’t expected to be back with PSG until early January after World Cup success",false, 1, true, 2)
        val testnews3 = NewsEntity("https://www.marca.com/en/football/real-madrid/opinion/2022/12/27/63aab9a1e2704eb5038b458b.html", "Karim Benzema", "Karim Benzema could have played at the World Cup with France",false, 1, true, 2)
        val testnews4 = NewsEntity("https://english.ahram.org.eg/NewsContent/6/55/483333/Sports/World/Japan-coach-Moriyasu-staying-on-after-World-Cup.aspx", "Japan Coach", "Japan coach Moriyasu staying on after World Cup",false, 1, true, 2)

            val newsAdapter =
                NewsAdapter(NewsAdapter.NewsListener { news ->
                    news.let {
                        val url = it.URL
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }
                })
            newsAdapter.addHeaderAndSubmitList(listOf(testnews1, testnews2, testnews3, testnews4))
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
        val concatenated = ConcatAdapter(matchAdapter, newsAdapter);
        HomeScreenList.setAdapter(concatenated);

    }
//    private fun setupViewModelMatch() {
//        homescreenviewModel.matchList.observe(viewLifecycleOwner, loadMatchList)
//    }
//    private val loadMatchList = Observer<List<MatchEntity>> {
//        matchAdapter.addHeaderAndSubmitList(it)
//    }
}
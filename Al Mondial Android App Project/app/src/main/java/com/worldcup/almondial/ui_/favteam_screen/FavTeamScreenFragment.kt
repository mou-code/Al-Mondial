package com.worldcup.almondial.ui_.favteam_screen
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
import com.worldcup.almondial.databinding.FragmentFavteamscreenBinding
import com.worldcup.almondial.ui.MatchDetailActivity
import com.worldcup.almondial.ui_.home_screen.MatchAdapter
import com.worldcup.almondial.ui_.home_screen.MatchAdapterScreen
import com.worldcup.almondial.ui_.home_screen.NewsAdapter
import kotlinx.android.synthetic.main.fragment_favteamscreen.*

class FavTeamScreenFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            FavTeamScreenFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFavteamscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val testnews1 = NewsEntity("https://www.mirror.co.uk/sport/football/news/emiliano-martinez-kylian-mbappe-worldcup-28830889", "Emiliano Martinez", "Emiliano Martinez faces awkward World Cup reunion after brutally mocking Kylian Mbappe",false, 1, true, 2)
        val testnews2 = NewsEntity("https://edition.cnn.com/2022/12/28/football/lionel-messi-neymar-kylian-mbappe-psg-spt-intl/index.html", "Lionel Messi", "Lionel Messi isn’t expected to be back with PSG until early January after World Cup success",false, 1, true, 2)

        val newsAdapter =
            NewsAdapter(NewsAdapter.NewsListener { news ->
                news.let {
                    val url = it.URL
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
            })
        newsAdapter.addHeaderAndSubmitList(listOf(testnews1, testnews2))
        val matchAdapter =
            MatchAdapter(MatchAdapter.MatchListener { news ->
                news.let {
                    MatchDetailActivity.start(requireContext(), it.match_id.toString())
                }
            }, MatchAdapterScreen.HOMESCREEN)
        val testmatch1 = MatchEntity(1,"17-3-2022","3:00 PM","Argentina","France","2 - 2", "Szymon Marciniak","Stadium 974","Adidas","Qatar Energy","Lionel Scaloni","Didier Claude","Quarter Final")
        val testmatch3 = MatchEntity(3,"19-3-2022","9:00 PM","Argentina","France","0 - 1", "Daniele Orsato","Al Janoub Stadium","Wanda Group","Adidas","Lionel Scaloni","Didier Claude","Group C")
        val testmatch5 = MatchEntity(5,"21-3-2022","6:00 PM","Argentina","Germany","3 - 3", "Antonio Mateu Lahoz","Khalifa  Stadium","Visa","Qatar Energy","Lionel Scaloni","Hansi Flick","Group A")
        val matches = listOf(
            testmatch1,
            testmatch3,
            testmatch5
        )
        matchAdapter.addHeaderAndSubmitList(matches)
        val concatenated = ConcatAdapter(matchAdapter, newsAdapter);
        HomeScreenList.setAdapter(concatenated);

    }
}
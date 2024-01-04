package com.worldcup.almondial

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.worldcup.almondial.database.RoomDatabase
import com.worldcup.almondial.database.entities.MatchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: RoomDatabase) {
    private val matches = database.dao.getMatches()
    fun insertMatches() {
            val testmatch1 = MatchEntity(1,"17-3-2022","3:00 PM","Argentina","France","2 - 2", "Szymon Marciniak","Stadium 974","Adidas","Qatar Energy","Lionel Scaloni","Didier Claude","Quarter Final")
            val testmatch2 = MatchEntity(2,"18-3-2022","6:00 PM","Brazil","Germany","0 - 2", "Stéphanie Frappart","Al Bayt Stadium","Coca-Cola","Wanda Group","Adenor Leonardo","Hansi Flick","Round of 16")
            val testmatch3 = MatchEntity(3,"19-3-2022","9:00 PM","Argentina","France","0 - 1", "Daniele Orsato","Al Janoub Stadium","Wanda Group","Adidas","Lionel Scaloni","Didier Claude","Group C")
            val testmatch4 = MatchEntity(4,"20-3-2022","3:00 PM","Brazil","France","1 - 0", "Salima Mukansanga","Ahmad bin Ali Stadium","Qatar Energy","Adidas","Adenor Leonardo","Didier Claude","Group B")
            val testmatch5 = MatchEntity(5,"21-3-2022","6:00 PM","Argentina","Germany","3 - 3", "\n" + "Antonio Mateu Lahoz","Khalifa  Stadium","Visa","Qatar Energy","Lionel Scaloni","Hansi Flick","Group A")
                val matches_2 = listOf(
                    testmatch1,
                    testmatch2,
                    testmatch3,
                    testmatch4,
                    testmatch5
                )
            database.dao.insertAllMatches(matches_2)

    }
    fun GetMatches(): List<MatchEntity> {
        return matches
    }
}


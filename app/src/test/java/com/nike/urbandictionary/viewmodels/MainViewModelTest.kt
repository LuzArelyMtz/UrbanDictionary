package com.nike.urbandictionary.viewmodels
import androidx.lifecycle.viewModelScope
import com.nike.urbandictionary.api.model.Definition
import com.nike.urbandictionary.repository.Repository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MainViewModelTest {
    private lateinit var definitionList: List<Definition>
    private val term = "luz"

    @Test
    fun getTermUrbanDictionaryAndReturnAlistWithItems() {

        val urbanDictionaryRepository = mock(Repository::class.java)
        definitionList=listOf(
            Definition(
                "Dog is a pet",
                200,
                45,
                "Luz",
                "Dog",
                "2005-05-24T00:00:00.000Z",
                "My dog is great"
            ),
            Definition(
                "Your best friend",
                100,
                98,
                "yoloman",
                "Dog",
                "2005-05-24T00:00:00.000Z",
                "The dog ran through the dorr to meet his owner that he last saw 2 years ago"
            )
        )
        val mainViewModel = MainViewModel(urbanDictionaryRepository)

        mainViewModel.viewModelScope.launch() {
            `when`(urbanDictionaryRepository.getResultFromNetwork(term)).thenReturn(definitionList)
        }
        Thread.sleep(2000)

        mainViewModel.getAllDefinitions(term)

        assert(mainViewModel.liveSearchResult != null)

    }


}
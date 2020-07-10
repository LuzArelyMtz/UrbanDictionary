package com.nike.urbandictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nike.urbandictionary.MyApplication
import com.nike.urbandictionary.R
import com.nike.urbandictionary.databinding.ActivityMainBinding
import com.nike.urbandictionary.view.adapters.DefinitionAdapter
import com.nike.urbandictionary.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import net.aptivist.daggerbase.dagger.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModelFactory: ViewModelFactory
    private val rvAdapter by lazy { DefinitionAdapter() }

    private val mainViewModel by lazy {
        ViewModelProvider(this, this.mainViewModelFactory).get(
            MainViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

        mainViewModel.liveSearchResult?.observe(this, Observer { definitionList ->
            if (definitionList != null) {
                rvAdapter.submitList(definitionList)
            }
        })

        initListAdapter()

        toolBarItemListener()
    }

    private fun initListAdapter() {
        rvDefinition.layoutManager = LinearLayoutManager(this)
        rvDefinition.adapter = rvAdapter
    }

    private fun toolBarItemListener() {
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_search -> {
                    val searchView: SearchView =
                        MenuItemCompat.getActionView(menuItem) as SearchView

                    searchView.setOnQueryTextListener(object :
                        SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String): Boolean {
                            mainViewModel.getAllDefinitions(query)
                            return false
                        }

                        override fun onQueryTextChange(newText: String) = true

                    })

                    true
                }
                    R.id.menu_sort_thumbsup -> {
                    mainViewModel.definitionListSortedByDescThumbsUp()
                    true
                }
                R.id.menu_sort_thumbsdown -> {
                    mainViewModel.definitionListSortedByDescThumbsDown()

                    true
                }
                else -> false
            }
        }
    }


}



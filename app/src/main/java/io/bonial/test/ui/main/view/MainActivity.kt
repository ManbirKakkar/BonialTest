package io.bonial.test.ui.main.view

import android.content.res.Configuration
import android.graphics.Rect
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import io.bonial.test.R
import io.bonial.test.data.api.ApiHelper
import io.bonial.test.data.api.RetrofitBuilder
import io.bonial.test.data.model.Contents
import io.bonial.test.databinding.ActivityMainBinding
import io.bonial.test.extensions.showToast
import io.bonial.test.extensions.toggleVisibleGone
import io.bonial.test.ui.base.ViewModelFactory
import io.bonial.test.ui.main.adapter.BrochureAdapter
import io.bonial.test.ui.main.viewmodel.BrochureViewModel
import io.bonial.test.utils.ContentType
import io.bonial.test.utils.Status


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BrochureViewModel
    private lateinit var adapter: BrochureAdapter
    private lateinit var binding: ActivityMainBinding
    private var layoutManager : GridLayoutManager ?=null

    companion object{
        const val  Column_Count_1 = 1
        const val  Column_Count_2 = 2
        const val  Column_Count_3 = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUi()
        setupObservers()
        setupActionBar()

    }

    private fun setupActionBar() {
        supportActionBar?.let {
            it.setDisplayUseLogoEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.filter -> showToast("Clicked")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders
            .of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(BrochureViewModel::class.java)
    }

    private fun setupUi() {
        adapter = BrochureAdapter(context = this, contentsData = arrayListOf())
        binding.recyclerView.adapter = adapter
        setupRecyclerViewLayout()
    }

    private fun setupRecyclerViewLayout() {
        binding.recyclerView.addItemDecoration(SpacesItemDecoration())
        layoutManager = GridLayoutManager(this, Column_Count_2)
        binding.recyclerView.layoutManager =layoutManager

        /*  layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
       override fun getSpanSize(position: Int): Int {
           return when (adapter.getItemContentType(position)) {
               ContentType.BROCHURE -> 2
               ContentType.BROCHURE_PREMIUM -> 1
               else -> 2
           }
       }
   }
*/

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        checkSpanCountOnOrientationChange()
    }

    private fun checkSpanCountOnOrientationChange(){
        layoutManager?.let {
            it.spanCount = when(this.resources.configuration.orientation){
                Configuration.ORIENTATION_PORTRAIT -> Column_Count_2
                Configuration.ORIENTATION_LANDSCAPE -> Column_Count_3
                else -> Column_Count_2
            }
        }
    }

    private fun setupObservers() {
        viewModel.getBrochure().observe(this, Observer {
            it?.let { resource ->
               when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.toggleVisibleGone(true)
                        binding.progressBar.toggleVisibleGone(false)
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        binding.recyclerView.toggleVisibleGone(true)
                        binding.progressBar.toggleVisibleGone(false)
                        it.message?.let { msg -> showToast(msg) }
                    }
                    Status.LOADING -> {
                        binding.recyclerView.toggleVisibleGone(false)
                        binding.progressBar.toggleVisibleGone(true)
                    }
                }
            }
        })
    }

    private fun retrieveList(contents: List<Contents>) {
        val listData =
            contents.filter { (it.contentType == ContentType.BROCHURE) || (it.contentType == ContentType.BROCHURE_PREMIUM) }
        adapter
            .apply {
                addUsers(listData)
                notifyDataSetChanged()
            }
    }


    class SpacesItemDecoration : ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = 40
            outRect.left = when {
                parent.getChildLayoutPosition(view) % 2 == 0 -> 20
                else -> 20
            }
        }
    }
}

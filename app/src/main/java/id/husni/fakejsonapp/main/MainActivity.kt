package id.husni.fakejsonapp.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import id.husni.fakejsonapp.ui.UserAdapter
import id.husni.fakejsonapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainViewModel: MainViewModel by viewModel()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainProgressBar.visibility = View.VISIBLE
        val rvAdapter = UserAdapter()

        with(binding.mainRv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = rvAdapter
        }
        GlobalScope.launch(Dispatchers.Main){
            mainViewModel.getUser().asLiveData().observe(this@MainActivity, { data ->
                if (data != null) {
                    rvAdapter.setUserData(data)
                    binding.mainProgressBar.visibility = View.GONE
                }
            })
        }

    }


}
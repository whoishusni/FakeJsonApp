package id.husni.fakejsonapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import id.husni.fakejsonapp.adapter.UserAdapter
import id.husni.fakejsonapp.databinding.ActivityMainBinding
import id.husni.fakejsonapp.viewmodel.MainViewModel
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
        mainViewModel.getUser().asLiveData().observe(this, { data ->
            if (data != null) {
                rvAdapter.setUserData(data)
                binding.mainProgressBar.visibility = View.GONE
            }
        })


    }


}
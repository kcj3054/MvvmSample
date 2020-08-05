package com.example.mvvmsample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmsample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        val viewModel : WriteViewModel by viewModels()

        binding.viewModel = viewModel
        //binding에 viewModel 에 layout에 variable의  viewmodel 적어준것

        binding.lifecycleOwner = this
        //메모리 누수 방지를 자동으로, owner가 죽으면 같이 lifecycle죽게d

        viewModel.todo.observe(this, Observer<Todo> {
            todo ->
            Log.d("Todo Data", todo.content!!)
            //observe를 통해서 todo를 감시하겠다
            //postval
        })

        viewModel.error.observe(this, Observer<String?> {
            error -> Toast.makeText(this@MainActivity, error!!, Toast.LENGTH_LONG).show()
        })

        submitButton.setOnClickListener {
            viewModel.save(contentEditText.text.toString())
        }
    }
}

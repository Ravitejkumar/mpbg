package com.rtk.mpbg.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rtk.mpbg.R
import com.rtk.mpbg.core.extension.inTransaction
import com.rtk.mpbg.databinding.ActivityLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
abstract class BaseActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setSupportActionBar(binding.toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(
                R.id.fragmentContainer,
                fragment()
            )
        }

    abstract fun fragment(): BaseFragment
}
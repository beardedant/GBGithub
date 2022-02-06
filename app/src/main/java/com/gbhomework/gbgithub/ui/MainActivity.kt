package com.gbhomework.gbgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbhomework.gbgithub.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, LoginListFragment.newInstance())
            .commit()
    }
}
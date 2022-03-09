package com.gbhomework.gbgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.ui.login.LoginListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, LoginListFragment.newInstance())
                .commit()
        }
    }
}
package com.gbhomework.gbgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbhomework.gbgithub.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainFragment.newInstance())
            .commit()
    }
}
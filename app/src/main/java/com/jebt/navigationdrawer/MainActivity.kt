package com.jebt.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jebt.navigationdrawer.databinding.ActivityMainBinding
import com.jebt.navigationdrawer.views.fragments.app.SettingsFragment
import com.jebt.navigationdrawer.views.fragments.modules.HomeFragment
import com.jebt.navigationdrawer.views.fragments.modules.ProductsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_drawer, R.string.close_drawer)
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }


                R.id.nav_products ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, ProductsFragment())
                        commit()
                    }
                }


                R.id.nav_settings ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, SettingsFragment())
                        commit()
                    }
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toogle.onOptionsItemSelected(item)) true


        return super.onOptionsItemSelected(item)
    }
}
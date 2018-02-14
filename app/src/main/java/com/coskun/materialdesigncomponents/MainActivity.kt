package com.coskun.materialdesigncomponents

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

fun MainActivity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigation_view.setNavigationItemSelectedListener {
           onNavigationItemSelected(it.itemId)
        }

        switchCompat.setOnCheckedChangeListener { _, isChecked ->
            toast(isChecked.toString())
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            toast(isChecked.toString())
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId){
                R.id.radio_button_1 -> toast("Radio Button 1")
                R.id.radio_button_2 -> toast("Radio Button 2")
                R.id.radio_button_3 -> toast("Radio Button 3")
            }
        }

    }

    private fun onNavigationItemSelected(id: Int) : Boolean{

        when (id){
            R.id.menu_item_1 -> toast("menu item 1")
            R.id.menu_item_2 -> toast("menu item 2")
            R.id.menu_item_3 -> toast("menu item 3")
            R.id.menu_item_4 -> toast("menu item 4")
            R.id.sub_menu_item_1 -> toast("sub menu item 1")
            R.id.sub_menu_item_2 -> toast("sub menu item 2")
            R.id.sub_menu_item_3 -> toast("sub menu item 3")
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}

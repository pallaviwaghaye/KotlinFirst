package com.webakruti.kotlinfirst

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.webakruti.kotlinfirst.Fragment.HomeFragment

class NavigationActivity : AppCompatActivity() {

    private var toolbar : Toolbar? = null
    private var drawerLayout : DrawerLayout? = null
    private var navigationView : NavigationView? = null
    private var fragmentManager : FragmentManager? = null
    private var toolBarTextView : TextView? = null

    private var imageViewNavUser : ImageView? = null
    private var textViewFName : TextView? = null
    private var textViewLName : TextView? = null
    private var textViewMobileNo : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)


        toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        toolBarTextView = findViewById<TextView>(R.id.toolbarUserDetailsHomeTitle) as TextView

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById<NavigationView>(R.id.navigationView) as NavigationView

        navigationView!!.setItemIconTintList(null)

        val headerLayout = navigationView!!.getHeaderView(0)

        textViewFName = headerLayout.findViewById<TextView>(R.id.textViewFName) as TextView
        textViewLName = headerLayout.findViewById<TextView>(R.id.textViewLName) as TextView
        textViewMobileNo = headerLayout.findViewById<TextView>(R.id.textViewMobileNo) as TextView
        imageViewNavUser = headerLayout.findViewById<ImageView>(R.id.imageViewNavUser) as ImageView

        val menu = navigationView!!.getMenu()


        val actionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView!!)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        }

        drawerLayout!!.setDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        fragmentManager = supportFragmentManager
        fragmentManager!!.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()



        navigationView!!.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    toolBarTextView!!.setText("Home")
                    fragmentManager!!.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()

                }
                R.id.navigationMyProfile -> {
                    //mTextMessage.setText("Profile");
                    val intent = Intent(this@NavigationActivity, SecondActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.navSupport -> {
                    toolBarTextView!!.setText("Support")
                    fragmentManager!!.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()
                }
                R.id.navigationMyEnquiry -> {
                    toolBarTextView!!.setText("My Enquiry")
                    fragmentManager!!.beginTransaction().replace(R.id.home_container, HomeFragment()).commit()
                }
                R.id.navigationLogout -> {
                    val alertDialog = AlertDialog.Builder(this@NavigationActivity)
                    alertDialog.setTitle("Logout")
                    alertDialog.setMessage("Are you sure to logout?")
                    alertDialog.setPositiveButton("YES") { dialog, which ->

                        val intent = Intent(this@NavigationActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }

                    alertDialog.setNegativeButton("NO") { dialog, which -> dialog.cancel() }
                    alertDialog.show()

                }
            }
            drawerLayout!!.closeDrawers();
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (this.drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }




}

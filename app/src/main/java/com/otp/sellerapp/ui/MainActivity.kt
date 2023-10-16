package com.otp.sellerapp.ui


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.otp.sellerapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var mainToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.fragment)
        mainToolbar=findViewById(R.id.main_toolbar)
        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        // Cấu hình ActionBar (nếu bạn sử dụng)
    }
    override fun onSupportNavigateUp(): Boolean {
        // Handle the Up button press in the action bar
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search->{
                Toast.makeText(applicationContext,"search",Toast.LENGTH_LONG);
                return true
            }
            R.id.shopping->{
                Toast.makeText(applicationContext,"search",Toast.LENGTH_LONG);
                return true
            }

        }
        return super.onContextItemSelected(item)
    }
}
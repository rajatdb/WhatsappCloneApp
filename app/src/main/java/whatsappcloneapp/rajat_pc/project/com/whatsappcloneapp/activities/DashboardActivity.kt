package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.adapters.SectionPagerAdapter

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var sectionAdapter: SectionPagerAdapter? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar!!.title = "Dashboard"

        sectionAdapter = SectionPagerAdapter(supportFragmentManager)
        dashViewPagerId.adapter = sectionAdapter
        mainTabs.setupWithViewPager(dashViewPagerId)
        mainTabs.setTabTextColors(Color.WHITE, Color.GREEN)

        /*if(intent.extras != null){
            var userName = intent.extras.get("name")
            Toast.makeText(this, userName.toString(), Toast.LENGTH_LONG)
                    .show()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)

        if(item != null){
            if(item.itemId == R.id.logoutId){
                // Logout the user
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            if(item.itemId == R.id.settingsId){
                //take user to setting activity
                startActivity(Intent(this, SettingActivity::class.java))
            }
        }

        return true
    }
}



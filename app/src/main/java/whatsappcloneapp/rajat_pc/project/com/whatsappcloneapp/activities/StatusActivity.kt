package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_status.*
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R

class StatusActivity : AppCompatActivity() {
    var mDatabase: DatabaseReference? = null
    var mCurrentUsers: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        supportActionBar!!.title = "Status"

        if(intent.extras != null){
            var oldStatus = intent.extras.get("status")
            statusUpdateEt.setText(oldStatus.toString())
        }
        if(intent.extras.equals(null)){
            statusUpdateEt.setText("Enter Your New Status")
        }

        statusUpdateBtn.setOnClickListener{
            mCurrentUsers = FirebaseAuth.getInstance().currentUser
            var userId = mCurrentUsers!!.uid

            mDatabase = FirebaseDatabase.getInstance().reference
                    .child("Users")
                    .child(userId)

            var status = statusUpdateEt.text.toString().trim()

            mDatabase!!.child("status")
                    .setValue(status).addOnCompleteListener{
                task: Task<Void> ->
                if(task.isSuccessful){
                    Toast.makeText(this, "status Updated Succesfully!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, SettingActivity::class.java))
                }else{
                    Toast.makeText(this, "Status Not Updated Succesfully!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

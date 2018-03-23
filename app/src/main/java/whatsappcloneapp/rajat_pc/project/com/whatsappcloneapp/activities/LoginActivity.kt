package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R

class LoginActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mDatabase: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        loginButtonId.setOnClickListener {

            var email = loginEmailE.text.toString().trim()
            var password = loginPasswordEt.text.toString().trim()

            if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                loginUser(email, password)
            }else{
                Toast.makeText(this, "Sorry, login failed!", Toast.LENGTH_LONG)
                        .show()
            }
        }
    }

    private fun  loginUser(email: String, password: String) {

        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    task: Task<AuthResult> ->
                    if(task.isSuccessful){

                        var userName = email.split("@")[0]
                        // rajat@gmail.com split --> [rajat], [gmail.com]

                        var dashboardIntent = Intent(this, DashboardActivity::class.java)
                        dashboardIntent.putExtra("name", userName)
                        startActivity(dashboardIntent)
                        finish()

                    }else{
                        Toast.makeText(this, "Login Failed!", Toast.LENGTH_LONG).show()
                    }
                }
    }
}

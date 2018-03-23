package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.activities.ChatActivity
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.activities.ProfileActivity
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.models.Users

class UsersAdapter(databaseQuery: DatabaseReference, var context: Context?)
    :FirebaseRecyclerAdapter<Users, UsersAdapter.ViewHolder>(
        Users::class.java,
        R.layout.users_row,
        UsersAdapter.ViewHolder::class.java,
        databaseQuery
){
    override fun populateViewHolder(viewHolder: UsersAdapter.ViewHolder?, user: Users?, position: Int) {
        var userId = getRef(position).key // the unique firebase keyid of this current user!
        viewHolder!!.bindView(user!!, context)

        viewHolder.itemView.setOnClickListener {

            //Create an AlertDialog to prompt users if they want to see profile or send message
            var options = arrayOf("Open Profile","Send Message")
            var builder = AlertDialog.Builder(context)
            builder.setTitle("Select Options")
            builder.setItems(options, DialogInterface.OnClickListener { dialogInterface, i ->
                var userName = viewHolder.usersNameTxt
                var userStat = viewHolder.userStatusTxt
                var profilePic = viewHolder.userProfilePicLink

                if(i == 0){
                    //open user profile
                    var profileIntent = Intent(context, ProfileActivity::class.java)
                    profileIntent.putExtra("userId", userId)
                    context!!.startActivity(profileIntent)

                }else{
                    //Send Message or ChatActivity
                    var chatIntent = Intent(context, ChatActivity::class.java)
                    chatIntent.putExtra("userId", userId)
                    chatIntent.putExtra("name", userName)
                    chatIntent.putExtra("status", userStat)
                    chatIntent.putExtra("profile", profilePic)
                    context!!.startActivity(chatIntent)

                }

            })
            builder.show()

        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var usersNameTxt: String? = null
        var userStatusTxt: String? = null
        var userProfilePicLink: String? = null


        fun bindView(user: Users, context: Context?){
            var userName = itemView.findViewById<TextView>(R.id.userName)
            var userStatus = itemView.findViewById<TextView>(R.id.userStatus)
            var userProfilePic = itemView.findViewById<CircleImageView>(R.id.usersProfile)

            //set the strings so we can pass in the intent
            usersNameTxt = user.display_name
            userStatusTxt = user.user_status
            userProfilePicLink = user.thumb_image

            userName.text = user.display_name
            userStatus.text = user.user_status

            Picasso.with(context)
                    .load(userProfilePicLink)
                    .placeholder(R.drawable.profile_img)
                    .into(userProfilePic)
        }
    }
}
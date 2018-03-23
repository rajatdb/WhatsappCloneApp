package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_users.*

import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.adapters.UsersAdapter


/**
 * A simple [Fragment] subclass.
 */
class UsersFragment : Fragment() {
    var mUsersDatabase: DatabaseReference? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        mUsersDatabase = FirebaseDatabase.getInstance().reference.child("Users")

        userRecyclerViewId.setHasFixedSize(true)

        userRecyclerViewId.layoutManager = linearLayoutManager
        userRecyclerViewId.adapter = UsersAdapter(mUsersDatabase!!, context)
    }

}// Required empty public constructor

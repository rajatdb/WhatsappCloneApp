package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.R


/**
 * A simple [Fragment] subclass.
 */
class ChatsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_chats, container, false)
    }

}// Required empty public constructor

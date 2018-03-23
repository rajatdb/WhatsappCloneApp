package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.fragments.ChatsFragment
import whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.fragments.UsersFragment

/**
 * Created by RAJAT-PC on 10-02-2018.
 */
class SectionPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when( position ){
            0 -> {
                return UsersFragment()
            }
            1 -> {
                return ChatsFragment()
            }
        }
        return null!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        when( position ) {
            0 -> return "USERS"
            1 -> return "CHATS"
        }
        return null!!
    }
}
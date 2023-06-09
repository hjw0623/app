package  com.example.proto01

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.proto01.databinding.ActivityMainBinding
import com.example.proto01.fragment.CameraFragment
import com.example.proto01.fragment.HomeFragment
import com.example.proto01.fragment.MapFragment
import com.google.android.material.navigation.NavigationView

private const val TAG_Home = "HomeFragment"
private const val TAG_Camera = "CameraFragment"
private const val TAG_Map = "MapFragment"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_Home, HomeFragment())

        binding.navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> setFragment(TAG_Home, HomeFragment())
                R.id.action_camera -> setFragment(TAG_Camera, CameraFragment())
                R.id.action_map -> setFragment(TAG_Map, MapFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }
        val home = manager.findFragmentByTag(TAG_Home)
        val camera = manager.findFragmentByTag(TAG_Camera)
        val map = manager.findFragmentByTag(TAG_Map)

        if (home != null){
            fragTransaction.hide(home)
        }

        if (camera != null){
            fragTransaction.hide(camera)
        }

        if (map != null) {
            fragTransaction.hide(map)
        }

        if (tag == TAG_Home) {
            if (home!=null){
                fragTransaction.show(home)
            }
        }
        else if (tag == TAG_Camera) {
            if (camera != null) {
                fragTransaction.show(camera)
            }
        }

        else if (tag == TAG_Map) {
            if (map != null){
                fragTransaction.show(map)
            }
        }

        fragTransaction.commitAllowingStateLoss()

    }
}




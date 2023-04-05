package  com.example.proto01
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.proto01.R
import com.google.android.gms.tasks.Tasks.call

class MainActivity : AppCompatActivity() {

    private val requiredPermissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settingButton()
    }

    private fun settingButton(){
        val membershipButton = findViewById<Button>(R.id.membershipButton)
        val packageName = "com.tms"

        val intent = packageManager.getLaunchIntentForPackage(packageName)
        val intentPlaystore = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
        membershipButton.setOnClickListener {
            try{
                startActivity(intent)
            } catch (e: Exception){
                startActivity(intentPlaystore)
            }

        }

    }

}
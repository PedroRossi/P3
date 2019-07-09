package br.ufpe.cin.if710.p3

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import br.ufpe.cin.if710.p3.fragments.AddMealFragment
import br.ufpe.cin.if710.p3.fragments.InsightsFragment
import br.ufpe.cin.if710.p3.fragments.MealsFragment
import br.ufpe.cin.if710.p3.utils.DB
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private var navView: BottomNavigationView? = null

    private val CAMERA_PERMISSION_REQUEST = 100
    private val TAKE_PHOTO_PERMISSION_REQUEST = 101

    private val meals = MealsFragment.newInstance()
    private val insights = InsightsFragment.newInstance()

    private var photoPath: String? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_history -> {
                this.openFragment(this.meals)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_camera -> {
                this.dispatchIfAllowedIfNotAsk()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_insights -> {
                this.openFragment(this.insights)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        navView!!.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        this.openFragment(this.meals)
        DB.getInstance(this) // instance first db
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        )
    }

    private fun dispatchIfAllowedIfNotAsk() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST);
        } else {
            dispatchTakePictureIntent()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_PERMISSION_REQUEST -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent()
                }
            }
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE)?.also { takePictureIntent ->
            takePictureIntent.resolveActivity(this.packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    photoPath = photoFile.absolutePath
                    val photoURI = FileProvider.getUriForFile(
                        this, "br.ufpe.cin.if710.p3", photoFile
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, TAKE_PHOTO_PERMISSION_REQUEST)
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_PHOTO_PERMISSION_REQUEST && resultCode == RESULT_OK) {
            this.openFragment(AddMealFragment.newInstance(photoPath!!, navView!!))
        }
    }
}

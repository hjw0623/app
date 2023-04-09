package com.example.proto01.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.proto01.R
import com.example.proto01.SearchActivity


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val membershipButton = view?.findViewById<Button>(R.id.membershipButton)
        val packageName = "com.tms"
        val packageManager = requireContext().packageManager
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        val intentPlaystore = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))

        membershipButton?.setOnClickListener {
            try{
                startActivity(intent)
            } catch (e: Exception) {
                startActivity(intentPlaystore)
            }

        }

        view.findViewById<ImageButton>(R.id.searchButton).setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }
        return view
    }


}
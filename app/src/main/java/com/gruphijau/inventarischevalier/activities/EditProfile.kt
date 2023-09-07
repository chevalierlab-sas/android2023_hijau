package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditProfilBinding

class EditProfile : BaseActivity() {
    private lateinit var binding: ActivityEditProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        binding.edtName.setText(username)
        binding.edtEmail.setText(email)

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Settings::class.java)
            startActivity(prevPage)
            finish()
        }

        binding.btnSave.setOnClickListener{
            val prevPage = Intent(this, Settings::class.java)
            startActivity(prevPage)
            finish()
        }
    }
    override fun onBackPressed() {
        val prevPage = Intent(this, Settings::class.java)
        startActivity(prevPage)
        finish()
    }
}
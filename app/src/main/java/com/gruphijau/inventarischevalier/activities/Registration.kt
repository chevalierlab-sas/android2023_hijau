package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityRegistrationBinding

class Registration : BaseActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIconBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnBuatAkun.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvIconBack.setOnClickListener{
            val prevPage = Intent(this, MainActivity::class.java)
            startActivity(prevPage)
            finish()
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, MainActivity::class.java)
        startActivity(prevPage)
        finish()
    }
}
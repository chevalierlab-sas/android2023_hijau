package com.gruphijau.inventarischevalier.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditProfilBinding

class EditProfile : BaseActivity() {
    private lateinit var binding: ActivityEditProfilBinding
    private var alert: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            alertCreate()
        }

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
    }

    fun alertCreate() {
        alert = AlertDialog.Builder(this)
            .setTitle("Pemberitahuan")
            .setMessage("Anda yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
            }
            .setNegativeButton("Tidak", null)

            .show()
    }
}
package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditUserDataBinding

class EditUserData : BaseActivity() {
    private lateinit var binding: ActivityEditUserDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        if (intent != null) {
            val name = intent.getStringExtra("name") ?: ""
            val email = intent.getStringExtra("email") ?: ""
            val phoneNumber = intent.getStringExtra("phone_num") ?: ""
            val address = intent.getStringExtra("address") ?: ""
            val status = intent.getStringExtra("status") ?: ""

            binding.edtNama.setText(name)
            binding.edtEmail.setText(email)
            binding.edtPhoneNum.setText(phoneNumber)
            binding.edtAddress.setText(address)
            binding.edtStatus.setText(status)

            val newName = binding.edtNama.text
            val newEmail = binding.edtEmail.text
            val newPhoneNum = binding.edtPhoneNum.text
            val newAddress = binding.edtAddress.text
            val newStatus = binding.edtStatus.text

            binding.btnSave.setOnClickListener {
                startActivity(Intent(this, DataPengguna::class.java))
                intent.putExtra("name", newName)
                intent.putExtra("email", newEmail)
                intent.putExtra("phone_num", newPhoneNum)
                intent.putExtra("address", newAddress)
                intent.putExtra("status", newStatus)
                finish()
            }
        }
        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, DataPengguna::class.java)
            startActivity(prevPage)
            finish()
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, Dashboard::class.java)
        startActivity(prevPage)
        finish()
    }
}

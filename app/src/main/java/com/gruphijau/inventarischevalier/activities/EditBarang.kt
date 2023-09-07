package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.databinding.ActivityEditBarangBinding

class EditBarang : BaseActivity() {
    private lateinit var binding: ActivityEditBarangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, ItemList::class.java)
            startActivity(prevPage)
            finish()
        }

                binding.btnSave.setOnClickListener {
                    val intent = Intent(this, ItemList::class.java)
                    startActivity(intent)
                    finish()
                }
            }


    override fun onBackPressed() {
        val prevPage = Intent(this, ItemList::class.java)
        startActivity(prevPage)
        finish()
    }
}
package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.databinding.ActivityTambahBarangBinding

class TambahBarang : BaseActivity() {
    private lateinit var binding: ActivityTambahBarangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val prevPage = Intent(this, ItemList::class.java)
            startActivity(prevPage)
            finish()
        }

        binding.btnSave.setOnClickListener {
            val namaBarang = binding.edtNamaBarang.text.toString()
            val kondisiBarang = binding.edtKondisiBarang.text.toString()
            val jumlahBarang = binding.edtJumlahBarang.text.toString()
            val deskripsiBarang = binding.edtDeskripsiBarang.text.toString()

            // Isi data barang
            if (namaBarang.isEmpty()) {
                binding.edtNamaBarang.error = "Nama barang harus diisi!"
            } else if (kondisiBarang.isEmpty()) {
                binding.edtKondisiBarang.error = "Kondisi barang harus diisi!"
            } else if (jumlahBarang.isEmpty()) {
            binding.edtJumlahBarang.error = "Jumlah barang harus diisi!"
            } else {
                if (deskripsiBarang.isEmpty()) {
                    binding.edtDeskripsiBarang.error = "Deskripsi barang harus diisi!"
                } else {
                    val intent = Intent(this, ItemDetails::class.java)
                    intent.putExtra("name", namaBarang)
                    intent.putExtra("image", R.drawable.waduh)
                    intent.putExtra("status", kondisiBarang)
                    intent.putExtra("quantity2", jumlahBarang)
                    intent.putExtra("description", deskripsiBarang)
                    startActivity(intent)
                    finish()
                }
            }
    }
}}
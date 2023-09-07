package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.databinding.ActivityItemDetailsBinding

class ItemDetails : BaseActivity() {
//    var itemQuantity = 0
//    var quantityAvailable = 0
    private lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemName = intent.getStringExtra("name") ?: ""
        val itemImage = intent.getIntExtra("image", 0)
        val itemQuality = intent.getStringExtra("status") ?: ""
        val itemQuantity = intent.getIntExtra("quantity", 0)
        val itemQuantity2 = intent.getStringExtra("quantity2")
        val itemDescription = intent.getStringExtra("description")
        binding.imageDetail.setImageResource(itemImage)
        binding.titleDetail.text = itemName
        binding.quantityAndStatus.text = "$itemQuantity Unit | $itemQuality"

        if (itemDescription != null) {
        binding.tvDeskripsiBarang.text = itemDescription
        }
        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, ItemList::class.java)
            startActivity(prevPage)
            finish()
        }
        binding.editBtn.setOnClickListener {
           val nextPage = Intent(this, EditBarang::class.java)
            startActivity(nextPage)
        }
    }
    override fun onBackPressed() {
        val prevPage = Intent(this, ItemList::class.java)
        startActivity(prevPage)
        finish()
    }
}


package com.gruphijau.inventarischevalier.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.adapters.UserDataAdapter
import com.gruphijau.inventarischevalier.data.UserData
import com.gruphijau.inventarischevalier.databinding.ActivityUserDataBinding

class DataPengguna : BaseActivity() {
    private lateinit var adapter: UserDataAdapter
    private lateinit var binding: ActivityUserDataBinding
    private lateinit var list: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvUserdata.setHasFixedSize(true)

        list = ArrayList()

        val name = intent.getStringExtra("name") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val phoneNumber = intent.getStringExtra("phone_num") ?: ""
        val address = intent.getStringExtra("address") ?: ""
        val status = intent.getStringExtra("status") ?: ""

        if (name != "") {
            list.add(UserData(R.drawable.icon_user, name, email, phoneNumber, address, status))
        }

        list.add(
            UserData(
                R.drawable.user_image_1,
                "Yusuf",
                "yusuf@gmail.com",
                "081223445566",
                "Bandung, Jawa Barat",
                "Pengguna"
            )
        )
        list.add(
            UserData(
                R.drawable.user_image_2,
                "Milla",
                "mmilan@gmail.com",
                "081222543678",
                "Jakarta, DKI Jakarta",
                "Pengguna"
            )
        )

        adapter = UserDataAdapter(list, this)
        binding.rvUserdata.adapter = adapter
        binding.rvUserdata.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            val nextPage = Intent(this, EditUserData::class.java)
            startActivity(nextPage)
            finish()
        }
        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
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
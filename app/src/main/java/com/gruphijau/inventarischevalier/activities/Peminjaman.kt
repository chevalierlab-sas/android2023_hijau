package com.gruphijau.inventarischevalier.activities
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.adapters.PeminjamAdapter
import com.gruphijau.inventarischevalier.adapters.PengembalianAdapter
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.data.HistoryPinjamData
import com.gruphijau.inventarischevalier.databinding.ActivityPeminjamanBinding

class Peminjaman : BaseActivity() {
    private lateinit var binding: ActivityPeminjamanBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPeminjamanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }

        binding.btnDisapprove.setOnClickListener {
            startActivity(Intent(this, PeminjamanDisapprove::class.java))
            finish()
        }

        binding.btnApprove.setOnClickListener {
            startActivity(Intent(this, PeminjamanApprove::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, Dashboard::class.java)
        startActivity(prevPage)
        finish()
    }
}

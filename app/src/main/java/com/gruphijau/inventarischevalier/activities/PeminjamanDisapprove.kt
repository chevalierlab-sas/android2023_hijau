package com.gruphijau.inventarischevalier.activities
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruphijau.inventarischevalier.adapters.PeminjamAdapter
import com.gruphijau.inventarischevalier.adapters.PengembalianAdapter
import com.gruphijau.inventarischevalier.R
import com.gruphijau.inventarischevalier.data.HistoryPinjamData
import com.gruphijau.inventarischevalier.databinding.ActivityPeminjamanBinding
import com.gruphijau.inventarischevalier.databinding.ActivityPeminjamanDisapproveBinding

class PeminjamanDisapprove : BaseActivity() {
    private lateinit var binding: ActivityPeminjamanDisapproveBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPeminjamanDisapproveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            val prevPage = Intent(this, Dashboard::class.java)
            startActivity(prevPage)
            finish()
        }
        binding.btnSend.setOnClickListener{
            Handler().postDelayed({
                startActivity(Intent(this, ItemList::class.java)) // Mulai aktivitas setelah penundaan
                finish() // Sebagai opsional, jika Anda ingin menutup aktivitas saat ini
            }, 500)
        }
    }

    override fun onBackPressed() {
        val prevPage = Intent(this, Dashboard::class.java)
        startActivity(prevPage)
        finish()
    }
}

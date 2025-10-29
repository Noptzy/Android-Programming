package com.learn.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learn.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomListener()
    }

    private fun setupBottomListener(){
        binding.btnTampilkanPesan.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val nim = binding.etNim.text.toString()
            val prodi = binding.etProdi.text.toString()

            if(nama.isBlank() || nim.isBlank() || prodi.isBlank()){
                Toast.makeText(this, "Mohon isi semua field", Toast.LENGTH_SHORT).show()
            }else{
                val pesan = "Nama: $nama\nNIM: $nim\nProgram Studi: $prodi"

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Informasi Pribadi")
                builder.setMessage(pesan)
                builder.setPositiveButton("OK", null)

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }
}
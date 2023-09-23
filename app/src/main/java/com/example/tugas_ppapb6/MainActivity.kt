package com.example.tugas_ppapb6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugas_ppapb6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val kategori = arrayOf(
        "Luxury",
        "Executive",
        "Bussiness",
        "Economy"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            val kategoriAdapter = ArrayAdapter(this@MainActivity,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, kategori)

            kategoriAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinner.adapter = kategoriAdapter
        }

        val button = binding.btnPesan

        button.setOnClickListener {
            //Tanggal DatePicker
            val hari = binding.datePick.dayOfMonth
            val bulan = binding.datePick.month
            val tahun = binding.datePick.year

            //Jam TimePicker
            val jam = binding.timePick.hour
            val menit = binding.timePick.minute

            //Format Tanggal dan Jam
            val formatTanggal = "$hari/${bulan+1}/$tahun"
            val formatWaktu =  String.format("%02d:%02d", jam, menit)
            val pesan = "Tiket $formatTanggal pada $formatWaktu berhasil dipesan. Terima kasih"

            Toast.makeText(this@MainActivity, pesan, Toast.LENGTH_LONG).show()
        }
    }
}
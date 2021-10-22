package com.example.uts.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts.Model.ResponseMatkulItem
import com.example.uts.R
import com.example.uts.adapter.MatkulAdapter
import com.example.uts.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPetaniActivity : AppCompatActivity() {
    lateinit var edid : EditText
    lateinit var edkode : EditText
    lateinit var ednama: EditText
    lateinit var edhari : EditText
    lateinit var edsesi : EditText
    lateinit var edsks : EditText
    lateinit var ednim : EditText
    lateinit var btnsub : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_petani)
        edid = findViewById(R.id.tbid)
        edkode = findViewById(R.id.tbkode)
        ednama = findViewById(R.id.tbnama)
        edhari = findViewById(R.id.tbhari)
        edsesi = findViewById(R.id.tbsesi)
        edsks = findViewById(R.id.tbsks)
        ednim = findViewById(R.id.tbnim)
        btnsub = findViewById(R.id.btnadd)

        btnsub.setOnClickListener(View.OnClickListener { view ->
            var mk = ResponseMatkulItem()
            mk.id = null
            mk.kode = edkode.text.toString()
            mk.nama = ednama.text.toString()
            mk.hari = edhari.text.toString()
            mk.sesi = edsesi.text.toString()
            mk.sks = edsks.text.toString()
            mk.nim = edid.text.toString()

            NetworkConfig().getService()
                .addMatkul(mk)
                .enqueue(object : Callback<List<ResponseMatkulItem>> {
                    override fun onFailure(call: Call<List<ResponseMatkulItem>>, t: Throwable) {
                        Toast.makeText(this@AddPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                        call: Call<List<ResponseMatkulItem>>,
                        response: Response<List<ResponseMatkulItem>>
                    ) {
                        rvProg.apply{
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = MatkulAdapter(response.body())
                        }
                    }
                })

        })

    }
}
package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.Model.ResponseMatkulItem
import com.example.uts.network.NetworkConfig
import com.example.uts.adapter.MatkulAdapter
import com.example.uts.crud.AddPetaniActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
lateinit var rvProg : RecyclerView
lateinit var tabadd : FloatingActionButton

    override fun onRestart() {
        super.onRestart()

        rvProg = findViewById(R.id.rv_progmob)
        tabadd = findViewById(R.id.tabadd)

        NetworkConfig().getService()
            .getMatkul()
            .enqueue(object : Callback<List<ResponseMatkulItem>> {
                override fun onFailure(call: Call<List<ResponseMatkulItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
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
        tabadd.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@MainActivity, AddPetaniActivity::class.java)
            startActivity(intent)
        })

    }

}
package com.example.uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.Model.ResponseMatkulItem
import com.example.uts.R

class MatkulAdapter(val matkul: List<ResponseMatkulItem>?):
        RecyclerView.Adapter<MatkulAdapter.UsersHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MatkulAdapter.UsersHolder {
            return UsersHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false))
        }
        override fun onBindViewHolder(holder: MatkulAdapter.UsersHolder,position: Int) {
            holder.bindUsers(matkul?.get(position))
        }
        override fun getItemCount(): Int {
            return matkul?.size ?: 0
        }
        class UsersHolder(view: View) : RecyclerView.ViewHolder(view) {
            lateinit var txtkode: TextView
            lateinit var txtnama: TextView
            lateinit var txthari: TextView
            lateinit var txtsesi: TextView
            fun bindUsers(matkul: ResponseMatkulItem?) {
                itemView.apply {
                    txtkode = findViewById(R.id.kode)
                    txtnama = findViewById(R.id.nama_matkul)
                    txthari = findViewById(R.id.hari)
                    txtsesi = findViewById(R.id.sesi)
                    txtkode.text = matkul?.kode
                    txtnama.text = matkul?.nama
                    txthari.text = matkul?.hari
                    txtsesi.text = matkul?.sesi
                }
            }
        }
    }

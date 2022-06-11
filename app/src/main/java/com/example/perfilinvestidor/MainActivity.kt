package com.example.perfilinvestidor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        btnIniciar.setOnClickListener {
            val txtNome = findViewById<TextView>(R.id.txtNome)
            if (txtNome.length().equals(0)){
                Toast.makeText(this,"Informe seu nome antes de iniciar o questionário.",Toast.LENGTH_LONG).show()
            }else{
                val perguntaIntent = Intent(this, PerguntasActivity::class.java)
                perguntaIntent.putExtra("nome", txtNome.toString())
                startActivity(perguntaIntent)
            }
        }
    }
}
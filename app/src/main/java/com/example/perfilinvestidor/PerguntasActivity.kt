package com.example.perfilinvestidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.perfilinvestidor.dados.perguntas
import com.example.perfilinvestidor.modelos.Pergunta
import kotlin.properties.Delegates

class PerguntasActivity : AppCompatActivity() {

    private lateinit var perguntasActivity: PerguntasFragment
    private lateinit var pergunta: Pergunta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        perguntasActivity = PerguntasFragment()

        setFragment(perguntasActivity, 0 )
//        for (item in 0..1) {
//            var indice = item
//        }
    }
    private fun setFragment(fragment: PerguntasFragment, indice: Int){
        val mBundle = Bundle()
        val mFragmentTransaction = supportFragmentManager.beginTransaction()
        val mFragment = PerguntasFragment()

        mBundle.putInt("indice",indice)
        mFragment.arguments = mBundle

        mFragmentTransaction.add(R.id.fragmentContainerView, mFragment).commit()

    }
}
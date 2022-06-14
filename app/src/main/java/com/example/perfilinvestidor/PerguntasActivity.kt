package com.example.perfilinvestidor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.perfilinvestidor.modelos.Pergunta

class PerguntasActivity : AppCompatActivity(R.layout.activity_perguntas) {

    private lateinit var perguntasActivity: PerguntasFragment
    private lateinit var pergunta: Pergunta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up the action bar for use with the NavController
        setupActionBarWithNavController(navController)


//        perguntasActivity = PerguntasFragment()
//        setFragment(perguntasActivity, 0 )
    }
//    private fun setFragment(fragment: PerguntasFragment, indice: Int){
//        val mBundle = Bundle()
//        val mFragmentTransaction = supportFragmentManager.beginTransaction()
//        val mFragment = PerguntasFragment()
//
//        mBundle.putInt("indice",indice)
//        mFragment.arguments = mBundle
//
//        mFragmentTransaction.add(R.id.fragmentContainerView, mFragment).commit()
//
//    }
}
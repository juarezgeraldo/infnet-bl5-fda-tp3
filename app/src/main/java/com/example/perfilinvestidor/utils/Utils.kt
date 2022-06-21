package com.example.perfilinvestidor.utils

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.perfilinvestidor.R
import com.example.perfilinvestidor.dados.perguntas


class Utils {

    private lateinit var textView_Pergunta: TextView
    private lateinit var radioButton: RadioGroup
    private lateinit var rdbOpcao1: RadioButton
    private lateinit var rdbOpcao2: RadioButton
    private lateinit var rdbOpcao3: RadioButton
    private lateinit var rdbOpcao4: RadioButton
    private lateinit var rdbOpcao5: RadioButton

    fun carregaPergunta(view: View, indice: Int) {
        textView_Pergunta = view.findViewById(R.id.textView_Pergunta)
        radioButton = view.findViewById(R.id.radioGroup)
        rdbOpcao1 = view.findViewById(R.id.rdbOpcao1)
        rdbOpcao2 = view.findViewById(R.id.rdbOpcao2)
        rdbOpcao3 = view.findViewById(R.id.rdbOpcao3)
        rdbOpcao4 = view.findViewById(R.id.rdbOpcao4)
        rdbOpcao5 = view.findViewById(R.id.rdbOpcao5)

        val opcoesView = listOf(
            rdbOpcao1,
            rdbOpcao2,
            rdbOpcao3,
            rdbOpcao4,
            rdbOpcao5
        )

        for (i in 0..4){
            opcoesView[i].isChecked = false
            opcoesView[i].visibility = View.INVISIBLE
        }
        
        textView_Pergunta.text = perguntas[indice].pergunta.toString()

        for (i in 0..perguntas[indice].opcao.size - 1) {
            opcoesView[i].text = perguntas[indice].opcao[i].opcao.toString()
            opcoesView[i].visibility = View.VISIBLE
        }
    }
    fun getQtdPerguntas(): Int{
        return perguntas.size
    }
}
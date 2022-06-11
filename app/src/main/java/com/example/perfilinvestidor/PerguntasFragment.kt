package com.example.perfilinvestidor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.perfilinvestidor.dados.perguntas

class PerguntasFragment : Fragment(), View.OnClickListener {
    private lateinit var textView_Pergunta: TextView
    private lateinit var radioButton: RadioGroup
    private lateinit var rdbOpcao1: RadioButton
    private lateinit var rdbOpcao2: RadioButton
    private lateinit var rdbOpcao3: RadioButton
    private lateinit var rdbOpcao4: RadioButton
    private lateinit var rdbOpcao5: RadioButton
    private lateinit var btnProxima: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            // Inflate the layout for this fragment
            val view: View = inflater.inflate(R.layout.fragment_perguntas, container, false)

        val bundle = arguments
        val indice = bundle?.getInt("indice")

        if (indice != null) {
            textView_Pergunta = view.findViewById(R.id.textView_Pergunta) as TextView
            radioButton = view.findViewById(R.id.radioGroup)
            rdbOpcao1 = view.findViewById(R.id.rdbOpcao1)
            rdbOpcao2 = view.findViewById(R.id.rdbOpcao2)
            rdbOpcao3 = view.findViewById(R.id.rdbOpcao3)
            rdbOpcao4 = view.findViewById(R.id.rdbOpcao4)
            rdbOpcao5 = view.findViewById(R.id.rdbOpcao5)
            btnProxima = view.findViewById(R.id.btnProxima)

            rdbOpcao1.visibility = View.VISIBLE
            rdbOpcao2.visibility = View.VISIBLE
            rdbOpcao3.visibility = View.VISIBLE
            rdbOpcao4.visibility = View.VISIBLE
            rdbOpcao5.visibility = View.INVISIBLE

            val opcoesView = listOf(rdbOpcao1,
                rdbOpcao2,
                rdbOpcao3,
                rdbOpcao4,
                rdbOpcao5)

            textView_Pergunta.text = perguntas[indice].pergunta.toString()

            for (i in 0..perguntas[indice].opcao.size - 1){
                opcoesView[i].text =  perguntas[indice].opcao[i].opcao.toString()
            }
            btnProxima.setOnClickListener {
                if (!radioButton.isSelected) {
                    Toast.makeText(
                        context,
                        "Selecione uma das opções antes de prosseguir.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
        return view
    }

    override fun onClick(p0: View?) {

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

}
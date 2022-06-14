package com.example.perfilinvestidor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.perfilinvestidor.dados.perguntas
import com.example.perfilinvestidor.databinding.FragmentPerguntasBinding

class PerguntasFragment : Fragment() {
    private var binding: FragmentPerguntasBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()


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
    ): View {
        val fragmentBinding = FragmentPerguntasBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

//            val view: View = inflater.inflate(R.layout.fragment_perguntas, container, false)
//
//        val bundle = arguments
//        val indice = bundle?.getInt("indice")
//
//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.perguntasFragment = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun mostraPergunta(indice: Int){
        if (indice != null) {
            textView_Pergunta = view!!.findViewById(R.id.textView_Pergunta)
            radioButton = view!!.findViewById(R.id.radioGroup)
            rdbOpcao1 = view!!.findViewById(R.id.rdbOpcao1)
            rdbOpcao2 = view!!.findViewById(R.id.rdbOpcao2)
            rdbOpcao3 = view!!.findViewById(R.id.rdbOpcao3)
            rdbOpcao4 = view!!.findViewById(R.id.rdbOpcao4)
            rdbOpcao5 = view!!.findViewById(R.id.rdbOpcao5)
            btnProxima = view!!.findViewById(R.id.btnProxima)

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

    }
}
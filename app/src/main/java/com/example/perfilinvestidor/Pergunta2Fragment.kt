package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.perfilinvestidor.dados.perguntas
import com.example.perfilinvestidor.databinding.FragmentPergunta2Binding
import com.example.perfilinvestidor.utils.Utils
import kotlinx.android.synthetic.main.fragment_pergunta1.*

class Pergunta2Fragment : Fragment() {
    private var binding: FragmentPergunta2Binding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private val utils: Utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPergunta2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            pergunta2Fragment = this@Pergunta2Fragment

            utils.carregaPergunta(view,1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun goToNextScreen() {
        if (respostaSelecionada(1)!! > 0) {
            findNavController().navigate(R.id.resultadoFragment)
        }else{
            Toast.makeText(context, "Informe qual opção melhor se adequa a sua realidade.", Toast.LENGTH_LONG).show()
        }
    }

    fun respostaSelecionada(indice: Int): Int? {
        val opcaoResposta: Int? = sharedViewModel.opcaoResposta()
        if (opcaoResposta != 0) {
            if (opcaoResposta != null) {
                sharedViewModel.registraResposta(
                    indice,
                    opcaoResposta,
                    perguntas[indice].opcao[opcaoResposta - 1].pontuacao
                )
            }
        }
        return opcaoResposta
    }
}
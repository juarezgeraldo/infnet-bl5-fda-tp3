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
import com.example.perfilinvestidor.databinding.FragmentPergunta1Binding
import com.example.perfilinvestidor.utils.Utils
import kotlinx.android.synthetic.main.fragment_pergunta1.*
import kotlin.properties.Delegates

class Pergunta1Fragment : Fragment() {
    private var binding: FragmentPergunta1Binding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private val utils: Utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPergunta1Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            pergunta1Fragment = this@Pergunta1Fragment

            utils.carregaPergunta(view,0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun goToNextScreen() {
        if (respostaSelecionada(0)!! > 0) {
            findNavController().navigate(R.id.pergunta1Fragment_to_pergunta2Fragment)
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
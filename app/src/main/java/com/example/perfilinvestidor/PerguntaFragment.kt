package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.perfilinvestidor.dados.perguntas
import com.example.perfilinvestidor.databinding.FragmentPerguntaBinding
import com.example.perfilinvestidor.utils.Utils

class PerguntaFragment : Fragment() {
    private var binding: FragmentPerguntaBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private val utils: Utils = Utils()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPerguntaBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            perguntaFragment = this@PerguntaFragment

            sharedViewModel.getIndice()?.let { utils.carregaPergunta(view, it) }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    findNavController().navigateUp()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun goToNextScreen() {
        val indice = sharedViewModel.getIndice()
        if (indice?.let { respostaSelecionada(it) }!! != 0) {
            if (indice < utils.getQtdPerguntas() - 1) {
                findNavController().navigate(R.id.perguntaFragment_to_perguntaFragment)
            }else{
                findNavController().navigate(R.id.resultadoFragment)
            }
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
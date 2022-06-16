package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.perfilinvestidor.databinding.FragmentResultadoBinding
import com.example.perfilinvestidor.utils.Utils

class ResultadoFragment : Fragment() {
    private var binding: FragmentResultadoBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private val utils: Utils = Utils()

    private lateinit var textView_nome: TextView
    private lateinit var textView_pontos: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentResultadoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            resultadoFragment = this@ResultadoFragment

            textView_nome = view!!.findViewById(R.id.editTextNome)
            textView_pontos = view.findViewById(R.id.editTextTotalPontos)

            textView_nome.text = sharedViewModel.getTotalPontos().toString()
            textView_pontos.text = sharedViewModel.getNome()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
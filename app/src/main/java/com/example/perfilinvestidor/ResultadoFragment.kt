package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.perfilinvestidor.databinding.FragmentResultadoBinding
import kotlinx.android.synthetic.main.fragment_nome.*

class ResultadoFragment : Fragment() {
    private var binding: FragmentResultadoBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    private lateinit var textView_nomeInvestidor: TextView
    private lateinit var textView_perfil: TextView

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

            textView_nomeInvestidor = view!!.findViewById(R.id.txtNomeInvestidor)
            textView_perfil = view.findViewById(R.id.txtPerfil)

            txtNomeInvestidor.text = sharedViewModel.getNome().toString()
            txtPerfil.text = sharedViewModel.retornaPerfil()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
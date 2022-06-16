package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.perfilinvestidor.databinding.FragmentNomeBinding

class NomeFragment : Fragment() {
    private var binding: FragmentNomeBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    private lateinit var textView_nome: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentNomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.nomeFragment = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun registraNome(){
        textView_nome = view!!.findViewById(R.id.txtNome)
        if(textView_nome.text != null || textView_nome.text != "") {
            sharedViewModel.registraNome(textView_nome.text.toString())
            findNavController().navigate(R.id.nomeFragment_to_pergunta1Fragment)
        }else{
            Toast.makeText(context, "Informe seu nome para prosseguir na avalição de perfil.", Toast.LENGTH_LONG).show()
        }
    }
}
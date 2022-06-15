package com.example.perfilinvestidor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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

        sharedViewModel.registraNome(textView_nome.toString())
    }
}
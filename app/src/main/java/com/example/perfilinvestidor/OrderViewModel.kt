package com.example.perfilinvestidor

import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _indice = MutableLiveData<Int>()
    val indice: LiveData<Int> = _indice

    private val _opcaoResposta = MutableLiveData<Int>()
    val opcaoResposta: LiveData<Int> = _opcaoResposta

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _respostas = mutableListOf<Int>()
    val respostas: List<Int> = _respostas

    private val _respostasQuestao = mutableListOf<Int>()
    val respostasQuestao: List<Int> = _respostasQuestao

    private val _respostasPontos = mutableListOf<Int>()
    val respostasPontos: List<Int> = _respostasPontos

    private val _totalPontos = MutableLiveData<Int>()
    val totalPontos: LiveData<Int> = _totalPontos

    private val _numeroQuestao = MutableLiveData<Int>()
    val numeroQuestao: LiveData<Int> = _numeroQuestao

    init {
        limpaValores()
    }

    fun limpaValores() {
        _nome.value = ""
//        _respostas = emptyList<String>()
//        _respostasPontos.value = arrayListOf()
        _totalPontos.value = 0
        _numeroQuestao.value = 1
    }

    fun registraResposta(numeroQuestao: Int, resposta: Int, respostaPonto: Int) {
        _respostasQuestao.add(numeroQuestao)
        _respostas.add(resposta)
        _respostasPontos.add(respostaPonto)
        adicionaPontos(respostaPonto)
        incrementaIndice()
        _opcaoResposta.value = null
    }

    fun adicionaPontos(pontos: Int) {
        _totalPontos.value = pontos + 1
    }

    fun registraNome(nome: String) {
        _nome.value = nome
        setIndice(0)
    }

    fun opcaoResposta(): Int? {
        return if(_opcaoResposta.value == null) 0 else _opcaoResposta.value
    }

    fun setOpcaoResposta(opcao: Int) {
        _opcaoResposta.value = opcao
    }

    fun getTotalPontos(): Int? {
        return _totalPontos.value
    }
    fun getNome(): String? {
        return _nome.value
    }

    fun getIndice(): Int? {
        return _indice.value
    }

    fun setIndice(indiceInformado: Int) {
        _indice.value = indiceInformado
    }

    fun incrementaIndice() {
        _indice.value = _indice.value?.plus(1)
    }


}
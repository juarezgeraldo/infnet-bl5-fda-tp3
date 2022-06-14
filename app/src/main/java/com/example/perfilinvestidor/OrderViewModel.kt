package com.example.perfilinvestidor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {
    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _respostas = mutableListOf<String>()
    val respostas: List<String> = _respostas

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

    fun adicionaNumeroQuestao(numeroQuestao: Int){
        _numeroQuestao.value = numeroQuestao + 1
    }

    fun registraResposta(numeroQuestao: Int, resposta: String, respostaPonto: Int){
        _respostasQuestao.add(numeroQuestao)
        _respostas.add(resposta)
        _respostasPontos.add(respostaPonto)
        adicionaPontos(respostaPonto)
    }

    fun adicionaPontos(pontos: Int){
        _totalPontos.value = pontos + 1
    }

}
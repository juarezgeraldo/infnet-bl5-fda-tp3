package com.example.perfilinvestidor.dados

import com.example.perfilinvestidor.modelos.Opcao
import com.example.perfilinvestidor.modelos.Pergunta

val perguntas = listOf(
        Pergunta("1. Por quanto tempo você pretende deixar seu dinheiro investido?",
                arrayOf (Opcao("Menos de 6 meses", 0),
                        Opcao("Entre 6 meses e 1 ano", 2),
                        Opcao("Entre 1 ano e 3 anos", 3),
                        Opcao("Acima de 3 anos", 4))),

        Pergunta("2. Qual o objetivo desse investimento?",
                arrayOf (Opcao("Preservação do capital para não perder valor ao longo do tempo, " +
                                "assumindo baixos riscos de perdas", 0),
                        Opcao("Aumento gradual do capital ao longo do tempo, assumindo riscos " +
                                "moderados", 2),
                        Opcao("Aumento do capital acima da taxa de retorno média do mercado, mesmo " +
                                "que isso implique assumir riscos de perdas elevadas", 4),
                        Opcao("Obter no curto prazo retornos elevados e significativamente acima da taxa " +
                                "de retorno média do mercado, assumindo riscos elevados", 5)))
)

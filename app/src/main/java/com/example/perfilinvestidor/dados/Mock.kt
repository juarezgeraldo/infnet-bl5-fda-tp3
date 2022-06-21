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
        arrayOf (Opcao("Preservação do capital para não perder valor ao longo do tempo, assumindo baixos riscos de perdas", 0),
            Opcao("Aumento gradual do capital ao longo do tempo, assumindo riscos moderados", 2),
            Opcao("Aumento do capital acima da taxa de retorno média do mercado, mesmo que isso implique assumir riscos de perdas elevadas", 4),
            Opcao("Obter no curto prazo retornos elevados e significativamente acima da taxa de retorno média do mercado, assumindo riscos elevados", 5))),

    Pergunta("3. Qual das alternativas melhor classifica sua formação e experiência como mercado financeiro?",
        arrayOf (Opcao("Não possuo formação acadêmica ou conhecimento do mercado financeiro", 0),
            Opcao("Possuo formação acadêmica na área Fnanceira, mas não tenho experiência com o mercado Fnanceiro", 1),
            Opcao("Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro", 2),
            Opcao("Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro", 4))),

    Pergunta("4. Considerando seus rendimentos regulares, qual a porcentagem você pretende reservar para aplicações financeiras?",
        arrayOf (
            Opcao("No máximo 25%", 0),
            Opcao("Entre 25,01 e 50%", 2),
            Opcao("Acima de 50%", 4))),

    Pergunta("5. Caso as suas aplicações sofressem uma queda superior a 30%, o que você faria?",
        arrayOf (
            Opcao("Resgataria toda a aplicação e aplicaria na poupança", 0),
            Opcao("Manteria aplicação aguardando uma melhora do mercado", 2),
            Opcao("Aumentaria a aplicação para aproveitar as oportunidades do mercado", 4))),

    Pergunta("6. Como está distribuído o seu patrimônio?",
        arrayOf (
            Opcao("Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou imóveis", 0),
            Opcao("Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis ", 2),
            Opcao("Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa e/ou imóveis", 3),
            Opcao("Acima de 50% em renda variável", 4))),

    Pergunta("7. Em relação as aplicações e rendimentos, em qual dessas situações você se enquadra?",
        arrayOf (
            Opcao("Conto com o rendimento dessas aplicações para complementar minha renda mensal", 0),
            Opcao("Eventualmente posso resgatar parte das aplicações para fazer frente aos meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e pretendo fazer aplicações regulares", 2),
            Opcao("Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar novas aplicações", 3),
            Opcao("Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer aplicações regulares", 4))),

    Pergunta("8. Qual sua faixa de renda mensal média?",
        arrayOf (
            Opcao("Até R$ 1.000", 0),
            Opcao("De R$ 1.001 até R$ 5.000", 1),
            Opcao("De R$ 5.001 até R$ 10.000", 2),
            Opcao("Acima de R$ 10.000", 4))),

    Pergunta("9. Qual o valor aproximado do seu patrimônio?",
        arrayOf (
            Opcao("Até R$ 10.000", 0),
            Opcao("De R$ 10.001 até R$ 100.000", 1),
            Opcao("De R$ 100.001 até R$ 500.000", 2),
            Opcao("De R$ 500.001 até R$ 1.000.000", 4),
            Opcao("Acima de R$ 1.000.001", 5)))

)

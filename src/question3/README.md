# Faturamento Diário de uma Distribuidora

Este projeto, implementado em Java, calcula as seguintes informações a partir de um vetor que contém o faturamento diário de uma distribuidora ao longo de um ano:

- O menor valor de faturamento ocorrido em um dia do ano.
- O maior valor de faturamento ocorrido em um dia do ano.
- O número de dias no ano em que o valor de faturamento diário foi superior à média anual.

## Requisitos do Problema

1. **Entrada**: Um vetor de faturamento diário para todos os dias de um ano, no qual alguns dias podem não conter faturamento (dias sem movimentação como feriados e finais de semana).

2. **Saídas**:
    - O menor valor de faturamento ocorrido em um dia do ano (desconsiderando dias sem faturamento).
    - O maior valor de faturamento ocorrido em um dia do ano (desconsiderando dias sem faturamento).
    - O número de dias em que o valor de faturamento diário foi superior à média anual (desconsiderando dias sem faturamento).

3. **Regras**:
    - Dias sem faturamento (faturamento igual a zero) devem ser ignorados ao calcular a média anual e ao determinar os dias com faturamento superior à média.

## Tecnologias utilizadas
- Java 17

## Estrutura do Projeto

O código está dividido da seguinte maneira:

1. **Classe Principal (`FaturamentoDistribuidora.java`)**: Contém a lógica para processar o vetor de faturamento e calcular as estatísticas necessárias.

2. **Método `calcularEstatisticasFaturamento`**: Este método faz os seguintes cálculos:
    - Percorre o vetor de faturamento para encontrar o menor e o maior faturamento do ano, ignorando dias com faturamento zero.
    - Soma o faturamento dos dias com movimentação para calcular a média anual.
    - Conta o número de dias cujo faturamento foi superior à média anual.


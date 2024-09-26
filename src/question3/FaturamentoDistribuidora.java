public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        // Exemplo de vetor de faturamento (assumindo 365 dias, com alguns dias sem faturamento)
        double[] faturamentoDiario = {
                1200.0, 2300.0, 0.0, 3400.0, 5000.0, 0.0, 0.0, // Primeira semana (com dias sem faturamento)
        };

        // Chamando o método que faz o cálculo
        calcularEstatisticasFaturamento(faturamentoDiario);
    }

    public static void calcularEstatisticasFaturamento(double[] faturamentoDiario) {
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;

        // Iterar sobre o vetor para encontrar menor, maior e somar o faturamento
        for (double faturamento : faturamentoDiario) {
            // Ignora os dias sem faturamento (faturamento igual a 0.0)
            if (faturamento > 0) {
                if (faturamento < menorFaturamento) {
                    menorFaturamento = faturamento;
                }
                if (faturamento > maiorFaturamento) {
                    maiorFaturamento = faturamento;
                }
                somaFaturamento += faturamento;
                diasComFaturamento++;
            }
        }

        // Cálculo da média de faturamento, considerando apenas os dias com faturamento
        double mediaAnual = somaFaturamento / diasComFaturamento;

        // Conta os dias em que o faturamento foi superior à média
        int diasAcimaDaMedia = 0;
        for (double faturamento : faturamentoDiario) {
            if (faturamento > mediaAnual) {
                diasAcimaDaMedia++;
            }
        }

        // Exibi os resultados
        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento superior à média anual: " + diasAcimaDaMedia);
    }
}

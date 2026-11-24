package ui;

import model.entities.ResultadoAplicacao;
import model.entities.Talhao;
import model.enums.TipoCelula;
import model.services.EstrategiaPulverizacao;

public class ImpressoraMapa {

    private static final char SIMBOLO_PULVERIZADO = '*';
    private static final String SEPARADOR = "------------------------------------------";

    public static void imprimirMapa(Talhao talhao) {
        System.out.printf("Mapa do talhão (%d x %d células, %.2f ha)%n",
                talhao.getLinhas(), talhao.getColunas(), talhao.getAreaTotalHectares());
        for (int i = 0; i < talhao.getLinhas(); i++) {
            for (int j = 0; j < talhao.getColunas(); j++) {
                System.out.print(talhao.getCelula(i, j).getSimbolo() + " ");
            }
            System.out.println();
        }
        imprimirLegenda(talhao);
    }

    public static void imprimirMapaAplicado(Talhao talhao, EstrategiaPulverizacao estrategia) {
        System.out.println(SEPARADOR);
        System.out.println("Mapa após aplicação (" + estrategia.getNome() + "):");
        for (int i = 0; i < talhao.getLinhas(); i++) {
            for (int j = 0; j < talhao.getColunas(); j++) {
                TipoCelula tipo = talhao.getCelula(i, j);
                if (estrategia.devePulverizar(tipo)) {
                    System.out.print(SIMBOLO_PULVERIZADO + " ");
                } else {
                    System.out.print(tipo.getSimbolo() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Legenda: " + SIMBOLO_PULVERIZADO + " = célula pulverizada");
    }

    public static void imprimirResultado(ResultadoAplicacao resultado) {
        System.out.println("Resultado - " + resultado.getNomeEstrategia());
        System.out.printf("  Células pulverizadas: %d%n", resultado.getCelulasPulverizadas());
        System.out.printf("  Área pulverizada:     %.2f ha%n", resultado.getAreaHectares());
        System.out.printf("  Calda usada:          %.2f L%n", resultado.getLitros());
        System.out.printf("  Custo:                R$ %.2f%n", resultado.getCusto());
        System.out.println();
    }

    public static void imprimirComparacao(ResultadoAplicacao total, ResultadoAplicacao seletiva) {
        double litrosEconomizados = total.getLitros() - seletiva.getLitros();
        double reaisEconomizados = total.getCusto() - seletiva.getCusto();

        System.out.println(SEPARADOR);
        System.out.println("Comparação: seletiva x total");
        System.out.printf("  Calda economizada:    %.2f L%n", litrosEconomizados);
        System.out.printf("  Valor economizado:    R$ %.2f%n", reaisEconomizados);
        System.out.printf("  Economia:             %.2f%%%n", seletiva.calcularEconomiaPercentual(total));
    }

    private static void imprimirLegenda(Talhao talhao) {
        System.out.printf("Legenda: %c = solo | %c = cultura | %c = erva daninha%n",
                TipoCelula.SOLO.getSimbolo(), TipoCelula.CULTURA.getSimbolo(), TipoCelula.ERVA_DANINHA.getSimbolo());
        System.out.printf("Quantidade: solo = %d | cultura = %d | erva daninha = %d%n",
                talhao.contarCelulas(TipoCelula.SOLO),
                talhao.contarCelulas(TipoCelula.CULTURA),
                talhao.contarCelulas(TipoCelula.ERVA_DANINHA));
    }
}

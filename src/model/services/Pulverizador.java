package model.services;

import model.entities.ResultadoAplicacao;
import model.entities.Talhao;

public class Pulverizador {

    // 1,5 L por célula de 100 m² equivale a 150 L/ha de calda
    private static final double LITROS_POR_CELULA = 1.5;
    private static final double PRECO_POR_LITRO = 2.00;

    private EstrategiaPulverizacao estrategia;

    public Pulverizador(EstrategiaPulverizacao estrategia) {
        this.estrategia = estrategia;
    }

    public ResultadoAplicacao aplicar(Talhao talhao) {
        int celulasPulverizadas = 0;
        for (int i = 0; i < talhao.getLinhas(); i++) {
            for (int j = 0; j < talhao.getColunas(); j++) {
                if (estrategia.devePulverizar(talhao.getCelula(i, j))) {
                    celulasPulverizadas++;
                }
            }
        }

        double litros = celulasPulverizadas * LITROS_POR_CELULA;
        double custo = litros * PRECO_POR_LITRO;
        double areaHectares = Talhao.converterParaHectares(celulasPulverizadas);

        return new ResultadoAplicacao(estrategia.getNome(), celulasPulverizadas, litros, custo, areaHectares);
    }
}

package model.entities;

import model.enums.TipoCelula;

public class Talhao {

    private static final double AREA_CELULA_M2 = 100.0;
    private static final double METROS_QUADRADOS_POR_HECTARE = 10000.0;

    private TipoCelula[][] celulas;

    public Talhao(TipoCelula[][] celulas) {
        this.celulas = celulas;
    }

    public int getLinhas() {
        return celulas.length;
    }

    public int getColunas() {
        return celulas[0].length;
    }

    public TipoCelula getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }

    public int contarCelulas(TipoCelula tipo) {
        int quantidade = 0;
        for (int i = 0; i < getLinhas(); i++) {
            for (int j = 0; j < getColunas(); j++) {
                if (celulas[i][j] == tipo) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public double getAreaTotalHectares() {
        return converterParaHectares(getLinhas() * getColunas());
    }

    public static double converterParaHectares(int quantidadeCelulas) {
        return quantidadeCelulas * AREA_CELULA_M2 / METROS_QUADRADOS_POR_HECTARE;
    }
}

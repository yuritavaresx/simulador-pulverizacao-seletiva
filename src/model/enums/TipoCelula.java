package model.enums;

public enum TipoCelula {
    SOLO('.'),
    CULTURA('C'),
    ERVA_DANINHA('X');

    private final char simbolo;

    TipoCelula(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}

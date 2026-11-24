package model.entities;

public class ResultadoAplicacao {

    private static final double FATOR_PERCENTUAL = 100.0;

    private String nomeEstrategia;
    private int celulasPulverizadas;
    private double litros;
    private double custo;
    private double areaHectares;

    public ResultadoAplicacao(String nomeEstrategia, int celulasPulverizadas, double litros, double custo, double areaHectares) {
        this.nomeEstrategia = nomeEstrategia;
        this.celulasPulverizadas = celulasPulverizadas;
        this.litros = litros;
        this.custo = custo;
        this.areaHectares = areaHectares;
    }

    public String getNomeEstrategia() {
        return nomeEstrategia;
    }

    public int getCelulasPulverizadas() {
        return celulasPulverizadas;
    }

    public double getLitros() {
        return litros;
    }

    public double getCusto() {
        return custo;
    }

    public double getAreaHectares() {
        return areaHectares;
    }

    public double calcularEconomiaPercentual(ResultadoAplicacao referencia) {
        if (referencia.getLitros() == 0) {
            return 0;
        }
        return (referencia.getLitros() - this.litros) / referencia.getLitros() * FATOR_PERCENTUAL;
    }
}

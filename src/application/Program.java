package application;

import model.entities.ResultadoAplicacao;
import model.entities.Talhao;
import model.enums.TipoCelula;
import model.services.EstrategiaPulverizacao;
import model.services.PulverizacaoSeletiva;
import model.services.PulverizacaoTotal;
import model.services.Pulverizador;
import ui.ImpressoraMapa;

public class Program {
    public static void main(String[] args) {
        TipoCelula s = TipoCelula.SOLO;
        TipoCelula c = TipoCelula.CULTURA;
        TipoCelula x = TipoCelula.ERVA_DANINHA;

        TipoCelula[][] mapa = {
                {c, c, x, x, c, c, s, c, c, c},
                {c, c, x, c, c, c, s, c, c, c},
                {c, c, c, c, c, c, s, c, x, c},
                {s, s, s, s, s, s, s, s, x, x},
                {c, c, c, c, c, x, s, c, c, c},
                {c, c, c, c, x, x, s, c, c, c}
        };

        System.out.println("=== Simulador de Pulverização Seletiva ===");
        System.out.println();

        Talhao talhao = new Talhao(mapa);
        ImpressoraMapa.imprimirMapa(talhao);

        EstrategiaPulverizacao total = new PulverizacaoTotal();
        EstrategiaPulverizacao seletiva = new PulverizacaoSeletiva();

        Pulverizador pulverizadorTotal = new Pulverizador(total);
        Pulverizador pulverizadorSeletivo = new Pulverizador(seletiva);

        ResultadoAplicacao resultadoTotal = pulverizadorTotal.aplicar(talhao);
        ResultadoAplicacao resultadoSeletivo = pulverizadorSeletivo.aplicar(talhao);

        ImpressoraMapa.imprimirMapaAplicado(talhao, total);
        ImpressoraMapa.imprimirResultado(resultadoTotal);

        ImpressoraMapa.imprimirMapaAplicado(talhao, seletiva);
        ImpressoraMapa.imprimirResultado(resultadoSeletivo);

        ImpressoraMapa.imprimirComparacao(resultadoTotal, resultadoSeletivo);
    }
}

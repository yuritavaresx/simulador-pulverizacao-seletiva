package model.services;

import model.enums.TipoCelula;

public class PulverizacaoSeletiva implements EstrategiaPulverizacao {

    @Override
    public boolean devePulverizar(TipoCelula tipo) {
        return tipo == TipoCelula.ERVA_DANINHA;
    }

    @Override
    public String getNome() {
        return "Pulverização seletiva";
    }
}

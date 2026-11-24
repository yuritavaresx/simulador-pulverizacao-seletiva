package model.services;

import model.enums.TipoCelula;

public class PulverizacaoTotal implements EstrategiaPulverizacao {

    @Override
    public boolean devePulverizar(TipoCelula tipo) {
        return true;
    }

    @Override
    public String getNome() {
        return "Pulverização total";
    }
}

package model.services;

import model.enums.TipoCelula;

public interface EstrategiaPulverizacao {

    boolean devePulverizar(TipoCelula tipo);

    String getNome();
}

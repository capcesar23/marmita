package br.com.enemarmitas.marmitas.erroHandler.receita;

public class FichaTecnicaNotFoundExepition extends RuntimeException {

    public FichaTecnicaNotFoundExepition(String mensage) {
        super(mensage);
    }

    public FichaTecnicaNotFoundExepition(String mensage, Throwable causa) {
        super(mensage, causa);
    }

}

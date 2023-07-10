package br.com.enemarmitas.marmitas.erroHandler.receita;

import lombok.Data;

@Data
public class DetalhesErro {
    
    private String titulo;
    private String detalhesErro;
    private int status;
    private Long tempoMarcado;


}

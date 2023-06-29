package br.com.enemarmitas.marmitas.dto.receita;

import java.math.BigDecimal;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;

public record FichaTecnicaDTO(
        Long fichaTecnicaId,
        String nome,
        int quantidadePorcoes,
        BigDecimal precoReceita,
        BigDecimal precoTotal) {
            
    public FichaTecnicaDTO(FichaTecnica fichaTecnica) {
        this(
                fichaTecnica.getFichaTecnicaId(),
                fichaTecnica.getNome(),
                fichaTecnica.getQuantidadePorcoes(),
                fichaTecnica.getPrecoReceita(),
                fichaTecnica.getPrecoTotal());
    }
}

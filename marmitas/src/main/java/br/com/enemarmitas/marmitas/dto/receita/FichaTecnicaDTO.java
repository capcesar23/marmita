package br.com.enemarmitas.marmitas.dto.receita;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.model.receita.Ingrediente;
import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;

public record FichaTecnicaDTO(
        Long id,
        String nome,
        Integer quantidadePorcoes,
        BigDecimal precoReceita,
        BigDecimal precoTotal,
        Date dataInclusao,
        Date dataAtualizacao,
        List<Ingrediente> ingredientes,
        List<ModoDeFazer> modosDeFazer) {

    public FichaTecnicaDTO(FichaTecnica fichaTecnica) {
        this(
                fichaTecnica.getId(),
                fichaTecnica.getNome(),
                fichaTecnica.getQuantidadePorcoes(),
                fichaTecnica.getPrecoReceita(),
                fichaTecnica.getPrecoTotal(),
                fichaTecnica.getDataInclusao(),
                fichaTecnica.getDataInclusao(),
                fichaTecnica.getIngredientes(),
                fichaTecnica.getModosDeFazer());
    }
}

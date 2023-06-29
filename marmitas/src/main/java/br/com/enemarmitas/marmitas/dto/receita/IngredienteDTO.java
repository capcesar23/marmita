package br.com.enemarmitas.marmitas.dto.receita;

import java.math.BigDecimal;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.model.receita.Ingrediente;

public record IngredienteDTO(
        Long ingredienteId,
        String nome,
        String unidade,
        BigDecimal pesoliquido,
        BigDecimal pesoTotal,
        BigDecimal custoBruto,
        BigDecimal custoLiquido,
        BigDecimal custoTotal,
        FichaTecnica fichaTecnica) {

    public IngredienteDTO(Ingrediente ingrediente) {
        this(
                ingrediente.getIngredienteId(),
                ingrediente.getNome(),
                ingrediente.getUnidade(),
                ingrediente.getPesoLiquido(),
                ingrediente.getPesoTotal(),
                ingrediente.getCustoBruto(),
                ingrediente.getCustoLiquido(),
                ingrediente.getCustoTotal(),
               ingrediente.getFichaTecnica()
        );
    }
}
package br.com.enemarmitas.marmitas.dto.receita;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;

public record ModoDeFazerDTO(
    Long modoFazerId,
    FichaTecnica fichaTecnica,
    String descricao
) {
public ModoDeFazerDTO(ModoDeFazer modoDeFazer){
    this(
        modoDeFazer.getModoFazerId(),
        modoDeFazer.getFichaTecnica(),
        modoDeFazer.getDescricao()
    );
}
}

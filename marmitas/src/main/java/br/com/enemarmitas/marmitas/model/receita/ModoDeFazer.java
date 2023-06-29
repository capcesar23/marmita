package br.com.enemarmitas.marmitas.model.receita;

import br.com.enemarmitas.marmitas.dto.receita.ModoDeFazerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modo_de_fazer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModoDeFazer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modoFazerId;

    @ManyToOne
    @JoinColumn(name = "ficha_tecnica_id")
    private FichaTecnica fichaTecnica;

    @Lob
    private String descricao;

    public ModoDeFazer (ModoDeFazerDTO modoDeFazerDTO){
        this.modoFazerId= modoDeFazerDTO.modoFazerId();
        this.fichaTecnica = modoDeFazerDTO.fichaTecnica();
        this.descricao = modoDeFazerDTO.descricao();
    }

    public ModoDeFazer(ModoDeFazer modoDeFazerDTO) {
    }
}

package br.com.enemarmitas.marmitas.model.receita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @JsonInclude
    private Long modoFazerId;

    @JsonIgnore // não esperar, para não gerar erro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_tecnica_id")
    private FichaTecnica fichaTecnica;

    @Lob// escrever texto grande
    private String descricao;
    /*
     * public ModoDeFazer (ModoDeFazerDTO modoDeFazerDTO){
     * this.modoFazerId= modoDeFazerDTO.modoFazerId();
     * this.fichaTecnica = modoDeFazerDTO.fichaTecnica();
     * this.descricao = modoDeFazerDTO.descricao();
     * }
     */
}

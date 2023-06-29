package br.com.enemarmitas.marmitas.model.receita;

import java.math.BigDecimal;

import br.com.enemarmitas.marmitas.dto.receita.FichaTecnicaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "fichaTecnicaId")
@Entity(name = "ficha_tecnica")
@Table(name = "ficha_tecnica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fichaTecnicaId;

    private String nome;

    @Column(name = "quantidade_porcoes")
    private Integer quantidadePorcoes;

    @Column(name = "preco_receita")
    private BigDecimal precoReceita;

    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    public FichaTecnica(FichaTecnicaDTO fichaTecnicaDTO) {
        this.fichaTecnicaId = fichaTecnicaDTO.fichaTecnicaId();
        this.nome = fichaTecnicaDTO.nome();
        this.quantidadePorcoes = fichaTecnicaDTO.quantidadePorcoes();
        this.precoReceita = fichaTecnicaDTO.precoReceita();
        this.precoTotal = fichaTecnicaDTO.precoTotal();

    }
}
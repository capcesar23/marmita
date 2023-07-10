package br.com.enemarmitas.marmitas.model.receita;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@Entity(name = "ficha_tecnica")
@Table(name = "ficha_tecnica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade_porcoes", nullable = false)
    private Integer quantidadePorcoes;

    @Column(name = "preco_receita", nullable = false)
    private BigDecimal precoReceita;

    @Column(name = "preco_total", nullable = false)
    private BigDecimal precoTotal;

    @Column(name = "inclusao", updatable = false) // updatable = false não deixa ser modificado no banco de dados
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    private Date dataInclusao;

    @Column(name = "atualizado")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataAtualizacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "fichaTecnica")
    private List<Ingrediente> ingredientes;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "fichaTecnica")
    private List<ModoDeFazer> modosDeFazer;

    /*
     * public FichaTecnica(FichaTecnicaDTO fichaTecnicaDTO) {
     * this.fichaTecnicaId = fichaTecnicaDTO.fichaTecnicaId();
     * this.nome = fichaTecnicaDTO.nome();
     * this.quantidadePorcoes = fichaTecnicaDTO.quantidadePorcoes();
     * this.precoReceita = fichaTecnicaDTO.precoReceita();
     * this.precoTotal = fichaTecnicaDTO.precoTotal();
     * this.ingredientes = fichaTecnicaDTO.ingredientes();
     * 
     * }
     */
}
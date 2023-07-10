package br.com.enemarmitas.marmitas.model.receita;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredienteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String unidade;

    @Column(name = "peso_liquido")
    private BigDecimal pesoLiquido;

    @Column(name = "peso_total")
    private BigDecimal pesoTotal;

    @Column(name = "custo_bruto")
    private BigDecimal custoBruto;

    @Column(name = "custo_liquido")
    private BigDecimal custoLiquido;

    @Column(name = "custo_total")
    private BigDecimal custoTotal;

    @JsonIgnore // não esperar, para não gerar erro
    @ManyToOne(fetch = FetchType.LAZY)// só carrega se necessário
    @JoinColumn(name = "ficha_tecnica_id")
    private FichaTecnica fichaTecnica;

   /* public Ingrediente(IngredienteDTO ingredienteDTO) {
        this.ingredienteId = ingredienteDTO.ingredienteId();
        this.nome = ingredienteDTO.nome();
        this.unidade = ingredienteDTO.unidade();
        this.pesoLiquido = ingredienteDTO.pesoliquido();
        this.pesoTotal = ingredienteDTO.pesoTotal();
        this.custoBruto = ingredienteDTO.custoBruto();
        this.custoLiquido = ingredienteDTO.custoLiquido();
        this.custoTotal = ingredienteDTO.custoTotal();
        this.fichaTecnica = ingredienteDTO.fichaTecnica();
    }
 */    

}

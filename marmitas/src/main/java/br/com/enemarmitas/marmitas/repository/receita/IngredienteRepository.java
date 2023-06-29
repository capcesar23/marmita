package br.com.enemarmitas.marmitas.repository.receita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.enemarmitas.marmitas.model.receita.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query("SELECT i FROM Ingrediente i WHERE i.fichaTecnica.id = :fichaTecnicaId")
    List<Ingrediente> findByFichaTecnicaId(@Param("fichaTecnicaId") Long fichaTecnica);

    List<Ingrediente> findByNomeContainingIgnoreCase(String nome);

}

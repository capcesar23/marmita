package br.com.enemarmitas.marmitas.repository.receita;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;

public interface ModoDeFazerRepository extends JpaRepository<ModoDeFazer, Long> {
    
    @Query("SELECT m FROM ModoDeFazer m WHERE m.fichaTecnica.id = :fichaTecnicaId")
    List<ModoDeFazer> findByFichaTecnicaId(@Param("fichaTecnicaId") Long fichaTecnicaId);
}
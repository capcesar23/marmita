package br.com.enemarmitas.marmitas.repository.receita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;

public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Long> {

    List<FichaTecnica> findByNomeContainingIgnoreCase(String nome);

}

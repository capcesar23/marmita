package br.com.enemarmitas.marmitas.repository.receita;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;

public interface ModoDeFazerRepository extends JpaRepository<ModoDeFazer, Long> {
    
}
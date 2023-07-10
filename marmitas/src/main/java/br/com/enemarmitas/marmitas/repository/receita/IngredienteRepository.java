package br.com.enemarmitas.marmitas.repository.receita;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enemarmitas.marmitas.model.receita.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {


}
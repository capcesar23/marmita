package br.com.enemarmitas.marmitas.controller.receita;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.enemarmitas.marmitas.model.receita.Ingrediente;
import br.com.enemarmitas.marmitas.service.receita.IngredienteService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ingrediente")
@AllArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<Ingrediente>> getAll() {
        List<Ingrediente> ingredientes = ingredienteService.getAllIngredientes();
        return ResponseEntity.ok(ingredientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Ingrediente> create(@RequestBody @Validated Ingrediente newIngrediente,
            UriComponentsBuilder uriBuilder) {
        Ingrediente ingrediente = ingredienteService.insertIngrediente(newIngrediente);
        // cria um endereço para o servidor
        URI uri = uriBuilder.path("/ingrediente/{ingredienteId}")
                .buildAndExpand(ingrediente.getIngredienteId()).toUri();
        return ResponseEntity.created(uri).body(ingrediente);
    }

    @GetMapping("/{ingredienteId}")
    public ResponseEntity<Ingrediente> read(@PathVariable Long ingredienteId) {
        Optional<Ingrediente> optionalIngrediente = ingredienteService.getIngredienteById(ingredienteId);

        if (optionalIngrediente.isPresent()) {
            Ingrediente ingrediente = optionalIngrediente.get();
            return ResponseEntity.ok(ingrediente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Ingrediente>> buscarByNome(@RequestParam("nome") String nome) {
        List<Ingrediente> ingredientes = ingredienteService.buscarByNome(nome);

        if (!ingredientes.isEmpty()) {
            return ResponseEntity.ok(ingredientes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar-ingrediente-por-ficha/{fichaTecnicaId}")
    public ResponseEntity<List<Ingrediente>> findByFichaTecnicaId(@PathVariable Long fichaTecnicaId) {
        List<Ingrediente> ingredientes = ingredienteService.findByFichaTecnicaId(fichaTecnicaId);

        if (!ingredientes.isEmpty()) {
            return ResponseEntity.ok(ingredientes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{ingredienteId}")
    @Transactional
    public ResponseEntity<Ingrediente> update(@PathVariable Long ingredienteId,
            @RequestBody @Validated Ingrediente updatedIngrediente) {
        Optional<Ingrediente> optionalIngrediente = ingredienteService.getIngredienteById(ingredienteId);

        if (optionalIngrediente.isPresent()) {
            Ingrediente existingIngrediente = optionalIngrediente.get();
            existingIngrediente.setNome(updatedIngrediente.getNome());
            existingIngrediente.setUnidade(updatedIngrediente.getUnidade());
            existingIngrediente.setPesoLiquido(updatedIngrediente.getPesoLiquido());
            existingIngrediente.setPesoTotal(updatedIngrediente.getPesoTotal());
            existingIngrediente.setCustoBruto(updatedIngrediente.getCustoBruto());
            existingIngrediente.setCustoLiquido(updatedIngrediente.getCustoLiquido());
            existingIngrediente.setCustoTotal(updatedIngrediente.getCustoTotal());
            existingIngrediente.setFichaTecnica(updatedIngrediente.getFichaTecnica());

            Ingrediente novoIngrediente = ingredienteService.updateIngrediente(existingIngrediente);
            return ResponseEntity.ok(novoIngrediente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ingredienteId}")
    @Transactional
    public ResponseEntity<Ingrediente> delete(@PathVariable Long ingredienteId) {
        boolean deleted = ingredienteService.deleteIngredienteById(ingredienteId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

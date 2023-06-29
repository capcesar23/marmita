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

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.service.receita.FichaTecnicaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fichas-tecnicas")
@AllArgsConstructor
public class FichaTecnicaController {

    private final FichaTecnicaService fichaTecnicaService;

    @GetMapping
    public ResponseEntity<List<FichaTecnica>> getAll() {
        List<FichaTecnica> fichasTecnicas = fichaTecnicaService.getAllFichasTecnicas();
        return ResponseEntity.ok(fichasTecnicas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FichaTecnica> create(@RequestBody @Validated FichaTecnica newFichaTecnica,
            UriComponentsBuilder uriBuilder) {
        FichaTecnica fichaTecnica = fichaTecnicaService.insertFichaTecnica(newFichaTecnica);
        URI uri = uriBuilder.path("/fichas-tecnicas/{id}").buildAndExpand(fichaTecnica.getFichaTecnicaId()).toUri();
        return ResponseEntity.created(uri).body(fichaTecnica);
    }

    @GetMapping("/{fichaTecnicaId}")
    public ResponseEntity<FichaTecnica> read(@PathVariable Long fichaTecnicaId) {
        Optional<FichaTecnica> optionalFichaTecnica = fichaTecnicaService.getFichaTecnicaById(fichaTecnicaId);

        if (optionalFichaTecnica.isPresent()) {
            FichaTecnica fichaTecnica = optionalFichaTecnica.get();
            return ResponseEntity.ok(fichaTecnica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<FichaTecnica>> buscarByNome(@RequestParam("nome") String nome) {
        List<FichaTecnica> fichasTecnicas = fichaTecnicaService.buscarByNome(nome);

        if (!fichasTecnicas.isEmpty()) {
            return ResponseEntity.ok(fichasTecnicas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{fichaTecnicaId}")
    @Transactional
    public ResponseEntity<FichaTecnica> update(@PathVariable Long fichaTecnicaId,
            @RequestBody @Validated FichaTecnica updatedFichaTecnica) {
        Optional<FichaTecnica> optionalFichaTecnica = fichaTecnicaService.getFichaTecnicaById(fichaTecnicaId);

        if (optionalFichaTecnica.isPresent()) {
            FichaTecnica existingFichaTecnica = optionalFichaTecnica.get();
            
            existingFichaTecnica.setNome(updatedFichaTecnica.getNome());
            existingFichaTecnica.setQuantidadePorcoes(updatedFichaTecnica.getQuantidadePorcoes());
            existingFichaTecnica.setPrecoReceita(updatedFichaTecnica.getPrecoReceita());
            existingFichaTecnica.setPrecoTotal(updatedFichaTecnica.getPrecoTotal());

            FichaTecnica novaFichaTecnica = fichaTecnicaService.updateFichaTecnica(existingFichaTecnica);
            return ResponseEntity.ok(novaFichaTecnica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{fichaTecnicaId}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long fichaTecnicaId) {
        boolean deleted = fichaTecnicaService.deleteFichaTecnicaById(fichaTecnicaId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

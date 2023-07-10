package br.com.enemarmitas.marmitas.controller.receita;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.service.receita.FichaTecnicaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/receitas")
@AllArgsConstructor
public class FichaTecnicaController {

    public FichaTecnicaService fichaTecnicaService;

    @GetMapping
    public ResponseEntity<List<FichaTecnica>> listarFichaTecnicas() {
        return ResponseEntity.ok().body(fichaTecnicaService.listar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarFichaTecnica(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok().body(fichaTecnicaService.buscarId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarFichaTecnica(
        @RequestBody FichaTecnica fichaTecnica) {
        fichaTecnica = fichaTecnicaService.salvar(fichaTecnica);
        // URI serve para mostar o caminho de pesquisar 
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fichaTecnica.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<?> atualizarFichaTecnica(
            @PathVariable("id") Long id,
            @RequestBody FichaTecnica fichaTecnica) {

        fichaTecnicaService.atualizar(id, fichaTecnica);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<?> excluirFichaTecnica(
            @PathVariable("id") Long id) {

        fichaTecnicaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
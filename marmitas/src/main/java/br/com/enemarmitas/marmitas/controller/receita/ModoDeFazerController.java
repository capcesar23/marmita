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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;
import br.com.enemarmitas.marmitas.service.receita.ModoDeFazerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/modo-de-fazer")
@AllArgsConstructor
public class ModoDeFazerController {

    private final ModoDeFazerService modoDeFazerService;

    @GetMapping
    public ResponseEntity<List<ModoDeFazer>> getAll() {
        List<ModoDeFazer> modoDeFazer = modoDeFazerService.getAllModoDeFazer();
        return ResponseEntity.ok(modoDeFazer);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModoDeFazer> create (@RequestBody @Validated ModoDeFazer newModoDeFazer,
            UriComponentsBuilder uBuilder) {
        ModoDeFazer modoDeFazer = modoDeFazerService.insertModoDeFazer(newModoDeFazer);
        URI uri = uBuilder.path("/modo-de-fazer/{modoFazerId}")
                .buildAndExpand(modoDeFazer.getModoFazerId()).toUri();
        return ResponseEntity.created(uri).body(modoDeFazer);
    }

    @GetMapping("{modoFazerId}")
    public ResponseEntity<ModoDeFazer> read (@PathVariable Long modoFazerId){
        Optional<ModoDeFazer> optionalModaDeFazer = modoDeFazerService.getModoDeFazerById(modoFazerId);

        if (optionalModaDeFazer.isPresent()) {
            ModoDeFazer modoFazer = optionalModaDeFazer.get();
            return ResponseEntity.ok(modoFazer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // buscra modo de fazer por ficha tecnica
    @GetMapping("/buscar-modo-por-ficha/{fichaTecnicaId}")
    public ResponseEntity<List<ModoDeFazer>> findByFichaTecnicaId(@PathVariable Long fichaTecnicaId){
        List<ModoDeFazer> modoDeFazer = modoDeFazerService.findByFichaTecnicaId(fichaTecnicaId);
        
        if (!modoDeFazer.isEmpty()) {
            return ResponseEntity.ok(modoDeFazer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //atualizar modo de fazer
    @PutMapping("/{modoFazerId}")
    @Transactional
    public ResponseEntity<ModoDeFazer> update(@PathVariable Long modoFazerId,
     @RequestBody @Validated ModoDeFazer updateModoDeFazer){
        Optional<ModoDeFazer> optionalModoDeFazer = modoDeFazerService.getModoDeFazerById(modoFazerId);

        if (optionalModoDeFazer.isPresent()) {
            ModoDeFazer existingModoDeFazer = optionalModoDeFazer.get();
            existingModoDeFazer.setFichaTecnica(updateModoDeFazer.getFichaTecnica());
            existingModoDeFazer.setDescricao(updateModoDeFazer.getDescricao());
            ModoDeFazer novoModoDeFazer = modoDeFazerService.updateModoDeFazer(existingModoDeFazer);
            return ResponseEntity.ok(novoModoDeFazer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //excluir modo de fazer

    @DeleteMapping("/{modoFazerId}")
    @Transactional
    public ResponseEntity<ModoDeFazer> delete(@PathVariable Long modoFazerId) {
        boolean deleted = modoDeFazerService.deleteModoDeFazerId(modoFazerId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

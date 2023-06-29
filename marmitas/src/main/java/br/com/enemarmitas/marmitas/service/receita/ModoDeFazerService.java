package br.com.enemarmitas.marmitas.service.receita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;
import br.com.enemarmitas.marmitas.repository.receita.ModoDeFazerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModoDeFazerService {

    private ModoDeFazerRepository modoDeFazerRepository;

    // buscar pelo id
    public Optional<ModoDeFazer> getModoDeFazerById(Long modoFazerId) {
        if (modoFazerId == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return modoDeFazerRepository.findById(modoFazerId);
    }

    // listar modo de fazer
    public List<ModoDeFazer> getAllModoDeFazer() {
        return modoDeFazerRepository.findAll();
    }

    // listar pelo id da ficha tecnica
    public List<ModoDeFazer> findByFichaTecnicaId(Long fichatecnica) {
        return modoDeFazerRepository.findByFichaTecnicaId(fichatecnica);
    }

    // inserir modo de fazer
    public ModoDeFazer insertModoDeFazer(ModoDeFazer modoFazer) {
        if (modoFazer == null) {
            throw new IllegalArgumentException("Modo de fazer não pode ser nulo");
        }
        return modoDeFazerRepository.save(modoFazer);
    }

    // atualizar modo de fazer
    public ModoDeFazer updateModoDeFazer(ModoDeFazer modoFazerId) {
        if (modoFazerId == null) {
            throw new IllegalArgumentException("Modo de fazer não pode ser nulo");
        }
        return modoDeFazerRepository.save(modoFazerId);
    }

    // deletar pelo id do modo de fazer
    public boolean deleteModoDeFazerId(Long modoFazerId) {
        if (modoFazerId == null) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        modoDeFazerRepository.deleteById(modoFazerId);
        return true;
    }

}

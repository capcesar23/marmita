package br.com.enemarmitas.marmitas.service.receita;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.enemarmitas.marmitas.erroHandler.receita.FichaTecnicaNotFoundExepition;
import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.model.receita.Ingrediente;
import br.com.enemarmitas.marmitas.model.receita.ModoDeFazer;
import br.com.enemarmitas.marmitas.repository.receita.FichaTecnicaRepository;
import br.com.enemarmitas.marmitas.repository.receita.IngredienteRepository;
import br.com.enemarmitas.marmitas.repository.receita.ModoDeFazerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FichaTecnicaService {

    private FichaTecnicaRepository fichaTecnicaRepository;
    private IngredienteRepository ingredienteRepository;
    private ModoDeFazerRepository modoDeFazerRepository;

    public List<FichaTecnica> listar() {
        return fichaTecnicaRepository.findAll();
    }

    public Optional<FichaTecnica> buscarId(Long id) {
        Optional<FichaTecnica> fichaTecnica = fichaTecnicaRepository.findById(id);
        if (fichaTecnica.isPresent()) {
            return fichaTecnica;
        }
      
         throw new FichaTecnicaNotFoundExepition(
                "FichaTecnica com o id: " + id + " não foi encontrada");
    }

    // inicio dos metodos para salvar
    public FichaTecnica salvar(FichaTecnica fichaTecnica) {
        // conferir se tem id para poder salvar
        fichaTecnica.setId(null);
        fichaTecnica.setDataInclusao(new Date());

        // pega a ficha tecnica criada e salva em novaficha
        FichaTecnica novaFicha = fichaTecnicaRepository.save(fichaTecnica);

        if (fichaTecnica.getIngredientes() != null) {
            salvarIngrediente(novaFicha, fichaTecnica.getIngredientes());
        }

        if (fichaTecnica.getModosDeFazer() != null) {
            salvarModoDeFazer(novaFicha, fichaTecnica.getModosDeFazer());
        }

        return novaFicha;
    }

    // metodo para adcionar o ingrediente e modo de fazer a ficha tecnica no metodo
    // salvar
    public void salvarIngrediente(FichaTecnica fichaTecnica,
            List<Ingrediente> ingredientes) {

        ingredientes.forEach(ingrediente -> ingrediente.setFichaTecnica(fichaTecnica));
        ingredienteRepository.saveAll(ingredientes);

    }

    public void salvarModoDeFazer(FichaTecnica fichaTecnica,
            List<ModoDeFazer> modosDeFazer) {
        modosDeFazer.forEach(modoDeFazer -> modoDeFazer.setFichaTecnica(fichaTecnica));
        modoDeFazerRepository.saveAll(modosDeFazer);

    }
    // fim do salvar

    public void atualizar(Long id, FichaTecnica fichaTecnica) {
        if (fichaTecnicaRepository.findById(id).isEmpty()) {
            geraTextoErro(id);
        }
        fichaTecnica.setId(id);
        fichaTecnicaRepository.save(fichaTecnica);
    }

    public void excluir(Long id) {
        if (fichaTecnicaRepository.findById(id).isEmpty()) {
            geraTextoErro(id);
        }
        fichaTecnicaRepository.deleteById(id);
    }

    // gerador de mensagem de erro
    public void geraTextoErro(Long id) {
        throw new FichaTecnicaNotFoundExepition(
                "FichaTecnica com o id: " + id+ " não foi encontrada");
    }

}
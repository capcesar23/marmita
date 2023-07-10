package br.com.enemarmitas.marmitas.erroHandler.receita;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class FichaTecnicaExceptionHandler {

    //metodo para diminuir com o try cacth, buscando erro
    @ExceptionHandler(FichaTecnicaNotFoundExepition.class)
    public ResponseEntity<?> handleFichaTecnicaNotFoundException(
        FichaTecnicaNotFoundExepition re,
        HttpServletRequest request){

            DetalhesErro detalhesErro = new DetalhesErro();
            detalhesErro.setTitulo(re.getMessage());//mensagem do erro
            detalhesErro.setStatus(404);// status do erro
            detalhesErro.setTempoMarcado(System.currentTimeMillis());// pega o momento exato do erro
            detalhesErro.setDetalhesErro(null);// para ajudar os clientes a achar o erro
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);

    }
    
}

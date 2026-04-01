package dev.java10x.cadastrodefuncionarios.Funcionarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a API de cadastro de funcionários, aqui você pode cadastrar, editar, excluir e listar os funcionários da sua empresa.";
    }

}
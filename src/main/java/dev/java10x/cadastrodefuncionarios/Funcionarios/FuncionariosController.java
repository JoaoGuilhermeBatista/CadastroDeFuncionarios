package dev.java10x.cadastrodefuncionarios.Funcionarios;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private FuncionariosService funcionariosService;


    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a API de cadastro de funcionários, aqui você pode cadastrar, editar, excluir e listar os funcionários da sua empresa.";
    }

    // Adicionar Funciońario (CREATE)
    @PostMapping("/adicionar")
    public FuncionariosDTO criarFuncionario(@RequestBody FuncionariosDTO funcionariosDTO) {
        return funcionariosService.criarFuncionario(funcionariosDTO);
    }

    // Procurar Funcionario por Id (CREATE)
    @GetMapping("/procurar/{id}")
    public FuncionariosDTO mostrarFuncionariosId(@PathVariable Long id) {
        return funcionariosService.listarFuncionariosId(id);
    }

    // Mostrar todos os funcionários (READ)
    @GetMapping("/mostrar")
    public List<FuncionariosDTO> mostrarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

    // Alterar dados dos Funcionários (UPDATE)
    @PutMapping("/editar/{id}")
    public FuncionariosDTO editarFuncionarioPorId(@PathVariable Long id, @RequestBody FuncionariosDTO funcionarioAtualizado) {
        return funcionariosService.editarFuncionarioId(id, funcionarioAtualizado);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionarioPorId(@PathVariable Long id) {
        funcionariosService.deletarPorId(id);
    }

}
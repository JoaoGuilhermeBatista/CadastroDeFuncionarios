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
    public FuncionariosModel adicionarFuncionario(@RequestBody FuncionariosModel funcionariosModel) {
        return funcionariosService.criarFuncionarios(funcionariosModel);
    }

    // Procurar Funcionario por Id (CREATE)
    @GetMapping("/procurar/{id}")
    public FuncionariosModel mostrarFuncionariosId(@PathVariable Long id) {
        return funcionariosService.listarFuncionariosId(id);
    }

    // Mostrar todos os funcionários (READ)
    @GetMapping("/mostrar")
    public List<FuncionariosModel> mostrarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

    // Alterar dados dos Funcionários (UPDATE)
    @PutMapping("/editar/{id}")
    public FuncionariosModel editarFuncionarioPorId(@PathVariable Long id, FuncionariosModel funcionarioAtualizado) {
        return funcionariosService.editarFuncionarioId(id, funcionarioAtualizado);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionarioPorId(@PathVariable Long id) {
        funcionariosService.deletarPorId(id);
    }

}
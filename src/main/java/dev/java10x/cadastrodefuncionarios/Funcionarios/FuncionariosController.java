package dev.java10x.cadastrodefuncionarios.Funcionarios;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionariosDTO funcionariosDTO) {
        FuncionariosDTO novoFuncionario = funcionariosService.criarFuncionario(funcionariosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionário criado com sucesso! Nome: " + novoFuncionario.getNome() + " ID: "  + novoFuncionario.getId());
    }

    // Procurar Funcionario por Id (CREATE)
    @GetMapping("/procurar/{id}")
    public ResponseEntity<?> mostrarFuncionariosId(@PathVariable Long id) {
        FuncionariosDTO funcionariosId = funcionariosService.listarFuncionariosId(id);
        if (funcionariosId != null) {
            return ResponseEntity.ok(funcionariosId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não existe no ID: " + id);
        }
    }

    // Mostrar todos os funcionários (READ)
    @GetMapping("/mostrar")
    public ResponseEntity<List<FuncionariosDTO>> mostrarFuncionarios() {
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarios);
    }

    // Alterar dados dos Funcionários (UPDATE)
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarFuncionarioPorId(@PathVariable Long id, @RequestBody FuncionariosDTO funcionarioAtualizado) {

        FuncionariosDTO funcionarioEditado = funcionariosService.editarFuncionarioId(id, funcionarioAtualizado);

        if (funcionarioEditado != null) {
            return ResponseEntity.ok(funcionarioEditado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado! ID: " + id);
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionarioPorId(@PathVariable Long id) {

       if (funcionariosService.listarFuncionariosId(id) != null) {
            funcionariosService.deletarPorId(id);
            return ResponseEntity.ok("Funcionário deletado com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado! ID: " + id);
       }
    }

}
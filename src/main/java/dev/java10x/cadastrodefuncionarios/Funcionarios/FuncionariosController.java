package dev.java10x.cadastrodefuncionarios.Funcionarios;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private final FuncionariosService funcionariosService;


    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @Operation(summary = "Mensagem de boas vindas",
            description = "Essa rota da uma mensagem de boas vindas para quem acessa ela.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mensagem retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a API de cadastro de funcionários, aqui você pode cadastrar, editar, excluir e listar os funcionários da sua empresa.";
    }

    @Operation(summary = "Adicionar funcionário", description = "Cria um novo funcionário no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do funcionário")
    })
    @PostMapping("/adicionar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionariosDTO funcionariosDTO) {
        FuncionariosDTO novoFuncionario = funcionariosService.criarFuncionario(funcionariosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionário criado com sucesso! Nome: " + novoFuncionario.getNome() + " ID: "  + novoFuncionario.getId());
    }

    @Operation(summary = "Buscar funcionário por ID", description = "Retorna os dados de um funcionário pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
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

    @Operation(summary = "Listar todos os funcionários", description = "Retorna a lista completa de funcionários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/mostrar")
    public ResponseEntity<List<FuncionariosDTO>> mostrarFuncionarios() {
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarios);
    }

    @Operation(summary = "Editar funcionário", description = "Atualiza os dados de um funcionário existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    })
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

    @Operation(summary = "Deletar funcionário", description = "Remove um funcionário do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
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
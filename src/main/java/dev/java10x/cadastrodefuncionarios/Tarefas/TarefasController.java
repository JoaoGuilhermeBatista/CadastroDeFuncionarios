package dev.java10x.cadastrodefuncionarios.Tarefas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasRepository tarefasRepository;
    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService, TarefasRepository tarefasRepository) {
        this.tarefasService = tarefasService;
        this.tarefasRepository = tarefasRepository;
    }

    @Operation(summary = "Mensagem de boas vindas",
            description = "Essa rota da uma mensagem de boas vindas para quem acessa ela.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mensagem retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas a parte de designaçao, aqui você pode designar tarefas para os funcionários da sua empresa e qual a sua urgencia.";
    }

    @Operation(summary = "Adicionar tarefa", description = "Cria uma nova tarefa no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação da tarefa")
    })
    @PostMapping("/adicionar")
    public ResponseEntity<String> criarTarefa (@RequestBody TarefasDTO tarefa) {

        TarefasDTO novaTarefa = tarefasService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa criada com sucesso! Título: " + novaTarefa.getNome() + " ID: "  + novaTarefa.getId());
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Retorna os dados de uma tarefa pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/procurar/{id}")
    public ResponseEntity<?> listarTarefasPorId(@PathVariable Long id) {

        TarefasDTO tarefaId = tarefasService.listarTarefaId(id);
        if (tarefaId != null) {
            return ResponseEntity.ok(tarefaId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa não existe no ID: " + id);
        }
    }

    @Operation(summary = "Listar todas as tarefas", description = "Retorna a lista completa de tarefas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/mostrar")
    public ResponseEntity<List<TarefasDTO>> listarTarefas() {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefas);
    }

    @Operation(summary = "Editar tarefa", description = "Atualiza os dados de uma tarefa existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    })
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTarefaPorId(@PathVariable Long id, @RequestBody TarefasDTO tarefaAtualizada) {

        TarefasDTO tarefaEditada = tarefasService.editarTarefaId( id, tarefaAtualizada);
        if (tarefaEditada != null) {
            return ResponseEntity.ok(tarefaEditada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa não existe no ID: " + id);
        }
    }

    @Operation(summary = "Deletar tarefa", description = "Remove uma tarefa do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefaPorId(@PathVariable Long id) {

       if (tarefasService.listarTarefaId(id) != null) {
           tarefasService.deletarTarefaId(id);
           return ResponseEntity.ok("Tarefa deletada com sucesso! ID: " + id);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Tarefa não existe no ID: " + id);
       }
    }
}
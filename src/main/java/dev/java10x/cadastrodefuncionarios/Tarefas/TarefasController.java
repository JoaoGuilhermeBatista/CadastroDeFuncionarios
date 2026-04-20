package dev.java10x.cadastrodefuncionarios.Tarefas;
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

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas a parte de designaçao, aqui você pode designar tarefas para os funcionários da sua empresa e qual a sua urgencia.";
    }

    // Adiconar Tarefa
    @PostMapping("/adicionar")
    public ResponseEntity<String> criarTarefa (@RequestBody TarefasDTO tarefa) {

        TarefasDTO novaTarefa = tarefasService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa criada com sucesso! Título: " + novaTarefa.getNome() + " ID: "  + novaTarefa.getId());
    }

    // Procurar Tarefas por Id
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

    // Mostrar Tarefas
    @GetMapping("/mostrar")
    public ResponseEntity<List<TarefasDTO>> listarTarefas() {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefas);
    }

    //Alterar dados das tarefas
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

    // Deletar Tarefas
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
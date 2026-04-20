package dev.java10x.cadastrodefuncionarios.Tarefas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasRepository tarefasRepository;
    private TarefasService tarefasService;

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
    public TarefasDTO criarTarefa (@RequestBody TarefasDTO tarefa) {
        return tarefasService.criarTarefa(tarefa);
    }

    // Procurar Tarefas por Id
    @GetMapping("/procurar/{id}")
    public TarefasDTO listarTarefasPorId(@PathVariable Long id) {
        return tarefasService.listarTarefaId(id);
    }

    // Mostrar Tarefas
    @GetMapping("/mostrar")
    public List<TarefasDTO> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    //Alterar dados das tarefas
    @PutMapping("/editar/{id}")
    public TarefasDTO editarTarefaPorId(@PathVariable Long id, @RequestBody TarefasDTO tarefaAtualizada) {
        return tarefasService.editarTarefaId( id, tarefaAtualizada);
    }

    // Deletar Tarefas
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefasService.deletarTarefaId(id);
    }
}
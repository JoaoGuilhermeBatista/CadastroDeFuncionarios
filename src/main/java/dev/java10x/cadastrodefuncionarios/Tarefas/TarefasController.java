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
    public TarefasModel adicionarTarefa(@RequestBody TarefasModel tarefas) {
        return tarefasService.adicionarTarefa(tarefas);
    }

    // Procurar Tarefas por Id
    @GetMapping("/procurar/{id}")
    public TarefasModel listarTarefasPorId(@PathVariable Long id) {
        return tarefasService.listarTarefaId(id);
    }

    // Mostrar Tarefas
    @GetMapping("/mostrar")
    public List<TarefasModel> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    //Alterar dados das tarefas
    @PutMapping("/editar/{id}")
    public TarefasModel editarTarefaPorId(@PathVariable Long id, TarefasModel tarefaAtualizada) {
        return tarefasService.editarTarefaId( id, tarefaAtualizada);
    }

    // Deletar Tarefas
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefasService.deletarTarefaId(id);
    }
}
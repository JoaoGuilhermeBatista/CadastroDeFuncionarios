package dev.java10x.cadastrodefuncionarios.Tarefas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas a parte de designaçao, aqui você pode designar tarefas para os funcionários da sua empresa e qual a sua urgencia.";
    }

    // Adiconar Tarefa
    @PostMapping("/adicionar")
    public String adicionarTarefa() {
        return "Tarefa adicionada com sucesso!";
    }

    // Procurar Tarefas por Id
    @GetMapping("/procurar/{id}")
    public String listarTarefasPorId() {
        return "Lista de Tarefas por Id";
    }

    // Mostrar Tarefas
    @GetMapping("/mostrar")
    public List<TarefasModel> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    //Alterar dados das tarefas
    @PutMapping("/editar{id}")
    public String editarTarefaPorId() {
        return "Dados da tarefa alterados";
    }

    // Deletar Tarefas
    @DeleteMapping("/deletar{id}")
    public String deletarTarefaPorId() {
        return "Tarefa deletada";
    }
}
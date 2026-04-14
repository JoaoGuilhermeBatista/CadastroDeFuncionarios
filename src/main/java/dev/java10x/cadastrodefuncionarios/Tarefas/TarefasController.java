package dev.java10x.cadastrodefuncionarios.Tarefas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
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
    public String listarTarefas() {
        return "Lista de tarefas";
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
package dev.java10x.cadastrodefuncionarios.Tarefas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tarefas/ui")
public class TarefasControllerUI {

    private final TarefasService tarefasService;

    public TarefasControllerUI(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @Operation(summary = "Exibir formulário de adição de tarefa", description = "Retorna a página com o formulário para adicionar uma nova tarefa.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formulário carregado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("tarefa", new TarefasDTO());
        return "adicionarTarefa";
    }

    @Operation(summary = "Adicionar tarefa", description = "Recebe o formulário e cria uma nova tarefa.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criada e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação da tarefa")
    })
    @PostMapping("/adicionar")
    public String criarTarefa(@ModelAttribute TarefasDTO tarefa) {
        tarefasService.criarTarefa(tarefa);
        return "redirect:/tarefas/ui/mostrar";
    }

    @Operation(summary = "Listar todas as tarefas", description = "Retorna a página com a lista de todas as tarefas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista carregada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/mostrar")
    public String listarTarefas(Model model) {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        model.addAttribute("tarefas", tarefas);
        return "listarTarefas";
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Retorna a página de detalhes de uma tarefa pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/procurar/{id}")
    public String listarTarefasPorId(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefaId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "detalhesTarefa";
        }
        return "redirect:/tarefas/ui/mostrar";
    }

    @Operation(summary = "Exibir formulário de edição de tarefa", description = "Retorna a página com o formulário para editar uma tarefa existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formulário carregado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefaId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "editarTarefa";
        }
        return "redirect:/tarefas/ui/mostrar";
    }

    @Operation(summary = "Editar tarefa", description = "Recebe o formulário e atualiza os dados de uma tarefa existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    })
    @PostMapping("/editar/{id}")
    public String editarTarefaPorId(@PathVariable Long id, @ModelAttribute TarefasDTO tarefaAtualizada) {
        tarefasService.editarTarefaId(id, tarefaAtualizada);
        return "redirect:/tarefas/ui/mostrar";
    }

    @Operation(summary = "Deletar tarefa", description = "Remove uma tarefa pelo seu ID e redireciona para a listagem.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/deletar/{id}")
    public String deletarTarefaPorId(@PathVariable Long id) {
        tarefasService.deletarTarefaId(id);
        return "redirect:/tarefas/ui/mostrar";
    }
}
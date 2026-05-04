package dev.java10x.cadastrodefuncionarios.Tarefas;

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

    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("tarefa", new TarefasDTO());
        return "adicionarTarefa";
    }

    @PostMapping("/adicionar")
    public String criarTarefa(@ModelAttribute TarefasDTO tarefa) {
        tarefasService.criarTarefa(tarefa);
        return "redirect:/tarefas/ui/mostrar";
    }

    @GetMapping("/mostrar")
    public String listarTarefas(Model model) {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        model.addAttribute("tarefas", tarefas);
        return "listarTarefas";
    }

    @GetMapping("/procurar/{id}")
    public String listarTarefasPorId(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefaId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "detalhesTarefa";
        }
        return "redirect:/tarefas/ui/mostrar";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefaId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "editarTarefa";
        }
        return "redirect:/tarefas/ui/mostrar";
    }

    @PostMapping("/editar/{id}")
    public String editarTarefaPorId(@PathVariable Long id, @ModelAttribute TarefasDTO tarefaAtualizada) {
        tarefasService.editarTarefaId(id, tarefaAtualizada);
        return "redirect:/tarefas/ui/mostrar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarTarefaPorId(@PathVariable Long id) {
        tarefasService.deletarTarefaId(id);
        return "redirect:/tarefas/ui/mostrar";
    }
}
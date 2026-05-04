package dev.java10x.cadastrodefuncionarios.Funcionarios;

import dev.java10x.cadastrodefuncionarios.Tarefas.TarefasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionariosControllerUI {

    private final FuncionariosService funcionariosService;
    private final TarefasService tarefasService;

    public FuncionariosControllerUI(FuncionariosService funcionariosService, TarefasService tarefasService) {
        this.funcionariosService = funcionariosService;
        this.tarefasService = tarefasService;
    }

    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("funcionario", new FuncionariosDTO());
        return "adicionarFuncionario";
    }

    @PostMapping("/adicionar")
    public String criarFuncionario(@ModelAttribute FuncionariosDTO funcionariosDTO) {
        funcionariosService.criarFuncionario(funcionariosDTO);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @GetMapping("/mostrar")
    public String mostrarFuncionarios(Model model) {
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "listarFuncionarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionarioPorId(@PathVariable Long id) {
        funcionariosService.deletarPorId(id);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        FuncionariosDTO funcionario = funcionariosService.listarFuncionariosId(id);
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("tarefas", tarefasService.listarTarefas());
        return "editarFuncionario";
    }

    @PostMapping("/editar/{id}")
    public String editarFuncionarioPorId(@PathVariable Long id,
                                         @ModelAttribute FuncionariosDTO funcionarioAtualizado,
                                         @RequestParam(required = false) Long tarefaId) {
        funcionarioAtualizado.setTarefas(tarefasService.buscarModelPorId(tarefaId).orElse(null));
        funcionariosService.editarFuncionarioId(id, funcionarioAtualizado);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @GetMapping("/procurar/{id}")
    public String mostrarFuncionarioPorId(@PathVariable Long id, Model model) {
        FuncionariosDTO funcionario = funcionariosService.listarFuncionariosId(id);
        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario);
            return "detalhesFuncionario";
        }
        return "redirect:/funcionarios/ui/mostrar";
    }
}
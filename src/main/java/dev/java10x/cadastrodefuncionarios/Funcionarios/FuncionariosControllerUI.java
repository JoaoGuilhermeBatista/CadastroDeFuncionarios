package dev.java10x.cadastrodefuncionarios.Funcionarios;

import dev.java10x.cadastrodefuncionarios.Tarefas.TarefasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Exibir formulário de adição de funcionário", description = "Retorna a página com o formulário para adicionar um novo funcionário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formulário carregado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("funcionario", new FuncionariosDTO());
        return "adicionarFuncionario";
    }

    @Operation(summary = "Adicionar funcionário", description = "Recebe o formulário e cria um novo funcionário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário criado e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do funcionário")
    })
    @PostMapping("/adicionar")
    public String criarFuncionario(@ModelAttribute FuncionariosDTO funcionariosDTO) {
        funcionariosService.criarFuncionario(funcionariosDTO);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @Operation(summary = "Listar todos os funcionários", description = "Retorna a página com a lista de todos os funcionários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista carregada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/mostrar")
    public String mostrarFuncionarios(Model model) {
        List<FuncionariosDTO> funcionarios = funcionariosService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "listarFuncionarios";
    }

    @Operation(summary = "Deletar funcionário", description = "Remove um funcionário pelo seu ID e redireciona para a listagem.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário deletado e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/deletar/{id}")
    public String deletarFuncionarioPorId(@PathVariable Long id) {
        funcionariosService.deletarPorId(id);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @Operation(summary = "Exibir formulário de edição de funcionário", description = "Retorna a página com o formulário para editar um funcionário existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formulário carregado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        FuncionariosDTO funcionario = funcionariosService.listarFuncionariosId(id);
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("tarefas", tarefasService.listarTarefas());
        return "editarFuncionario";
    }

    @Operation(summary = "Editar funcionário", description = "Recebe o formulário e atualiza os dados de um funcionário existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado e redirecionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização")
    })
    @PostMapping("/editar/{id}")
    public String editarFuncionarioPorId(@PathVariable Long id,
                                         @ModelAttribute FuncionariosDTO funcionarioAtualizado,
                                         @RequestParam(required = false) Long tarefaId) {
        funcionarioAtualizado.setTarefas(tarefasService.buscarModelPorId(tarefaId).orElse(null));
        funcionariosService.editarFuncionarioId(id, funcionarioAtualizado);
        return "redirect:/funcionarios/ui/mostrar";
    }

    @Operation(summary = "Buscar funcionário por ID", description = "Retorna a página de detalhes de um funcionário pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido")
    })
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
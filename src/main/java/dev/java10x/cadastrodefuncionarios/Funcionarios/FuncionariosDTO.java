package dev.java10x.cadastrodefuncionarios.Funcionarios;

import dev.java10x.cadastrodefuncionarios.Tarefas.TarefasModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionariosDTO {
    private Long id;
    private String nome;
    private String email;
    private String senioridade;
    private int idade;
    private String telefone;
    private TarefasModel tarefas;

}
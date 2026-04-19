package dev.java10x.cadastrodefuncionarios.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefasDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String status;
    private List<FuncionariosModel> funcionarios;
}
package dev.java10x.cadastrodefuncionarios.Tarefas;
import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Data // Getter and Setters
public class TarefasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;
    // Uma tarefa pode ter mais de um funcionario
    @OneToMany(mappedBy = "tarefas")
    private List<FuncionariosModel> funcionarios;
}
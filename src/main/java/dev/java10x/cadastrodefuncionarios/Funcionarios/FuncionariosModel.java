package dev.java10x.cadastrodefuncionarios.Funcionarios;
import dev.java10x.cadastrodefuncionarios.Tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@Data // Getters and Setters
public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senioridade;

    private int idade;

    // Varios funcionarios podem ter uma unica tarefa
    @ManyToOne
    @JoinColumn(name = "tarefas_id")  // Chave estrangeira
    private TarefasModel tarefas;
}
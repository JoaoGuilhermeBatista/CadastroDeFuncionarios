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
@Data
public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senioridade")
    private String senioridade;

    @Column(name = "idade")
    private int idade;

    @Column(name = "telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "tarefas_id")
    private TarefasModel tarefas;

}
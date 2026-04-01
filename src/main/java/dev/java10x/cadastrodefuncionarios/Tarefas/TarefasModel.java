package dev.java10x.cadastrodefuncionarios.Tarefas;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarefas")
public class TarefasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nome;

    @Column
    String descricao;

    @Column
    String status;
}
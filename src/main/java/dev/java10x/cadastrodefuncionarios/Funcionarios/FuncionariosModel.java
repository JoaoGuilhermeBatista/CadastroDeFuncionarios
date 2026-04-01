package dev.java10x.cadastrodefuncionarios.Funcionarios;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nome;

    @Column
    String email;

    @Column
    String senioridade;

    @Column
    int idade;
}
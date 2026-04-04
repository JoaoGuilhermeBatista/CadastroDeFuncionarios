package dev.java10x.cadastrodefuncionarios.Funcionarios;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senioridade;

    @Column
    private int idade;

    public FuncionariosModel() {
    }

    public FuncionariosModel(Long id, String nome, String email, String senioridade, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senioridade = senioridade;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(String senioridade) {
        this.senioridade = senioridade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
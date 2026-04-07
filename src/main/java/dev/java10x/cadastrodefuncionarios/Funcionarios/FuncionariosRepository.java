package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {
}
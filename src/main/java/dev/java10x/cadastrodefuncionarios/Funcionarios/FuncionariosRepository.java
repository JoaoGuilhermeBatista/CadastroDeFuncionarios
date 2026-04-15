package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {
}
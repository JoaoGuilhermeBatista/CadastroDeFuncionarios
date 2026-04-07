package dev.java10x.cadastrodefuncionarios.Tarefas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
}
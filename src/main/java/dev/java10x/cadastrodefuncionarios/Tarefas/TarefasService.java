package dev.java10x.cadastrodefuncionarios.Tarefas;

import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    private TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }


    // Adicionar Tarefa
    public TarefasModel adicionarTarefa(TarefasModel tarefas) {
        return tarefasRepository.save(tarefas);
    }

    // Mostrar por Id
    public TarefasModel listarTarefaId(Long id) {
        Optional<TarefasModel> tarefaId =  tarefasRepository.findById(id);
        return tarefaId.orElse(null);
    }

    // Mostrar todas as tarefas
    public List<TarefasModel>  listarTarefas() {
        return tarefasRepository.findAll();
    }

    // Deletar Tarefa
    public void deletarTarefaId(Long id) {
        tarefasRepository.deleteById(id);
    }

}
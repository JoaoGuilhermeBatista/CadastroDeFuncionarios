package dev.java10x.cadastrodefuncionarios.Tarefas;

import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    private TarefasRepository tarefasRepository;
    private TarefasMapper tarefasMapper;

    public TarefasService(TarefasRepository tarefasRepository, TarefasMapper tarefasMapper) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasMapper = tarefasMapper;
    }

    // Adicionar Tarefa
    public TarefasDTO criarTarefa(TarefasDTO tarefasDTO) {
        TarefasModel tarefa = tarefasMapper.map(tarefasDTO);
        tarefa = tarefasRepository.save(tarefa);
        return tarefasMapper.map(tarefa);
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

    // Atualizar Tarefa por Id
    public TarefasModel editarTarefaId(Long id, TarefasModel tarefaAtualizada) {
        if (tarefasRepository.existsById(id)) {
            tarefaAtualizada.setId(id);
            return tarefasRepository.save(tarefaAtualizada);
        } else {
            return null;
        }
    }

}
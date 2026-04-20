package dev.java10x.cadastrodefuncionarios.Tarefas;

import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosDTO;
import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;

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

    // Procurar por Id
    public TarefasDTO listarTarefaId(Long id) {
        Optional<TarefasModel> tarefaId =  tarefasRepository.findById(id);
        return tarefaId.map(tarefasMapper::map).orElse(null);
    }

    // Mostrar todas as tarefas
    public List<TarefasDTO>  listarTarefas() {
        List<TarefasModel> tarefas = tarefasRepository.findAll();
        return tarefas.stream()
                .map(tarefasMapper::map)
                .collect(Collectors.toList());
    }

    // Atualizar Tarefa por Id
    public TarefasDTO editarTarefaId(Long id, TarefasDTO tarefaAtualizada) {
        Optional<TarefasModel> tarefaExistente = tarefasRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            TarefasModel tarefaAtualizadaModel = tarefasMapper.map(tarefaAtualizada);
            tarefaAtualizadaModel.setId(id);
            TarefasModel tarefaSalva = tarefasRepository.save(tarefaAtualizadaModel);
            return tarefasMapper.map(tarefaSalva);
        } else {
            return null;
        }
    }

    public Optional<TarefasModel> buscarModelPorId(Long id) {
        if (id == null) return Optional.empty();
        return tarefasRepository.findById(id);
    }

    // Deletar Tarefa
    public void deletarTarefaId(Long id) {
        tarefasRepository.deleteById(id);
    }

}
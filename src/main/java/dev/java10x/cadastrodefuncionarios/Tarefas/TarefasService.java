package dev.java10x.cadastrodefuncionarios.Tarefas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    private TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }


    // Mostrar todas as tarefas
    public List<TarefasModel>  listarTarefas() {
        return tarefasRepository.findAll();
    }
}
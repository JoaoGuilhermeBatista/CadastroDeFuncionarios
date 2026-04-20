package dev.java10x.cadastrodefuncionarios.Tarefas;

import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosDTO;
import dev.java10x.cadastrodefuncionarios.Funcionarios.FuncionariosModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TarefasMapper {

        public TarefasModel map(TarefasDTO tarefaDTO) {
            TarefasModel tarefasModel = new TarefasModel();
            tarefasModel.setId(tarefaDTO.getId());
            tarefasModel.setNome(tarefaDTO.getNome());
            tarefasModel.setDescricao(tarefaDTO.getDescricao());
            tarefasModel.setStatus(tarefaDTO.getStatus());
            tarefasModel.setFuncionarios(tarefaDTO.getFuncionarios());

            return tarefasModel;
        }

        public TarefasDTO map(TarefasModel tarefaModel) {

            TarefasDTO tarefasDTO = new TarefasDTO();
            tarefasDTO.setId(tarefaModel.getId());
            tarefasDTO.setNome(tarefaModel.getNome());
            tarefasDTO.setDescricao(tarefaModel.getDescricao());
            tarefasDTO.setStatus(tarefaModel.getStatus());
            tarefasDTO.setFuncionarios(tarefaModel.getFuncionarios());

            return tarefasDTO;
        }
}
package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionariosMapper {
    public FuncionariosModel map(FuncionariosDTO funcionariosDTO) {
        FuncionariosModel funcionariosModel = new FuncionariosModel();
        funcionariosModel.setId(funcionariosDTO.getId());
        funcionariosModel.setNome(funcionariosDTO.getNome());
        funcionariosModel.setEmail(funcionariosDTO.getEmail());
        funcionariosModel.setSenioridade(funcionariosDTO.getSenioridade());
        funcionariosModel.setIdade(funcionariosDTO.getIdade());
        funcionariosModel.setTelefone(funcionariosDTO.getTelefone());
        funcionariosModel.setTarefas(funcionariosDTO.getTarefas());
        return funcionariosModel;
    }

    public FuncionariosDTO map(FuncionariosModel funcionariosModel) {
        FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
        funcionariosDTO.setId(funcionariosModel.getId());
        funcionariosDTO.setNome(funcionariosModel.getNome());
        funcionariosDTO.setEmail(funcionariosModel.getEmail());
        funcionariosDTO.setSenioridade(funcionariosModel.getSenioridade());
        funcionariosDTO.setIdade(funcionariosModel.getIdade());
        funcionariosDTO.setTelefone(funcionariosModel.getTelefone());
        funcionariosDTO.setTarefas(funcionariosModel.getTarefas());
        return funcionariosDTO;
    }


}
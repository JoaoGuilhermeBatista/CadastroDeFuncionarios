package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionariosMapper {

    public FuncionariosModel map(FuncionariosDTO funcionarioDTO) {

        FuncionariosModel funcionariosModel = new FuncionariosModel();
            funcionariosModel.setId(funcionarioDTO.getId());
            funcionariosModel.setNome(funcionarioDTO.getNome());
            funcionariosModel.setEmail(funcionarioDTO.getEmail());
            funcionariosModel.setSenioridade(funcionarioDTO.getSenioridade());
            funcionariosModel.setIdade(funcionarioDTO.getIdade());
            funcionariosModel.setTelefone(funcionarioDTO.getTelefone());
            funcionariosModel.setTarefas(funcionarioDTO.getTarefas());

            return funcionariosModel;
    }

        public FuncionariosDTO map(FuncionariosModel funcionarioModel) {

            FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
            funcionariosDTO.setId(funcionarioModel.getId());
            funcionariosDTO.setNome(funcionarioModel.getNome());
            funcionariosDTO.setEmail(funcionarioModel.getEmail());
            funcionariosDTO.setSenioridade(funcionarioModel.getSenioridade());
            funcionariosDTO.setIdade(funcionarioModel.getIdade());
            funcionariosDTO.setTelefone(funcionarioModel.getTelefone());
            funcionariosDTO.setTarefas(funcionarioModel.getTarefas());

            return funcionariosDTO;
        }

}
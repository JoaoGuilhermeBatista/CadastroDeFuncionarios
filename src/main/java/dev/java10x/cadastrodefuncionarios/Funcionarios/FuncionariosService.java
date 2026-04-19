package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;
    private FuncionariosMapper funcionariosMapper;

    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosMapper funcionariosMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionariosMapper = funcionariosMapper;
    }

    // Procurar por Id
    public FuncionariosModel listarFuncionariosId(Long id) {
        Optional<FuncionariosModel> funcionarioId = funcionariosRepository.findById(id);
        return funcionarioId.orElse(null);
    }

    // Mostrar todos os funcionários
    public List<FuncionariosModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    // Adicionar um Funcionário
    public FuncionariosDTO criarFuncionario(FuncionariosDTO funcionariosDTO)  {
        FuncionariosModel funcionario = funcionariosMapper.map(funcionariosDTO);
        funcionario = funcionariosRepository.save(funcionario);
        return funcionariosMapper.map(funcionario);
    }

    // Deletar um Funcionário - Tem que ser um método void, pois não tem retorno
    public void deletarPorId(Long id) {
         funcionariosRepository.deleteById(id);
    }

    // Atualizar Funcionario
    public FuncionariosModel editarFuncionarioId(Long id, FuncionariosModel funcionarioAtualizado) {
        if (funcionariosRepository.existsById(id)) {
        funcionarioAtualizado.setId(id);
        return funcionariosRepository.save(funcionarioAtualizado);
        } else {
            return null;
        }
    }



}

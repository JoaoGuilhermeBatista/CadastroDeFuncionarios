package dev.java10x.cadastrodefuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;
    private FuncionariosMapper funcionariosMapper;

    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosMapper funcionariosMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionariosMapper = funcionariosMapper;
    }

    // Procurar por Id
    public FuncionariosDTO listarFuncionariosId(Long id) {
        Optional<FuncionariosModel> funcionarioId = funcionariosRepository.findById(id);
        return funcionarioId.map(funcionariosMapper::map).orElse(null);
    }

    // Mostrar todos os funcionários
    public List<FuncionariosDTO> listarFuncionarios() {
        List<FuncionariosModel> funcionarios = funcionariosRepository.findAll();
        return funcionarios.stream()
                .map(funcionariosMapper::map)
                .collect(Collectors.toList());
    }

    // Adicionar um Funcionário
    public FuncionariosDTO criarFuncionario(FuncionariosDTO funcionariosDTO) {
        FuncionariosModel funcionario = funcionariosMapper.map(funcionariosDTO);
        funcionario = funcionariosRepository.save(funcionario);
        return funcionariosMapper.map(funcionario);
    }

    // Atualizar Funcionario
    public FuncionariosDTO editarFuncionarioId(Long id, FuncionariosDTO funcionariosDTO) {
        Optional<FuncionariosModel> funcionarioExistente = funcionariosRepository.findById(id);
        if (funcionarioExistente.isPresent()) {
            FuncionariosModel funcionarioAtualizado = funcionariosMapper.map(funcionariosDTO);
            funcionarioAtualizado.setId(id);
            FuncionariosModel funcionarioSalvo = funcionariosRepository.save(funcionarioAtualizado);
            return funcionariosMapper.map(funcionarioSalvo);
        } else {
            return null;
        }
    }

        // Deletar um Funcionário - Tem que ser um método void, pois não tem retorno
        public void deletarPorId (Long id){
            funcionariosRepository.deleteById(id);
        }


}

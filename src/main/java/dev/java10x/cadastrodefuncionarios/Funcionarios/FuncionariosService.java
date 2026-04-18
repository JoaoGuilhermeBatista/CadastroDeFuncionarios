package dev.java10x.cadastrodefuncionarios.Funcionarios;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
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
    public FuncionariosModel criarFuncionarios(FuncionariosModel funcionario)  {
        return funcionariosRepository.save(funcionario);
    }

    // Deletar um Funcionário - Tem que ser um método void, pois não tem retorno
    public void deletarPorId(Long id) {
         funcionariosRepository.deleteById(id);
    }

    // Atualizar Funcionario




}

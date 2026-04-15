package dev.java10x.cadastrodefuncionarios.Funcionarios;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    // Procurar por Id


    // Mostrar todos os funcionários
    public List<FuncionariosModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }



}

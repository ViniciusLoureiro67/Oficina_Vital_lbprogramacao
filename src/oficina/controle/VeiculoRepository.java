package oficina.controle;

import java.util.List;
import oficina.modelo.Veiculo;

/**
 * Interface que define as operações básicas para gerenciamento de veículos.
 * Segue o padrão Repository e é implementada por OficinaController.
 */
public interface VeiculoRepository {

    /** Adiciona um novo veículo ao repositório. */
    void adicionarVeiculo(Veiculo v);

    /** Busca um veículo pela placa (retorna null se não encontrado). */
    Veiculo getVeiculoPorPlaca(String placa);

    /** Retorna a lista completa de veículos cadastrados. */
    List<Veiculo> getVeiculos();
}

package oficina.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import oficina.modelo.Veiculo;

/**
 * Stub temporário do controlador da oficina.
 * Guarda uma lista simples de Veiculo e fornece método de busca por placa.
 * Substituir/estender pelo Integrante 4 posteriormente.
 */
public class OficinaController {

    private final List<Veiculo> veiculos = new ArrayList<>();

    public OficinaController() {
        // construtor vazio — opcionalmente carregar dados de teste
    }

    /** Adiciona um veículo (útil para testes) */
    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
            veiculos.add(v);
        }
    }

    /** Busca Veiculo por placa. Retorna null se não encontrado. */
    public Veiculo getVeiculoPorPlaca(String placa) {
        if (placa == null) return null;
        Optional<Veiculo> opt = veiculos.stream()
                .filter(v -> placa.equalsIgnoreCase(v.getPlaca()))
                .findFirst();
        return opt.orElse(null);
    }

    /** Alias comum (em alguns projetos o método pode ter outro nome) */
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return getVeiculoPorPlaca(placa);
    }

    // Métodos adicionais (listar, remover) podem ser adicionados se necessário
}

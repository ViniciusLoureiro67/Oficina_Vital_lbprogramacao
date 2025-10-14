package oficina.modelo.servicos;

import oficina.modelo.exceptions1.ServicoInvalidoException;
import oficina.modelo.exceptions1.VeiculoNaoEncontradoException;
// Import adaptáveis dependendo do seu projeto:
import oficina.controle.OficinaController;
import oficina.modelo.Veiculo;
import oficina.modelo.OrdemServico;

/**
 * Implementação de exemplo de um serviço que opera sobre uma ordem/veículo.
 */
public class ServicoOrdem implements Servico {
    private final String placa;
    private final OficinaController controller;
    private boolean executado = false;
    private OrdemServico ordem; // opcional, caso exista

    public ServicoOrdem(OficinaController controller, String placa) {
        this.controller = controller;
        this.placa = placa;
    }

    @Override
    public void executar() throws ServicoInvalidoException, VeiculoNaoEncontradoException {
        System.out.println("[ServicoOrdem] Iniciando execução do serviço para placa: " + placa);

        if (placa == null || placa.isBlank()) {
            throw new ServicoInvalidoException("Placa inválida informada para o serviço.");
        }

        // Tente usar o método real do seu controller para buscar veículo.
        // Possíveis nomes que seu controller pode ter: buscarVeiculoPorPlaca, getVeiculoPorPlaca, procurarVeiculo.
        // Se necessário, substitua abaixo pelo nome correto do método.
        Veiculo veiculo = null;
        try {
            // EXEMPLO: adaptar para o método real do controller
            // veiculo = controller.buscarVeiculoPorPlaca(placa);
            veiculo = controller.getVeiculoPorPlaca(placa); // <- se for este o caso, senão edite no Eclipse
        } catch (NoSuchMethodError e) {
            // Fallback genérico caso método não exista — só para compilar sem crash.
            System.err.println("[ServicoOrdem] Aviso: método de busca não encontrado no controller. Adapte o nome do método.");
        } catch (Exception e) {
            System.err.println("[ServicoOrdem] Erro ao chamar controller: " + e.getMessage());
        }

        if (veiculo == null) {
            // Tentar uma segunda tentativa usando outro método comum (ajuste se souber o método)
            try {
                // veiculo = controller.procurarVeiculo(placa);
            } catch (Exception ignored) {}
        }

        if (veiculo == null) {
            throw new VeiculoNaoEncontradoException("Veículo com placa '" + placa + "' não encontrado.");
        }

        System.out.println("[ServicoOrdem] Veículo encontrado: " + veiculo.toString());
        System.out.println("[ServicoOrdem] Executando reparos e verificações...");
        executado = true;
        System.out.println("[ServicoOrdem] Execução concluída para placa: " + placa);
    }

    @Override
    public void finalizar() {
        System.out.println("[ServicoOrdem] Finalizando serviço para placa: " + placa);
        if (!executado) {
            System.out.println("[ServicoOrdem] Aviso: serviço finalizado sem execução prévia.");
        }
        // Atualizar ordem / registrar log se necessário
    }
}

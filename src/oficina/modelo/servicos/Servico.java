package oficina.modelo.servicos;

import oficina.modelo.exceptions1.ServicoInvalidoException;
import oficina.modelo.exceptions1.VeiculoNaoEncontradoException;

/**
 * Interface que padroniza a execução de serviços realizados pela oficina.
 */
public interface Servico {

    /**
     * Executa a lógica principal do serviço.
     *
     * @throws ServicoInvalidoException        se os parâmetros forem inválidos.
     * @throws VeiculoNaoEncontradoException   se o veículo associado não for encontrado.
     */
    void executar() throws ServicoInvalidoException, VeiculoNaoEncontradoException;

    /**
     * Finaliza o serviço, registrando conclusão ou liberando recursos.
     */
    void finalizar();
}

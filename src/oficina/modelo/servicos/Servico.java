package oficina.modelo.servicos;

import oficina.modelo.exceptions1.ServicoInvalidoException;
import oficina.modelo.exceptions1.VeiculoNaoEncontradoException;

/**
 * Interface que padroniza serviços realizados pela oficina.
 */
public interface Servico {
    void executar() throws ServicoInvalidoException, VeiculoNaoEncontradoException;
    void finalizar();
}

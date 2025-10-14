package oficina.modelo.exceptions1;

/**
 * Exceção lançada quando um veículo não é encontrado no sistema.
 */
public class VeiculoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;
    public VeiculoNaoEncontradoException() {
        super("Veículo não encontrado.");
    }

    public VeiculoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public VeiculoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

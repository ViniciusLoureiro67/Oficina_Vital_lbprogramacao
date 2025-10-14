package oficina.modelo.exceptions1;

/**
 * Exceção lançada quando os parâmetros ou o estado do serviço são inválidos.
 */
public class ServicoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
    public ServicoInvalidoException() {
        super("Serviço inválido.");
    }

    public ServicoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public ServicoInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

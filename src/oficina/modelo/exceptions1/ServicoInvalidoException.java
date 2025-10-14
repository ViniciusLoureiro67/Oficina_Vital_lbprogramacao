package oficina.modelo.exceptions1;

/**
 * Exceção lançada quando os parâmetros ou o estado do serviço são inválidos.
 */
public class ServicoInvalidoException extends Exception {
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

package oficina.modelo;

/**
 * Representa um cliente da oficina.
 * Herda de Pessoa e sobrescreve exibirInfo().
 */
public class Cliente extends Pessoa {

    private String endereco;

    public Cliente(int id, String nome, String telefone, String email, String endereco) {
        super(id, nome, telefone, email);
        setEndereco(endereco);
    }

    public String getEndereco() {
        return endereco;
    }

    public final void setEndereco(String endereco) {
        this.endereco = (endereco == null || endereco.isBlank()) ? "" : endereco.trim();
    }

    @Override
    public String exibirInfo() {
        return "Cliente: " + getNome()
                + " | Tel: " + getTelefone()
                + " | Endereço: " + endereco;
    }
}

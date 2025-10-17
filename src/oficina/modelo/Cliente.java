package oficina.modelo;

/**
<<<<<<< HEAD
* Representa um cliente da oficina.
* Herda de Pessoa e sobrescreve exibirInfo().
*/
=======
 * Representa um cliente da oficina.
 * Herda de Pessoa e sobrescreve exibirInfo().
 */
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3
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
        this.endereco = (endereco == null) ? "" : endereco.trim();
    }

    @Override
    public String exibirInfo() {
<<<<<<< HEAD
        return "Cliente: " + getNome() 
             + " | Tel: " + getTelefone() 
             + " | Endereço: " + endereco;
    }
}
=======
        return "Cliente: " + getNome() + " | Tel: " + getTelefone() + " | Endereço: " + endereco;
    }
}
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3

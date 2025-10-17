package oficina.modelo;

<<<<<<< HEAD
=======
/**
 * Representa um mecânico da oficina.
 * Herda de Pessoa e sobrescreve exibirInfo().
 */
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3
public class Mecanico extends Pessoa {

    private String especialidade;

    public Mecanico(int id, String nome, String telefone, String email, String especialidade) {
        super(id, nome, telefone, email);
<<<<<<< HEAD
        this.especialidade = (especialidade == null) ? "Geral" : especialidade.trim();
    }
    
    public String getEspecialidade() { return especialidade; }
    
    @Override
    public String exibirInfo() {
        return "Mecânico: " + getNome() 
             + " | Especialidade: " + especialidade 
             + " | Tel: " + getTelefone();
    }
}
=======
        setEspecialidade(especialidade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public final void setEspecialidade(String especialidade) {
        this.especialidade = (especialidade == null) ? "Geral" : especialidade.trim();
    }

    @Override
    public String exibirInfo() {
        return "Mecânico: " + getNome() + " | Especialidade: " + especialidade;
    }
}
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3

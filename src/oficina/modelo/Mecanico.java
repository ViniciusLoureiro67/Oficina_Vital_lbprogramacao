package oficina.modelo;

/**
 * Representa um mecânico da oficina.
 * Herda de Pessoa e sobrescreve exibirInfo().
 */
public class Mecanico extends Pessoa {

    private String especialidade;

    public Mecanico(int id, String nome, String telefone, String email, String especialidade) {
        super(id, nome, telefone, email);
        setEspecialidade(especialidade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public final void setEspecialidade(String especialidade) {
        this.especialidade = (especialidade == null || especialidade.isBlank())
                ? "Geral"
                : especialidade.trim();
    }

    @Override
    public String exibirInfo() {
        return "Mecânico: " + getNome()
                + " | Especialidade: " + especialidade
                + " | Tel: " + getTelefone();
    }
}

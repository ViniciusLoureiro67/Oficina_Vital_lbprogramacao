package oficina.modelo;

public class Mecanico extends Pessoa {

    private String especialidade;

    public Mecanico(int id, String nome, String telefone, String email, String especialidade) {
        super(id, nome, telefone, email);
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
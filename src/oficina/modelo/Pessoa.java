package oficina.modelo;

public abstract class Pessoa {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = (nome == null) ? "" : nome.trim();
        this.telefone = (telefone == null) ? "" : telefone.trim();
        this.email = (email == null) ? "" : email.trim();
    }
    
    // Getters essenciais
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    // Método abstrato que as subclasses devem implementar para exibição
    public abstract String exibirInfo(); 
}
package oficina.modelo;

<<<<<<< HEAD
public abstract class Pessoa {

=======
/**
 * Classe base abstrata para representar uma pessoa no sistema.
 * Aplica encapsulamento (atributos private) e fornece construtores,
 * getters/setters e um método abstrato para exibição de informações.
 */
public abstract class Pessoa {

    // Atributos privados (encapsulamento)
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3
    private int id;
    private String nome;
    private String telefone;
    private String email;

<<<<<<< HEAD
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
=======
    // Construtor completo
    public Pessoa(int id, String nome, String telefone, String email) {
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }

    // Construtor mínimo (opcional)
    public Pessoa(int id, String nome) {
        this(id, nome, "", "");
    }

    // Getters e Setters com validações simples
    public int getId() {
        return id;
    }

    public final void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID deve ser positivo.");
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
        this.nome = nome.trim();
    }

    public String getTelefone() {
        return telefone;
    }

    public final void setTelefone(String telefone) {
        this.telefone = (telefone == null) ? "" : telefone.trim();
    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = (email == null) ? "" : email.trim();
    }

    // Método abstrato (será sobrescrito em Cliente e Mecanico)
    public abstract String exibirInfo();

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + '\'' +
               ", telefone='" + telefone + '\'' +
               ", email='" + email + '\'' + '}';
    }
}
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3

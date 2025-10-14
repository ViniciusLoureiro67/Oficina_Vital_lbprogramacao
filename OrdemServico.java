package oficina.modelo;

/**
 * Classe temporária OrdemServico (stub).
 * Representa uma ordem de serviço simples com id, descricao e status.
 * Integrante 4 deve substituir por implementação completa quando pronta.
 */
public class OrdemServico {

    private int id;
    private String descricao;
    private boolean finalizada;

    public OrdemServico() {}

    public OrdemServico(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.finalizada = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizar() {
        this.finalizada = true;
    }

    @Override
    public String toString() {
        return "OrdemServico{id=" + id + ", descricao='" + descricao + "', finalizada=" + finalizada + "}";
    }
}

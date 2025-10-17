package oficina.modelo;

/**
 * Representa um carro cadastrado na oficina.
 * Herda de Veiculo e sobrescreve exibirInfo().
 */
public class Carro extends Veiculo {

    private int quantidadePortas;

    public Carro(String placa, String marca, String modelo, int ano, int quantidadePortas) {
        super(placa, marca, modelo, ano);
        setQuantidadePortas(quantidadePortas);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public final void setQuantidadePortas(int quantidadePortas) {
        if (quantidadePortas <= 0)
            throw new IllegalArgumentException("Número de portas inválido.");
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String exibirInfo() {
        return "CARRO - Placa: " + getPlaca()
                + " | Marca: " + getMarca()
                + " | Modelo: " + getModelo()
                + " | Ano: " + getAno()
                + " | Portas: " + quantidadePortas;
    }
}

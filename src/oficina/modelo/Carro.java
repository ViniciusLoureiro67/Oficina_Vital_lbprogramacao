package oficina.modelo;

/**
 * Representa um carro cadastrado na oficina.
 * Herda de Veiculo e sobrescreve exibirInfo().
 */
public class Carro extends Veiculo {

    private int portas;

    public Carro(String placa, String marca, String modelo, int ano, int portas) {
        super(placa, marca, modelo, ano);
        setPortas(portas);
    }

    public int getPortas() {
        return portas;
    }

    public final void setPortas(int portas) {
        if (portas <= 0) throw new IllegalArgumentException("Número de portas inválido.");
        this.portas = portas;
    }

    @Override
    public String exibirInfo() {
        return "Carro: " + getMarca() + " " + getModelo() + " (" + getAno() + ") - Placa: " + getPlaca();
    }
}

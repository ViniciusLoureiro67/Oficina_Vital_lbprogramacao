package oficina.modelo;

/**
 * Representa uma moto cadastrada na oficina.
 * Herda de Veiculo e sobrescreve exibirInfo().
 */
public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int ano, int cilindradas) {
        super(placa, marca, modelo, ano);
        setCilindradas(cilindradas);
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public final void setCilindradas(int cilindradas) {
        if (cilindradas <= 0)
            throw new IllegalArgumentException("Cilindrada inválida.");
        this.cilindradas = cilindradas;
    }

    @Override
    public String exibirInfo() {
        return "MOTO - Placa: " + getPlaca()
                + " | Marca: " + getMarca()
                + " | Modelo: " + getModelo()
                + " | Ano: " + getAno()
                + " | Cilindradas: " + cilindradas + "cc";
    }
}

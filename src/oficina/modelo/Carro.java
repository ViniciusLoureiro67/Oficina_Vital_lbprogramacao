package oficina.modelo;

<<<<<<< HEAD
public class Carro extends Veiculo {

    private int quantidadePortas;

    public Carro(String placa, String marca, String modelo, int ano, int quantidadePortas) {
        super(placa, marca, modelo, ano);
        this.quantidadePortas = quantidadePortas;
    }
    
    public int getQuantidadePortas() { return quantidadePortas; }

    @Override
    public String exibirInfo() {
        return "CARRO - Placa: " + getPlaca() 
             + " | Marca: " + getMarca() 
             + " | Modelo: " + getModelo() 
             + " | Ano: " + getAno() 
             + " | Portas: " + quantidadePortas;
    }
}
=======
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
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3

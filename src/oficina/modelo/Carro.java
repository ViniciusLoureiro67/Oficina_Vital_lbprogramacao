package oficina.modelo;

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
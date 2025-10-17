package oficina.modelo;

public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int ano, int cilindradas) {
        super(placa, marca, modelo, ano);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() { return cilindradas; }
    
    @Override
    public String exibirInfo() {
        return "MOTO - Placa: " + getPlaca() 
             + " | Marca: " + getMarca() 
             + " | Modelo: " + getModelo() 
             + " | Ano: " + getAno() 
             + " | Cilindradas: " + cilindradas;
    }
}
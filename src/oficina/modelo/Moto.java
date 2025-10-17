package oficina.modelo;

<<<<<<< HEAD
=======
/**
 * Representa uma moto cadastrada na oficina.
 * Herda de Veiculo e sobrescreve exibirInfo().
 */
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3
public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int ano, int cilindradas) {
        super(placa, marca, modelo, ano);
<<<<<<< HEAD
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
=======
        setCilindradas(cilindradas);
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public final void setCilindradas(int cilindradas) {
        if (cilindradas <= 0) throw new IllegalArgumentException("Cilindrada inválida.");
        this.cilindradas = cilindradas;
    }

    @Override
    public String exibirInfo() {
        return "Moto: " + getMarca() + " " + getModelo() + " (" + getAno() + ") - " + cilindradas + "cc";
    }
}
>>>>>>> e058e9efae63767b58bcfbff4efd60f9e3d5fed3

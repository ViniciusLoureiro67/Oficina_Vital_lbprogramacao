package oficina.modelo;

public abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String placa, String marca, String modelo, int ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Getters essenciais
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }

    // Método abstrato para exibir informações completas
    public abstract String exibirInfo();
    
    @Override
    public String toString() {
        return exibirInfo();
    }
}
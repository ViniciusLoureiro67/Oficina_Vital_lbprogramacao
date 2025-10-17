package oficina.modelo;

import java.util.Objects;

/**
 * Classe base abstrata para veículos.
 * Aplica encapsulamento, validações e prepara herança para Carro e Moto.
 */
public abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    // Construtor completo
    public Veiculo(String placa, String marca, String modelo, int ano) {
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
    }

    // --- Getters e Setters com validações ---
    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("Placa é obrigatória.");
        this.placa = placa.trim().toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca == null || marca.isBlank())
            throw new IllegalArgumentException("Marca é obrigatória.");
        this.marca = marca.trim();
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank())
            throw new IllegalArgumentException("Modelo é obrigatório.");
        this.modelo = modelo.trim();
    }

    public int getAno() {
        return ano;
    }

    public final void setAno(int ano) {
        if (ano < 1900)
            throw new IllegalArgumentException("Ano inválido.");
        this.ano = ano;
    }

    // Método abstrato — implementado por Carro e Moto
    public abstract String exibirInfo();

    @Override
    public String toString() {
        return "Veículo {placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano + '}';
    }

    // --- Igualdade baseada na placa ---
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Veiculo))
            return false;
        Veiculo v = (Veiculo) o;
        return Objects.equals(placa, v.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}

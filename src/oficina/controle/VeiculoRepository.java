package oficina.controle;

import java.util.List;
import oficina.modelo.Veiculo;

public interface VeiculoRepository {

    void adicionarVeiculo(Veiculo v);

    Veiculo getVeiculoPorPlaca(String placa);
    
    List<Veiculo> getVeiculos();
}
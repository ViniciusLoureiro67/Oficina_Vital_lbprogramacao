package oficina.controle;

import java.util.List;
import java.util.Optional;
import oficina.modelo.Cliente;
import oficina.modelo.Veiculo;
import oficina.modelo.Mecanico; 
import oficina.modelo.OrdemServico; 
import java.util.ArrayList; 

// Implementando o contrato da interface VeiculoRepository
public class OficinaController implements VeiculoRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<Mecanico> mecanicos = new ArrayList<>();
    private final List<OrdemServico> ordensServico = new ArrayList<>(); 

    public OficinaController() {
        System.out.println("LOG: OficinaController inicializado.");
    }

    // --- MÉTODOS DE CLIENTE ---
    public void adicionarCliente(Cliente c) {
        if (c != null) {
            this.clientes.add(c);
            System.out.println("LOG: Cliente adicionado: " + c.getNome());
        }
    }
    
    // --- MÉTODOS DE MECÂNICO ---
    public void adicionarMecanico(Mecanico m) {
        if (m != null) {
            this.mecanicos.add(m);
            System.out.println("LOG: Mecânico adicionado: " + m.getNome());
        }
    }

    // --- MÉTODOS DE VEÍCULO (IMPLEMENTAÇÃO DA INTERFACE) ---
    @Override
    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
            // Lógica de verificação e adição
            if (this.veiculos.contains(v)) {
                System.out.println("LOG: Veículo com placa " + v.getPlaca() + " já cadastrado. Cadastro ignorado.");
                return;
            }
            this.veiculos.add(v);
            System.out.println("LOG: Veículo cadastrado: " + v.getPlaca());
        }
    }
    
    @Override
    public Veiculo getVeiculoPorPlaca(String placa) {
        if (placa == null) return null;
        // Usa Stream para encontrar o veículo
        Optional<Veiculo> opt = veiculos.stream()
                .filter(v -> placa.equalsIgnoreCase(v.getPlaca()))
                .findFirst();
        return opt.orElse(null);
    }
    
    @Override
    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    // --- MÉTODOS DE ORDEM DE SERVIÇO ---
    public void registrarOrdemServico(OrdemServico os) {
        if (os == null) return;
        
        try {
            String placa = os.getVeiculo().getPlaca();
            if (this.getVeiculoPorPlaca(placa) != null) {
                this.ordensServico.add(os);
                System.out.println("LOG: Ordem de Serviço #" + os.getId() + " registrada com sucesso para o veículo " + placa);
            } else {
                System.out.println("LOG: ERRO - Veículo com placa " + placa + " não cadastrado. OS não registrada.");
            }
        } catch (Exception e) {
            System.out.println("LOG: ERRO - Falha ao registrar OS: " + e.getMessage());
        }
    }
    
    public List<OrdemServico> getOrdensServico() {
        return this.ordensServico;
    }
}
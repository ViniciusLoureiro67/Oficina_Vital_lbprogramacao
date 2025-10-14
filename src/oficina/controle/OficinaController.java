package oficina.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import oficina.modelo.Cliente;
import oficina.modelo.Veiculo;
import oficina.modelo.OrdemServico; 


public class OficinaController {

   
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<OrdemServico> ordensServico = new ArrayList<>();

    public OficinaController() {
        System.out.println("LOG: OficinaController inicializado.");
    }

    
    public void adicionarCliente(Cliente c) {
        if (c != null) {
            this.clientes.add(c);
            System.out.println("LOG: Cliente adicionado: " + c.getNome());
        }
    }

 
    public void cadastrarVeiculo(Veiculo v) {
      
        this.adicionarVeiculo(v);
    }
    
   
    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
           
            if (this.veiculos.contains(v)) {
                System.out.println("LOG: Veículo com placa " + v.getPlaca() + " já cadastrado. Cadastro ignorado.");
                return;
            }
            this.veiculos.add(v);
            System.out.println("LOG: Veículo cadastrado: " + v.getPlaca());
        }
    }

  
    public void registrarOrdemServico(OrdemServico os) {
        if (os == null) return;

      
        String placa = os.getVeiculo().getPlaca();
        if (this.getVeiculoPorPlaca(placa) != null) {
            this.ordensServico.add(os);
            System.out.println("LOG: Ordem de Serviço #" + os.getId() + " registrada com sucesso para o veículo " + placa);
        } else {
            System.out.println("LOG: ERRO - Veículo com placa " + placa + " não cadastrado. OS não registrada.");
        }
    }
    
    
    public void listarServicos() {
        System.out.println("\n--- INÍCIO: LISTA DE ORDENS DE SERVIÇO (" + this.ordensServico.size() + ") ---");
        if (this.ordensServico.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço registrada.");
        } else {
            for (OrdemServico os : this.ordensServico) {
                System.out.println("  > " + os.toString());
            }
        }
        System.out.println("--- FIM: LISTA DE ORDENS DE SERVIÇO ---");
    }

   


    public Veiculo getVeiculoPorPlaca(String placa) {
        if (placa == null) return null;
        Optional<Veiculo> opt = veiculos.stream()
                .filter(v -> placa.equalsIgnoreCase(v.getPlaca()))
                .findFirst();
        return opt.orElse(null);
    }


    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return getVeiculoPorPlaca(placa);
    }
    
  
    public List<Cliente> getClientes() { return clientes; }
    public List<Veiculo> getVeiculos() { return veiculos; }
    public List<OrdemServico> getOrdensServico() { return ordensServico; }
}
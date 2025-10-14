package oficina.controle;

import java.util.List;
import java.util.Optional;

import oficina.modelo.Cliente;
import oficina.modelo.Veiculo;
import oficina.modelo.OrdemServico; 

import java.util.ArrayList; 

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


    /**
     * CORREÇÃO FINAL: Usa os.isFinalizada() para sincronizar com a classe OrdemServico.java
     */
    public String listarServicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- LISTA DE ORDENS DE SERVIÇO (" + this.ordensServico.size() + ") ---\n");

        if (this.ordensServico.isEmpty()) {
            sb.append("Nenhuma Ordem de Serviço registrada.\n");
        } else {
            for (OrdemServico os : this.ordensServico) {
                 // Sincronização: os.isFinalizada()
                 String status = os.isFinalizada() ? "FINALIZADA" : "PENDENTE"; 
                 sb.append(String.format(
                    "ID: %d | Veículo: %s (Placa: %s) | Valor: R$ %.2f | Status: %s\n",
                    os.getId(),
                    os.getVeiculo().getModelo(),
                    os.getVeiculo().getPlaca(),
                    os.getValor(),
                    status
                 ));
            }
        }
        sb.append("--- FIM: LISTA DE ORDENS DE SERVIÇO ---\n");
        return sb.toString();
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
    
    /**
     * Getter usado pela GUI para acessar a lista.
     */
    public List<OrdemServico> getOrdensServico() { return ordensServico; }
}
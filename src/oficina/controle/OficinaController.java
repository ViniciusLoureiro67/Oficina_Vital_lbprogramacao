package oficina.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import oficina.modelo.Cliente;
import oficina.modelo.Mecanico;
import oficina.modelo.Veiculo;
import oficina.modelo.OrdemServico;

public class OficinaController implements VeiculoRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Mecanico> mecanicos = new ArrayList<>();
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<OrdemServico> ordensServico = new ArrayList<>();

    public OficinaController() {
        System.out.println("LOG: OficinaController inicializado.");
    }

    // ===============================
    // MÉTODOS DE CLIENTE
    // ===============================

    public void adicionarCliente(Cliente c) {
        if (c != null) {
            clientes.add(c);
            System.out.println("LOG: Cliente adicionado: " + c.getNome());
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String listarClientes() {
        if (clientes.isEmpty()) return "Nenhum cliente cadastrado.\n";
        StringBuilder sb = new StringBuilder("=== CLIENTES CADASTRADOS ===\n");
        for (Cliente c : clientes) {
            sb.append(c.exibirInfo()).append("\n");
        }
        sb.append("=============================\n");
        return sb.toString();
    }

    // ===============================
    // MÉTODOS DE MECÂNICO
    // ===============================

    public void adicionarMecanico(Mecanico m) {
        if (m != null) {
            mecanicos.add(m);
            System.out.println("LOG: Mecânico adicionado: " + m.getNome());
        }
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public String listarMecanicos() {
        if (mecanicos.isEmpty()) return "Nenhum mecânico cadastrado.\n";
        StringBuilder sb = new StringBuilder("=== MECÂNICOS CADASTRADOS ===\n");
        for (Mecanico m : mecanicos) {
            sb.append(m.exibirInfo()).append("\n");
        }
        sb.append("==============================\n");
        return sb.toString();
    }

    // ===============================
    // MÉTODOS DE VEÍCULO
    // ===============================

    @Override
    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
            boolean existe = veiculos.stream().anyMatch(x -> x.getPlaca().equalsIgnoreCase(v.getPlaca()));
            if (existe) {
                System.out.println("LOG: Veículo com placa " + v.getPlaca() + " já cadastrado. Cadastro ignorado.");
                return;
            }
            veiculos.add(v);
            System.out.println("LOG: Veículo cadastrado: " + v.getPlaca());
        }
    }

    @Override
    public Veiculo getVeiculoPorPlaca(String placa) {
        if (placa == null) return null;
        Optional<Veiculo> opt = veiculos.stream()
                .filter(v -> placa.equalsIgnoreCase(v.getPlaca()))
                .findFirst();
        return opt.orElse(null);
    }

    @Override
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    // ===============================
    // MÉTODOS DE ORDEM DE SERVIÇO
    // ===============================

    public void registrarOrdemServico(OrdemServico os) {
        if (os == null) return;

        try {
            String placa = os.getVeiculo().getPlaca();
            if (this.getVeiculoPorPlaca(placa) != null) {
                this.ordensServico.add(os);
                System.out.println("LOG: OS #" + os.getId() + " registrada para " + placa);
            } else {
                System.out.println("LOG: ERRO - Veículo " + placa + " não cadastrado.");
            }
        } catch (Exception e) {
            System.out.println("LOG: ERRO - Falha ao registrar OS: " + e.getMessage());
        }
    }

    public List<OrdemServico> getOrdensServico() {
        return ordensServico;
    }

    public String listarServicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- LISTA DE ORDENS DE SERVIÇO (" + this.ordensServico.size() + ") ---\n");

        if (ordensServico.isEmpty()) {
            sb.append("Nenhuma Ordem de Serviço registrada.\n");
        } else {
            for (OrdemServico os : ordensServico) {
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
}

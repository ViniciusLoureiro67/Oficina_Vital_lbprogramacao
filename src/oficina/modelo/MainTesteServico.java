package oficina.modelo;

import java.util.Scanner;
import java.util.List;
import oficina.controle.OficinaController;

/**
 * Classe principal de testes para o sistema da oficina.
 * Permite testar as operações de cadastro e listagem via console.
 */
public class MainTesteServico {

    private static final Scanner sc = new Scanner(System.in);
    private static final OficinaController controller = new OficinaController();

    public static void main(String[] args) {

        System.out.println("=== PAINEL ADMINISTRATIVO DA OFICINA ===");

        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Veículos (Carro/Moto)");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Mecânico");
            System.out.println("4. Registrar Ordem de Serviço");
            System.out.println("5. Listar Veículos Cadastrados");
            System.out.println("6. Listar Ordens de Serviço");
            System.out.println("7. Teste Rápido Automático");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        cadastrarVeiculo();
                        break;
                    case "2":
                        cadastrarCliente();
                        break;
                    case "3":
                        cadastrarMecanico();
                        break;
                    case "4":
                        registrarOrdemServico();
                        break;
                    case "5":
                        listarVeiculos();
                        break;
                    case "6":
                        listarOrdensServico();
                        break;
                    case "7":
                        testeRapido();
                        break;
                    case "0":
                        sair = true;
                        break;
                    default:
                        System.out.println("❌ Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n⚠️ Erro de entrada! Use números válidos para ID, ano, portas, cilindradas e valor.");
            } catch (Exception e) {
                System.out.println("\n⚠️ Ocorreu um erro: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("\nPrograma finalizado.");
    }

    // --- MÉTODOS DE CADASTRO ---

    private static void cadastrarVeiculo() {
        boolean cadastrarMais = true;
        while (cadastrarMais) {
            System.out.println("\n--- CADASTRO DE VEÍCULO ---");
            System.out.print("Tipo de veículo (carro/moto): ");
            String tipo = sc.nextLine().trim().toLowerCase();

            System.out.print("Placa: ");
            String placa = sc.nextLine();

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Ano: ");
            int ano = Integer.parseInt(sc.nextLine());

            if (tipo.equals("carro")) {
                System.out.print("Quantidade de portas: ");
                int portas = Integer.parseInt(sc.nextLine());

                Carro carro = new Carro(placa, marca, modelo, ano, portas);
                controller.adicionarVeiculo(carro);
                System.out.println("✅ Carro cadastrado com sucesso!");
            } else if (tipo.equals("moto")) {
                System.out.print("Cilindradas: ");
                int cilindradas = Integer.parseInt(sc.nextLine());

                Moto moto = new Moto(placa, marca, modelo, ano, cilindradas);
                controller.adicionarVeiculo(moto);
                System.out.println("✅ Moto cadastrada com sucesso!");
            } else {
                System.out.println("❌ Tipo inválido! Digite 'carro' ou 'moto'.");
            }

            System.out.print("Deseja cadastrar outro veículo? (s/n): ");
            String resp = sc.nextLine().trim().toLowerCase();
            if (!resp.equals("s"))
                cadastrarMais = false;
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");

        System.out.print("ID (Número): ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente(id, nome, telefone, email, endereco);
        controller.adicionarCliente(cliente);
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    private static void cadastrarMecanico() {
        System.out.println("\n--- CADASTRO DE MECÂNICO ---");

        System.out.print("ID (Número): ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();

        Mecanico mecanico = new Mecanico(id, nome, telefone, email, especialidade);
        controller.adicionarMecanico(mecanico);
        System.out.println("✅ Mecânico cadastrado com sucesso!");
    }

    private static void registrarOrdemServico() {
        System.out.println("\n--- REGISTRAR ORDEM DE SERVIÇO ---");

        System.out.print("Placa do veículo para a OS: ");
        String placa = sc.nextLine();
        Veiculo veiculo = controller.getVeiculoPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("❌ Erro: Veículo com placa " + placa + " não encontrado. Cadastre-o primeiro.");
            return;
        }

        System.out.print("ID da Ordem de Serviço (Número): ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Descrição do Serviço: ");
        String descricao = sc.nextLine();

        System.out.print("Valor do Serviço (R$): ");
        double valor = Double.parseDouble(sc.nextLine());

        OrdemServico os = new OrdemServico(id, veiculo, descricao, valor);
        controller.registrarOrdemServico(os);

        System.out.println("✅ Ordem de Serviço #" + id + " registrada com sucesso!");
    }

    // --- MÉTODOS DE LISTAGEM ---

    private static void listarVeiculos() {
        System.out.println("\n=== Veículos Cadastrados ===");
        List<Veiculo> veiculos = controller.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            veiculos.forEach(v -> System.out.println(v.exibirInfo()));
        }
    }

    private static void listarOrdensServico() {
        System.out.println("\n=== Ordens de Serviço Cadastradas ===");
        List<OrdemServico> ordens = controller.getOrdensServico();
        if (ordens.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço registrada.");
        } else {
            ordens.forEach(os -> System.out.println(os.toString()));
        }
    }

    // --- TESTE RÁPIDO ---
    private static void testeRapido() {
        System.out.println("\n--- TESTE RÁPIDO AUTOMÁTICO ---");
        try {
            Carro carro = new Carro("ABC-1234", "Toyota", "Corolla", 2022, 4);
            controller.adicionarVeiculo(carro);
            Veiculo encontrado = controller.getVeiculoPorPlaca("ABC-1234");

            if (encontrado != null) {
                System.out.println("✅ Veículo encontrado: " + encontrado.exibirInfo());
            } else {
                System.out.println("❌ Erro: Veículo não encontrado!");
            }

        } catch (Exception e) {
            System.err.println("Erro no teste rápido: " + e.getMessage());
        }
    }
}

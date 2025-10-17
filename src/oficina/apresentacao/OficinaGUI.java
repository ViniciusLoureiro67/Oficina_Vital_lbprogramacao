package oficina.apresentacao;

import oficina.controle.OficinaController;
import oficina.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Interface gráfica completa da Oficina Vital.
 * Contém todas as funcionalidades do menu principal do console.
 */
public class OficinaGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final OficinaController controller;

    private JTextArea txtLogs;
    private JPanel painelCentral;

    public OficinaGUI() {
        this.controller = new OficinaController();
        setTitle("Oficina Vital - Sistema de Gerenciamento");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        add(criarMenuSuperior(), BorderLayout.NORTH);
        add(criarPainelCentral(), BorderLayout.CENTER);
        add(criarPainelLogs(), BorderLayout.SOUTH);

        inicializarDadosDeTeste();
    }

    private JPanel criarMenuSuperior() {
        JPanel painelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));

        JButton btnVeiculo = new JButton("Cadastrar Veículo");
        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnMecanico = new JButton("Cadastrar Mecânico");
        JButton btnOS = new JButton("Registrar Ordem de Serviço");
        JButton btnListarVeiculos = new JButton("Listar Veículos");
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnListarMecanicos = new JButton("Listar Mecânicos");
        JButton btnListarOS = new JButton("Listar Ordens de Serviço");
        JButton btnTeste = new JButton("Teste Automático");

        painelMenu.add(btnVeiculo);
        painelMenu.add(btnCliente);
        painelMenu.add(btnMecanico);
        painelMenu.add(btnOS);
        painelMenu.add(btnListarVeiculos);
        painelMenu.add(btnListarClientes);
        painelMenu.add(btnListarMecanicos);
        painelMenu.add(btnListarOS);
        painelMenu.add(btnTeste);

        btnVeiculo.addActionListener(e -> mostrarPainelCadastroVeiculo());
        btnCliente.addActionListener(e -> mostrarPainelCadastroCliente());
        btnMecanico.addActionListener(e -> mostrarPainelCadastroMecanico());
        btnOS.addActionListener(e -> mostrarPainelRegistrarOS());
        btnListarVeiculos.addActionListener(e -> listarVeiculos());
        btnListarClientes.addActionListener(e -> listarClientes());
        btnListarMecanicos.addActionListener(e -> listarMecanicos());
        btnListarOS.addActionListener(e -> listarOrdensServico());
        btnTeste.addActionListener(e -> executarTesteAutomatico());

        return painelMenu;
    }

    private JPanel criarPainelCentral() {
        painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBorder(BorderFactory.createTitledBorder("Painel de Operações"));
        return painelCentral;
    }

    private JScrollPane criarPainelLogs() {
        txtLogs = new JTextArea(8, 80);
        txtLogs.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtLogs);
        scroll.setBorder(BorderFactory.createTitledBorder("Logs do Sistema"));
        return scroll;
    }

    // ---------- Painéis de Cadastro ----------
    private void mostrarPainelCadastroVeiculo() {
        painelCentral.removeAll();
        painelCentral.setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JComboBox<String> tipo = new JComboBox<>(new String[]{"Carro", "Moto"});
        JTextField placa = new JTextField(10);
        JTextField marca = new JTextField(10);
        JTextField modelo = new JTextField(10);
        JTextField ano = new JTextField(5);
        JTextField atributo = new JTextField(8);
        JButton btnSalvar = new JButton("Salvar Veículo");

        gbc.gridx = 0; gbc.gridy = 0;
        painel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        painel.add(tipo, gbc);
        gbc.gridx = 2;
        painel.add(new JLabel("Placa:"), gbc);
        gbc.gridx = 3;
        painel.add(placa, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painel.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1;
        painel.add(marca, gbc);
        gbc.gridx = 2;
        painel.add(new JLabel("Ano:"), gbc);
        gbc.gridx = 3;
        painel.add(ano, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        painel.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        painel.add(modelo, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 3;
        painel.add(new JLabel("Portas (Carro) / Cilindradas (Moto):"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        painel.add(atributo, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(btnSalvar, gbc);

        painelCentral.add(painel, BorderLayout.CENTER);
        painelCentral.revalidate();
        painelCentral.repaint();

        btnSalvar.addActionListener(e -> {
            try {
                String tipoSelecionado = tipo.getSelectedItem().toString().toLowerCase();
                String placaTxt = placa.getText().trim().toUpperCase();
                String marcaTxt = marca.getText().trim();
                String modeloTxt = modelo.getText().trim();
                int anoNum = Integer.parseInt(ano.getText().trim());

                if (placaTxt.isEmpty() || marcaTxt.isEmpty() || modeloTxt.isEmpty())
                    throw new IllegalArgumentException("Preencha todos os campos obrigatórios.");

                if (tipoSelecionado.equals("carro")) {
                    int portas = Integer.parseInt(atributo.getText().trim());
                    Carro carro = new Carro(placaTxt, marcaTxt, modeloTxt, anoNum, portas);
                    controller.adicionarVeiculo(carro);
                } else {
                    int cilindradas = Integer.parseInt(atributo.getText().trim());
                    Moto moto = new Moto(placaTxt, marcaTxt, modeloTxt, anoNum, cilindradas);
                    controller.adicionarVeiculo(moto);
                }

                log("✅ Veículo cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                log("⚠️ Erro: Ano, portas ou cilindradas precisam ser números válidos.");
            } catch (Exception ex) {
                log("❌ Erro ao cadastrar veículo: " + ex.getMessage());
            }
        });
    }

    private void mostrarPainelCadastroCliente() {
        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField id = new JTextField();
        JTextField nome = new JTextField();
        JTextField telefone = new JTextField();
        JTextField email = new JTextField();
        JTextField endereco = new JTextField();

        painel.add(new JLabel("ID:"));
        painel.add(id);
        painel.add(new JLabel("Nome:"));
        painel.add(nome);
        painel.add(new JLabel("Telefone:"));
        painel.add(telefone);
        painel.add(new JLabel("E-mail:"));
        painel.add(email);
        painel.add(new JLabel("Endereço:"));
        painel.add(endereco);

        JButton btnSalvar = new JButton("Salvar Cliente");
        painel.add(new JLabel());
        painel.add(btnSalvar);

        painelCentral.removeAll();
        painelCentral.add(painel, BorderLayout.CENTER);
        painelCentral.revalidate();
        painelCentral.repaint();

        btnSalvar.addActionListener(e -> {
            try {
                Cliente c = new Cliente(Integer.parseInt(id.getText()), nome.getText(),
                        telefone.getText(), email.getText(), endereco.getText());
                controller.adicionarCliente(c);
                log("✅ Cliente cadastrado com sucesso!");
            } catch (Exception ex) {
                log("❌ Erro ao cadastrar cliente: " + ex.getMessage());
            }
        });
    }

    private void mostrarPainelCadastroMecanico() {
        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField id = new JTextField();
        JTextField nome = new JTextField();
        JTextField telefone = new JTextField();
        JTextField email = new JTextField();
        JTextField especialidade = new JTextField();

        painel.add(new JLabel("ID:"));
        painel.add(id);
        painel.add(new JLabel("Nome:"));
        painel.add(nome);
        painel.add(new JLabel("Telefone:"));
        painel.add(telefone);
        painel.add(new JLabel("E-mail:"));
        painel.add(email);
        painel.add(new JLabel("Especialidade:"));
        painel.add(especialidade);

        JButton btnSalvar = new JButton("Salvar Mecânico");
        painel.add(new JLabel());
        painel.add(btnSalvar);

        painelCentral.removeAll();
        painelCentral.add(painel, BorderLayout.CENTER);
        painelCentral.revalidate();
        painelCentral.repaint();

        btnSalvar.addActionListener(e -> {
            try {
                Mecanico m = new Mecanico(Integer.parseInt(id.getText()), nome.getText(),
                        telefone.getText(), email.getText(), especialidade.getText());
                controller.adicionarMecanico(m);
                log("✅ Mecânico cadastrado com sucesso!");
            } catch (Exception ex) {
                log("❌ Erro ao cadastrar mecânico: " + ex.getMessage());
            }
        });
    }

    private void mostrarPainelRegistrarOS() {
        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        JTextField id = new JTextField();
        JTextField placa = new JTextField();
        JTextField descricao = new JTextField();
        JTextField valor = new JTextField();

        painel.add(new JLabel("ID OS:"));
        painel.add(id);
        painel.add(new JLabel("Placa do Veículo:"));
        painel.add(placa);
        painel.add(new JLabel("Descrição:"));
        painel.add(descricao);
        painel.add(new JLabel("Valor (R$):"));
        painel.add(valor);

        JButton btnSalvar = new JButton("Registrar OS");
        painel.add(new JLabel());
        painel.add(btnSalvar);

        painelCentral.removeAll();
        painelCentral.add(painel, BorderLayout.CENTER);
        painelCentral.revalidate();
        painelCentral.repaint();

        btnSalvar.addActionListener(e -> {
            try {
                Veiculo v = controller.getVeiculoPorPlaca(placa.getText());
                if (v == null) throw new IllegalArgumentException("Veículo não encontrado.");

                OrdemServico os = new OrdemServico(Integer.parseInt(id.getText()), v,
                        descricao.getText(), Double.parseDouble(valor.getText()));
                controller.registrarOrdemServico(os);
                log("✅ Ordem de Serviço registrada com sucesso!");
            } catch (Exception ex) {
                log("❌ Erro ao registrar OS: " + ex.getMessage());
            }
        });
    }

    // ---------- Listagens e Testes ----------
    private void listarVeiculos() {
        StringBuilder sb = new StringBuilder("\n=== VEÍCULOS CADASTRADOS ===\n");
        List<Veiculo> lista = controller.getVeiculos();
        if (lista.isEmpty()) sb.append("Nenhum veículo cadastrado.\n");
        else lista.forEach(v -> sb.append(v.exibirInfo()).append("\n"));
        log(sb.toString());
    }

    private void listarClientes() {
        log(controller.listarClientes());
    }

    private void listarMecanicos() {
        log(controller.listarMecanicos());
    }

    private void listarOrdensServico() {
        log(controller.listarServicos());
    }

    private void executarTesteAutomatico() {
        try {
            Veiculo v = new Carro("ABC-1234", "Ford", "Focus", 2020, 4);
            controller.adicionarVeiculo(v);
            controller.registrarOrdemServico(new OrdemServico(1, v, "Troca de óleo", 120.0));
            log("✅ Teste automático executado com sucesso!");
        } catch (Exception e) {
            log("❌ Erro no teste automático: " + e.getMessage());
        }
    }

    private void inicializarDadosDeTeste() {
        try {
            Veiculo v1 = new Carro("XYZ-9876", "Honda", "Civic", 2021, 4);
            controller.adicionarVeiculo(v1);
            controller.registrarOrdemServico(new OrdemServico(1, v1, "Troca de óleo", 120.0));
            controller.registrarOrdemServico(new OrdemServico(2, v1, "Revisão completa", 450.0));
            controller.getOrdensServico().get(0).finalizar();
            log("Dados de teste carregados com sucesso.");
        } catch (Exception e) {
            log("Falha ao carregar dados de teste iniciais.");
        }
    }

    private void log(String msg) {
        txtLogs.append(msg + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OficinaGUI().setVisible(true));
    }
}

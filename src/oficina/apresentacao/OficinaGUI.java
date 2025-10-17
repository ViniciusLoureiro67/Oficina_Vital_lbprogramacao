package oficina.apresentacao;

import oficina.controle.OficinaController;
import oficina.modelo.Carro;
import oficina.modelo.Veiculo;
import oficina.modelo.OrdemServico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OficinaGUI extends JFrame {


    private final OficinaController controller;

    private JTextField txtPlaca, txtMarca, txtModelo, txtAno, txtPortas;
    private JButton btnCadastrarVeiculo;


    private JTextArea txtAreaLogs;
    private JButton btnListarOS;

    public OficinaGUI() {

        this.controller = new OficinaController();
        setTitle("Oficina Vital - Sistema de Gerenciamento (Integr. 5 - GUI)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); 
 
        JPanel painelCadastro = criarPainelCadastro();
        JPanel painelLogs = criarPainelLogs();
        JPanel painelBotoes = criarPainelBotoes();

        add(painelCadastro, BorderLayout.NORTH);
        add(painelLogs, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        inicializarDadosDeTeste();

        setLocationRelativeTo(null);
    }

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel(new GridLayout(3, 4, 5, 5));
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro de Carro (Simplificado)"));

        painel.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        painel.add(txtPlaca);

        painel.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        painel.add(txtMarca);

        painel.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        painel.add(txtModelo);

        painel.add(new JLabel("Ano:"));
        txtAno = new JTextField();
        painel.add(txtAno);

        painel.add(new JLabel("Portas:"));
        txtPortas = new JTextField();
        painel.add(txtPortas);

        btnCadastrarVeiculo = new JButton("Cadastrar Carro e Registrar OS");
      
        painel.add(new JLabel()); 
        painel.add(btnCadastrarVeiculo);

        btnCadastrarVeiculo.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                cadastrarVeiculoEOrdemServico();
            }
        });

        return painel;
    }

  
    private JPanel criarPainelLogs() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createTitledBorder("Logs e Ordens de Serviço"));
        
        txtAreaLogs = new JTextArea();
        txtAreaLogs.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaLogs);
        
        painel.add(scrollPane, BorderLayout.CENTER);
        return painel;
    }
    

    private JPanel criarPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        btnListarOS = new JButton("Listar Todas as Ordens de Serviço");
   
        btnListarOS.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                listarOrdensDeServico();
            }
        });
        
        painel.add(btnListarOS);
        return painel;
    }


    private void cadastrarVeiculoEOrdemServico() {
        try {
            String placa = txtPlaca.getText().toUpperCase().trim();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            int ano = Integer.parseInt(txtAno.getText().trim());
            int portas = Integer.parseInt(txtPortas.getText().trim());
            
            if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
                 throw new IllegalArgumentException("Preencha todos os campos de texto.");
            }
            
            Carro novoCarro = new Carro(placa, marca, modelo, ano, portas);
            controller.cadastrarVeiculo(novoCarro);

            // CORREÇÃO AQUI: Mudando de controller.getOrdens() para controller.getOrdensServico()
            int proximoId = controller.getOrdensServico().size() + 1; 
            OrdemServico novaOS = new OrdemServico(proximoId, novoCarro, "Orçamento e Diagnóstico Inicial", 50.0);
            controller.registrarOrdemServico(novaOS);
            
            String log = "\n[SUCESSO] Veículo Cadastrado: " + novoCarro.getPlaca() + "\n" + 
                         "[SUCESSO] OS Registrada (ID: " + novaOS.getId() + ").\n";
            txtAreaLogs.append(log);
            
            JOptionPane.showMessageDialog(this, "Veículo e OS registrados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            txtPlaca.setText("");
            txtMarca.setText("");
            txtModelo.setText("");
            txtAno.setText("");
            txtPortas.setText("");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro de Entrada: Ano e Portas devem ser números inteiros válidos.", "Erro de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
             JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
             txtAreaLogs.append("\n[ERRO] Falha: " + ex.getMessage() + "\n");
        }
    }

    private void listarOrdensDeServico() {
        txtAreaLogs.setText(""); 

        String listaFormatada = controller.listarServicos(); // Assume que listarServicos retorna uma String formatada
        
        txtAreaLogs.append("--- LISTA DE ORDENS DE SERVIÇO ---\n");
        txtAreaLogs.append(listaFormatada);
        txtAreaLogs.append("---------------------------------\n");
    }
    
    private void inicializarDadosDeTeste() {
        try {
            Veiculo v1 = new Carro("XYZ-9876", "Honda", "Civic", 2021, 4);
            controller.cadastrarVeiculo(v1);

            controller.registrarOrdemServico(new OrdemServico(1, v1, "Troca de óleo", 120.0));
            controller.registrarOrdemServico(new OrdemServico(2, v1, "Revisão completa", 450.0));

            // CORREÇÃO FINAL: Usa os métodos que existem no seu projeto.
            controller.getOrdensServico().get(0).finalizar(); // <-- CORRIGIDO AQUI!

            txtAreaLogs.append("Dados iniciais de teste (2 OS) carregados com sucesso.\n");
            
        } catch (Exception e) {
            txtAreaLogs.append("Aviso: Falha ao carregar dados de teste iniciais.\n");
        }
    }
}
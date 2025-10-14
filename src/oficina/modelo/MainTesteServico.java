package oficina.modelo;

import oficina.controle.OficinaController;

public class MainTesteServico {
    public static void main(String[] args) {
        OficinaController controller = new OficinaController();

        // Se existir a classe Veiculo com construtor (String placa, String marca, ...),
        // crie um veículo de teste e adicione ao controller.
        try {
            // Ajuste o construtor abaixo conforme a assinatura de Veiculo em seu projeto
            Carro v = new Carro("ABC-1234", "MarcaX", "ModeloY", 2022);
            controller.adicionarVeiculo(v);
            System.out.println("Veículo adicionado: " + v);

            // Teste buscar
            Carro achado = controller.getVeiculoPorPlaca("ABC-1234");
            System.out.println("Veículo buscado: " + achado);

        } catch (Exception e) {
            System.err.println("Erro ao criar veículo de teste: " + e.getMessage());
        }
    }
}

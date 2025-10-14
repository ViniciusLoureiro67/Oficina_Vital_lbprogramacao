package oficina.modelo;

import oficina.controle.OficinaController;

public class MainTesteServico {
    public static void main(String[] args) {
        OficinaController controller = new OficinaController();

        try {
            // Cria um veículo de teste e adiciona ao controller
        	Carro v = new Carro("ABC-1234", "MarcaX", "ModeloY", 2022, 4);
        	controller.adicionarVeiculo(v);
        	System.out.println("Veículo adicionado: " + v);

            // Testa a busca
        	Veiculo achado = controller.getVeiculoPorPlaca("ABC-1234");
        	System.out.println("Veículo buscado: " + achado);

        } catch (Exception e) {
            System.err.println("Erro ao criar veículo de teste: " + e.getMessage());
        }
    }
}

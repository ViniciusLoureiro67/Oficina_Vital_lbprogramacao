package oficina.apresentacao;

import javax.swing.SwingUtilities;

/**
 * Classe principal que inicializa a interface gráfica (GUI) da aplicação Oficina Vital.
 */
public class MainGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OficinaGUI frame = new OficinaGUI();
            frame.setVisible(true);
        });
    }
}

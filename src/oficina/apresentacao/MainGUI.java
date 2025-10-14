package oficina.apresentacao;

import javax.swing.SwingUtilities;

public class MainGUI {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            
            OficinaGUI frame = new OficinaGUI();
            frame.setVisible(true);
        });
    }
}
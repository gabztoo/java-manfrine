import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        // Criando o JFrame principal
        JFrame mainFrame = new JFrame("Tela Principal");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        // Criando um menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");
        JMenuItem tela1 = new JMenuItem("Tela com 6 campos");
        JMenuItem tela2 = new JMenuItem("Tela com ComboBox");
        menu.add(tela1);
        menu.add(tela2);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        // Adicionando uma imagem
        JLabel imageLabel = new JLabel(new ImageIcon("caminho/para/sua/imagem.jpg"));
        mainFrame.add(imageLabel);

        // Ação para abrir a Tela com 6 Campos
        tela1.addActionListener(e -> new TelaCom6Campos());

        // Ação para abrir a Tela com ComboBox
        tela2.addActionListener(e -> new TelaComComboBox());

        mainFrame.setVisible(true);
    }
}

class TelaCom6Campos extends JFrame {
    public TelaCom6Campos() {
        setTitle("Tela com 6 Campos");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adicionando 6 campos
        for (int i = 1; i <= 6; i++) {
            panel.add(new JLabel("Campo " + i + ":"));
            panel.add(new JTextField(20));
        }

        add(panel);
        setVisible(true);
    }
}

class TelaComComboBox extends JFrame {
    public TelaComComboBox() {
        setTitle("Tela com ComboBox");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Selecione uma opção:"));
        
        // Adicionando ComboBox
        String[] options = {"Opção 1", "Opção 2", "Opção 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(comboBox);

        add(panel);
        setVisible(true);
    }
}

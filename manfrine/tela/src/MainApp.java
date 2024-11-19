import javax.swing.*;
import java.awt.*;

public class MainApp {
    // Vetor para armazenar os dados
    static String[] dados = new String[7]; // 6 campos + 1 ComboBox

    public static void main(String[] args) {
        // Tela principal com menu estilizado
        JFrame menuFrame = new JFrame("Menu Principal - Sistema de Reservas");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 500);
        menuFrame.setLayout(new BorderLayout());

        // Adicionando barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Menus principais
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuOpcoes = new JMenu("Opções");
        JMenu menuAjuda = new JMenu("Ajuda");

        // Subitens do menu "Arquivo"
        JMenuItem menuSair = new JMenuItem("Sair");
        menuArquivo.add(menuSair);

        // Subitens do menu "Opções"
        JMenuItem menuPreencherCampos = new JMenuItem("Preencher Campos");
        JMenuItem menuStatusReserva = new JMenuItem("Status da Reserva");
        JMenuItem menuSalvarDados = new JMenuItem("Salvar Dados");
        menuOpcoes.add(menuPreencherCampos);
        menuOpcoes.add(menuStatusReserva);
        menuOpcoes.addSeparator();
        menuOpcoes.add(menuSalvarDados);

        // Subitens do menu "Ajuda"
        JMenuItem menuSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuSobre);

        // Adicionar menus à barra de menu
        menuBar.add(menuArquivo);
        menuBar.add(menuOpcoes);
        menuBar.add(menuAjuda);

        // Adicionar a barra de menu ao frame
        menuFrame.setJMenuBar(menuBar);

        // Título no topo
        JLabel titulo = new JLabel("Sistema de Reservas de Hotel", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(50, 150, 250));
        titulo.setForeground(Color.WHITE);
        titulo.setPreferredSize(new Dimension(500, 50));
        menuFrame.add(titulo, BorderLayout.NORTH);

        // Adicionando uma imagem no centro
        ImageIcon icone = new ImageIcon("hotel.png"); // Substitua "hotel.png" pelo caminho da sua imagem
        JLabel labelImagem = new JLabel(icone, JLabel.CENTER);
        menuFrame.add(labelImagem, BorderLayout.CENTER);

        // Ação dos itens de menu
        menuSair.addActionListener(e -> System.exit(0));
        menuPreencherCampos.addActionListener(e -> new Tela6Campos());
        menuStatusReserva.addActionListener(e -> new TelaComboBox());
        menuSalvarDados.addActionListener(e -> salvarDados(menuFrame));
        menuSobre.addActionListener(e -> JOptionPane.showMessageDialog(menuFrame, "Sistema de Reservas de Hotel\nVersão 1.0\nDesenvolvido por [Seu Nome]."));

        menuFrame.setVisible(true);
    }

    // Salvar dados e exibir no console
    private static void salvarDados(JFrame menuFrame) {
        if (dadosPreenchidos()) {
            JOptionPane.showMessageDialog(menuFrame, "Dados salvos com sucesso!");
            System.out.println("Dados da Reserva:");
            System.out.println("Nome do hóspede: " + dados[0]);
            System.out.println("Tipo de quarto: " + dados[1]);
            System.out.println("Data de check-in: " + dados[2]);
            System.out.println("Data de check-out: " + dados[3]);
            System.out.println("Número de hóspedes: " + dados[4]);
            System.out.println("Preferências: " + dados[5]);
            System.out.println("Status: " + dados[6]);
        } else {
            JOptionPane.showMessageDialog(menuFrame, "Preencha todos os campos antes de salvar!");
        }
    }

    private static boolean dadosPreenchidos() {
        for (String dado : dados) {
            if (dado == null || dado.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

// Tela com 6 Campos
class Tela6Campos extends JFrame {
    public Tela6Campos() {
        setTitle("Preenchimento da Reserva");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Preencha os Dados da Reserva", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(50, 150, 250));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        // Formulário
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(new Color(240, 240, 240));
        JTextField[] campos = new JTextField[6];
        String[] labels = {
            "Nome do hóspede:",
            "Tipo de quarto:",
            "Data de check-in:",
            "Data de check-out:",
            "Número de hóspedes:",
            "Preferências adicionais:"
        };

        for (int i = 0; i < 6; i++) {
            formPanel.add(new JLabel(labels[i]));
            campos[i] = new JTextField();
            formPanel.add(campos[i]);
        }

        add(formPanel, BorderLayout.CENTER);

        // Botão de salvar
        JButton btnSalvar = new JButton("Salvar Dados");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalvar.addActionListener(e -> {
            for (int i = 0; i < 6; i++) {
                MainApp.dados[i] = campos[i].getText(); // Salva os dados no vetor
            }
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
        });

        add(btnSalvar, BorderLayout.SOUTH);
        setVisible(true);
    }
}

// Tela com ComboBox
class TelaComboBox extends JFrame {
    public TelaComboBox() {
        setTitle("Status da Reserva");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Defina o Status da Reserva", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(50, 150, 250));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        // ComboBox
        JPanel comboPanel = new JPanel();
        comboPanel.setBackground(new Color(240, 240, 240));
        JLabel label = new JLabel("Status:");
        comboPanel.add(label);

        String[] opcoes = {"Confirmada", "Cancelada", "Pendente"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboPanel.add(comboBox);
        add(comboPanel, BorderLayout.CENTER);

        // Botão de salvar
        JButton btnSalvar = new JButton("Salvar Status");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalvar.addActionListener(e -> {
            MainApp.dados[6] = (String) comboBox.getSelectedItem(); // Salva o status no vetor
            JOptionPane.showMessageDialog(this, "Status salvo com sucesso!");
        });

        add(btnSalvar, BorderLayout.SOUTH);
        setVisible(true);
    }
}

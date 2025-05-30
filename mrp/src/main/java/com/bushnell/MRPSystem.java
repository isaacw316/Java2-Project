
package com.bushnell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MRPSystem {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MRPSystem() {
        JFrame frame = new JFrame("MRP System");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Left menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200, 720));
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(null); // absolute positioning

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/VisualRoboticsLogo.png"));
        Image img = logoIcon.getImage().getScaledInstance(180, 51, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setBounds(10, 10, 180, 51);
        menuPanel.add(logoLabel);

        // Title
        JLabel titleLabel = new JLabel("MRP System");
        titleLabel.setBounds(10, 70, 180, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        menuPanel.add(titleLabel);

        // Buttons
        String[] buttons = {"Update Stock", "Stock Report", "Bundle", "Demand Analysis"};
        String[] cardNames = {"card1", "card2", "card3", "card4"};
        Color buttonColor = Color.decode("#11E3C2"); // Sample green

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(20, 120 + (i * 60), 160, 40);
            btn.setBackground(buttonColor);
            btn.setForeground(Color.WHITE);
            int finalI = i;
            btn.addActionListener((ActionEvent e) -> cardLayout.show(cardPanel, cardNames[finalI]));
            menuPanel.add(btn);
        }

        // Right content area
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        for (int i = 0; i < buttons.length; i++) {
            JPanel panel;
            switch (cardNames[i]) {
                case "card1":
                    panel = new UpdateStockPanel();
                    break;
                default:
                    panel = new JPanel();
                    panel.add(new JLabel(buttons[i]));
    }
    cardPanel.add(panel, cardNames[i]);
}



        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MRPSystem::new);
    }
}



=======
package com.bushnell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MRPSystem {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MRPSystem() {
        JFrame frame = new JFrame("MRP System");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Left menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200, 720));
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(null); // absolute positioning

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/VisualRoboticsLogo.png"));
        Image img = logoIcon.getImage().getScaledInstance(180, 51, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setBounds(10, 10, 180, 51);
        menuPanel.add(logoLabel);

        // Title
        JLabel titleLabel = new JLabel("MRP System");
        titleLabel.setBounds(10, 70, 180, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        menuPanel.add(titleLabel);

        // Buttons
        String[] buttons = {"Update Stock", "Stock Report", "Bundle", "Demand Analysis"};
        String[] cardNames = {"card1", "card2", "card3", "card4"};
        Color buttonColor = Color.decode("#11E3C2"); // Sample green

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(20, 120 + (i * 60), 160, 40);
            btn.setBackground(buttonColor);
            btn.setForeground(Color.WHITE);
            int finalI = i;
            btn.addActionListener((ActionEvent e) -> cardLayout.show(cardPanel, cardNames[finalI]));
            menuPanel.add(btn);
        }

        // Right content area
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        for (int i = 0; i < buttons.length; i++) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel(buttons[i]);
            panel.add(label);
            cardPanel.add(panel, cardNames[i]);
        }

        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MRPSystem::new);
    }
}



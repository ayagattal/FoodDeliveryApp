package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color; 
import java.awt.Font; 

public class Loginpage {

    private JPanel panel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton loginBtn;
    public JButton switchToSignupBtn;
    
    // Define custom colors
    private static final Color PRIMARY_BTN_COLOR = new Color(0xBC1414); // Dark Red
    private static final Color SECONDARY_BTN_COLOR = new Color(0x58A565); // Green
    private static final Color BACKGROUND_COLOR = new Color(0xFFFFFF); // White
    private static final Color INPUT_BG_COLOR = new Color(0xD9D9D9); // Light Gray

    public Loginpage(MainFrame mainFrame) {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR); 
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR); 
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10; 
        
        // --- Title ---
        JLabel titleLabel = new JLabel("USER LOGIN", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        titleLabel.setForeground(PRIMARY_BTN_COLOR); // Dark Red Title
        panel.add(titleLabel, BorderLayout.NORTH);

        // --- Input Fields (Styled and Enlarged) ---

        // Username Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel usernameLabel = new JLabel("USERNAME:");
        usernameLabel.setForeground(PRIMARY_BTN_COLOR);
        formPanel.add(usernameLabel, gbc);
        
        gbc.gridx = 1;
        usernameField = new JTextField(20); 
        usernameField.setBackground(INPUT_BG_COLOR); // Light Gray Background
        usernameField.setForeground(Color.BLACK);
        formPanel.add(usernameField, gbc);

        // Password Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setForeground(PRIMARY_BTN_COLOR);
        formPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        passwordField = new JPasswordField(20); 
        passwordField.setBackground(INPUT_BG_COLOR); // Light Gray Background
        passwordField.setForeground(Color.BLACK);
        formPanel.add(passwordField, gbc);
        
        // --- Buttons ---
        
        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipadx = 50; 
        loginBtn = new JButton("LOGIN");
        loginBtn.setBackground(PRIMARY_BTN_COLOR); // Dark Red background
        loginBtn.setForeground(BACKGROUND_COLOR); // White text
        loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(loginBtn, gbc);
        
        // Switch to Signup Button
        gbc.gridy = 3;
        gbc.ipadx = 0; 
        switchToSignupBtn = new JButton("Don't have an account? Sign up now"); 
        switchToSignupBtn.setBackground(SECONDARY_BTN_COLOR); // Green background
        switchToSignupBtn.setForeground(BACKGROUND_COLOR); // White text
        formPanel.add(switchToSignupBtn, gbc);

        panel.add(formPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
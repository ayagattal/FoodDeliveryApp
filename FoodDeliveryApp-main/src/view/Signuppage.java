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

public class Signuppage {

    private JPanel panel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JPasswordField confirmPasswordField;
    public JButton signupBtn;
    public JButton switchToLoginBtn;
    
    // Define custom colors
    private static final Color PRIMARY_BTN_COLOR = new Color(0xBC1414); // Dark Red
    private static final Color SECONDARY_BTN_COLOR = new Color(0x58A565); // Green
    private static final Color BACKGROUND_COLOR = new Color(0xFFFFFFFF); // White
    private static final Color INPUT_BG_COLOR = new Color(0xD9D9D9); // Light Gray

    public Signuppage(MainFrame mainFrame) {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR); 

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR); 
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10; 
        
        JLabel titleLabel = new JLabel("CREATE ACCOUNT (SIGN UP)", JLabel.CENTER);
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
        
        // Confirm Password Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel confirmPasswordLabel = new JLabel("VERIFY PASSWORD:");
        confirmPasswordLabel.setForeground(PRIMARY_BTN_COLOR);
        formPanel.add(confirmPasswordLabel, gbc); 
        
        gbc.gridx = 1;
        confirmPasswordField = new JPasswordField(20); 
        confirmPasswordField.setBackground(INPUT_BG_COLOR); // Light Gray Background
        confirmPasswordField.setForeground(Color.BLACK);
        formPanel.add(confirmPasswordField, gbc);
        
        // --- Buttons (Styled) ---
        
        // Signup Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.ipadx = 50; 
        signupBtn = new JButton("REGISTER");
        signupBtn.setBackground(PRIMARY_BTN_COLOR); // Dark Red background
        signupBtn.setForeground(BACKGROUND_COLOR); // White text
        signupBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(signupBtn, gbc);
        
        // Switch to Login Button
        gbc.gridy = 4;
        gbc.ipadx = 0; 
        switchToLoginBtn = new JButton("Already have an account? Login now"); 
        switchToLoginBtn.setBackground(SECONDARY_BTN_COLOR); // Green background
        switchToLoginBtn.setForeground(BACKGROUND_COLOR); // White text
        formPanel.add(switchToLoginBtn, gbc);

        panel.add(formPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
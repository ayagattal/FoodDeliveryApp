package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Signuppage {

    private JPanel panel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JPasswordField confirmPasswordField;
    public JButton signupBtn;
    public JButton switchToLoginBtn;

    private static final Color PRIMARY_BTN_COLOR = new Color(0xBC1414);
    private static final Color SECONDARY_BTN_COLOR = new Color(0x58A565);
    private static final Color BACKGROUND_COLOR = new Color(0xFFFFFF);
    private static final Color INPUT_BG_COLOR = new Color(0xF2F2F2);
    private static final Color BORDER_COLOR = new Color(0xDDDDDD);
    private static final Color TEXT_COLOR = new Color(0x333333);

    public Signuppage(MainFrame mainFrame) {

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 900));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(80, 50, 80, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 15, 0);

        //  Title
        JLabel titleLabel = new JLabel("Create Account", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(PRIMARY_BTN_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titleLabel, gbc);

        JLabel subtitle = new JLabel("Create your new account", JLabel.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(TEXT_COLOR);

        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 30, 0);
        panel.add(subtitle, gbc);

        //  Username
        gbc.insets = new Insets(10, 0, 8, 0);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        usernameLabel.setForeground(TEXT_COLOR);

        gbc.gridy = 2;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField();
        styleInput(usernameField);

        gbc.gridy = 3;
        panel.add(usernameField, gbc);

        //  Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passwordLabel.setForeground(TEXT_COLOR);

        gbc.gridy = 4;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        styleInput(passwordField);

        gbc.gridy = 5;
        panel.add(passwordField, gbc);

        //  Confirm Password
        JLabel confirmLabel = new JLabel("Confirm Password");
        confirmLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        confirmLabel.setForeground(TEXT_COLOR);

        gbc.gridy = 6;
        panel.add(confirmLabel, gbc);

        confirmPasswordField = new JPasswordField();
        styleInput(confirmPasswordField);

        gbc.gridy = 7;
        panel.add(confirmPasswordField, gbc);

        // Signup Button
        signupBtn = new JButton("SIGN UP");
        signupBtn.setPreferredSize(new Dimension(350, 55));
        signupBtn.setBackground(PRIMARY_BTN_COLOR);
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signupBtn.setFocusPainted(false);
        signupBtn.setBorder(new LineBorder(PRIMARY_BTN_COLOR, 1, true));
        signupBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 8;
        gbc.insets = new Insets(35, 0, 15, 0);
        panel.add(signupBtn, gbc);

        switchToLoginBtn = new JButton("Already have an account? Login");
        switchToLoginBtn.setFocusPainted(false);
        switchToLoginBtn.setBorderPainted(false);
        switchToLoginBtn.setContentAreaFilled(false);
        switchToLoginBtn.setForeground(SECONDARY_BTN_COLOR);
        switchToLoginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        switchToLoginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 9;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(switchToLoginBtn, gbc);
    }

    private void styleInput(JTextField field) {
        field.setPreferredSize(new Dimension(350, 48));
        field.setBackground(INPUT_BG_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));
    }

    public JPanel getPanel() {
        return panel;
    }
}

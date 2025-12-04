package view;

import java.awt.*;
import javax.swing.*;

public class Checkoutpage {

    private JPanel panel; // Main panel using BorderLayout
    private JPanel contentPanel; // Panel for fields/buttons using null layout

    // Buttons exposed for controller
    public JButton placeOrderBtn;
    public JButton homeBtn;
    public JButton cartBtn;
    public JButton personBtn;

    // Text fields exposed for controller
    public JTextField fullNameField;
    public JTextField addressField;
    public JTextField numberField;

    public Checkoutpage(MainFrame main) {

        // 1. Initialize the main panel and set BorderLayout
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new BorderLayout()); 
        
        // 2. Initialize the content panel (holds the form elements) and keep null layout
        contentPanel = new JPanel();
        contentPanel.setLayout(null); 
        contentPanel.setPreferredSize(new Dimension(500, 650)); // Define preferred size for content area
        contentPanel.setBackground(Color.white);

        // Title
        JLabel title = new JLabel("Enter Your Information");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(120, 70, 300, 40); 
        contentPanel.add(title);


        // ---- FULL NAME ----
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setBounds(60, 150, 400, 25);
        contentPanel.add(nameLabel);

        fullNameField = new JTextField();
        fullNameField.setBounds(60, 180, 380, 40);
        fullNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        contentPanel.add(fullNameField);


        // ---- ADDRESS ----
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        addressLabel.setBounds(60, 250, 400, 25);
        contentPanel.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(60, 280, 380, 40);
        addressField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        contentPanel.add(addressField);


        // ---- PHONE NUMBER ----
        JLabel numberLabel = new JLabel("Mobile Number:");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        numberLabel.setBounds(60, 350, 400, 25);
        contentPanel.add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(60, 380, 380, 40);
        numberField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        contentPanel.add(numberField);


        // ---- PLACE ORDER BUTTON ----
        placeOrderBtn = new JButton("Place Order");
        placeOrderBtn.setBounds(150, 470, 200, 50);
        placeOrderBtn.setBackground(Color.decode("#BC1414"));
        placeOrderBtn.setForeground(Color.WHITE);
        placeOrderBtn.setFont(new Font("Arial", Font.BOLD, 14));
        placeOrderBtn.setFocusPainted(false);
        contentPanel.add(placeOrderBtn);
        
        // Add content panel to the CENTER of the main panel
        panel.add(contentPanel, BorderLayout.CENTER);


        // 3. Navbar setup
        JPanel navbar = new JPanel();
        // Use GridLayout for navigation buttons
        navbar.setLayout(new GridLayout(1, 3));
        // Set the preferred height for the navbar
        navbar.setPreferredSize(new Dimension(500, 80)); 

        // icon button creation
        homeBtn = createIconButton("/view/icons/maison.png", 30, 30);
        cartBtn = createIconButton("/view/icons/panier.png", 30, 30);
        personBtn = createIconButton("/view/icons/utilisateur.png", 30, 30);

        // Add icons to navbar
        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);

        // 4. Add navbar to the SOUTH position using BorderLayout
        // This ensures the navbar is always docked at the bottom, regardless of frame size.
        panel.add(navbar, BorderLayout.SOUTH);
    }

    // Utility method for icon buttons
    private JButton createIconButton(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        JButton btn = new JButton(new ImageIcon(img));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        return btn;
    }

    public JPanel getPanel() {
        return panel;
    }
}







/*package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Checkoutpage {
	private JPanel checkoutpanel;  // full screen

    public Checkoutpage(MainFrame main) {
        
        checkoutpanel = new JPanel();
        checkoutpanel.setBackground(Color.WHITE);
        checkoutpanel.setLayout(null); 
        checkoutpanel.setPreferredSize(new Dimension(350, 600));


        // Title label
        JLabel title = new JLabel("Enter Your Information");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(60, 60, 250, 40);
        checkoutpanel.add(title);

        // Full Name label / text field
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setBounds(35, 120, 200, 25);
        checkoutpanel.add(nameLabel);

        JTextField fullname = new JTextField();
        fullname.setBounds(35, 145, 280, 35);
        fullname.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        checkoutpanel.add(fullname);

        // Address label / text field
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        addressLabel.setBounds(35, 200, 200, 25);
        checkoutpanel.add(addressLabel);

        JTextField address = new JTextField();
        address.setBounds(35, 225, 280, 35);
        address.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        checkoutpanel.add(address);

        //  Mobile Number label and text field
        JLabel numberLabel = new JLabel("Mobile Number:");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        numberLabel.setBounds(35, 280, 200, 25);
        checkoutpanel.add(numberLabel);

        JTextField number = new JTextField();
        number.setBounds(35, 305, 280, 35);
        number.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        checkoutpanel.add(number);

     //  button
        JButton placeOrder = new JButton("Place Order");
        placeOrder.setBounds(80, 380, 180, 45);
        placeOrder.setBackground(Color.decode("#BC1414"));
        placeOrder.setFont(new Font("Arial", Font.BOLD, 14));
        placeOrder.setFocusPainted(false);
        checkoutpanel.add(placeOrder);
        // 🔹 Add action to switch page
	      placeOrder.addActionListener(e -> {//when the button is clicked, do :
	            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "feedback");
	        });
        
        
        // Navbar panel
        JPanel navbar = new JPanel();
        navbar.setBounds(0, 520, 350, 50);
        navbar.setLayout(new GridLayout(1, 3));
        checkoutpanel.add(navbar);

        // Load icons (INSIDE the constructor)
     // HOME
        ImageIcon homeIcon = new ImageIcon(getClass().getResource("/view/icons/maison.png"));
        Image homeImg = homeIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        JButton homeBtn = new JButton(new ImageIcon(homeImg));

        // CART
        ImageIcon cartIcon = new ImageIcon(getClass().getResource("/view/icons/panier.png"));
        Image cartImg = cartIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JButton cartBtn = new JButton(new ImageIcon(cartImg));

        // PERSON
        ImageIcon personIcon = new ImageIcon(getClass().getResource("/view/icons/utilisateur.png"));
        Image personImg = personIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JButton personBtn = new JButton(new ImageIcon(personImg));

        // Remove border/background from icons
        JButton[] buttons = { homeBtn, cartBtn, personBtn };
        for (JButton b : buttons) {
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
        }
        
        // Add navigation
           homeBtn.addActionListener(e -> mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "menu1"));
           cartBtn.addActionListener(e -> mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "cart"));
           personBtn.addActionListener(e -> mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "checkout"));  

        // Add icons to navbar
        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);
         
        
    }
	

    public JPanel getPanel() {
        return checkoutpanel;
    }
}
*/




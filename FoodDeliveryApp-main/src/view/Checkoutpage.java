package view;

import java.awt.*;
import javax.swing.*;

public class Checkoutpage {

    private JPanel panel;

    // Buttons exposed for controller
    public JButton placeOrderBtn;
    public JButton homeBtn;
    public JButton cartBtn;
    public JButton personBtn;

    public JTextField fullNameField;
    public JTextField addressField;
    public JTextField numberField;

    public Checkoutpage(MainFrame main) {

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(350, 600));

        //title
        JLabel title = new JLabel("Enter Your Information");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(60, 60, 250, 40);
        panel.add(title);

        // -full name
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setBounds(35, 120, 200, 25);
        panel.add(nameLabel);

        fullNameField = new JTextField();
        fullNameField.setBounds(35, 145, 280, 35);
        fullNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.add(fullNameField);

        // @address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        addressLabel.setBounds(35, 200, 200, 25);
        panel.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(35, 225, 280, 35);
        addressField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.add(addressField);

        // phone number
        JLabel numberLabel = new JLabel("Mobile Number:");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        numberLabel.setBounds(35, 280, 200, 25);
        panel.add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(35, 305, 280, 35);
        numberField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.add(numberField);
        


        //placeorder button
        placeOrderBtn = new JButton("Place Order");
        placeOrderBtn.setBounds(80, 380, 180, 45);
        placeOrderBtn.setBackground(Color.decode("#BC1414"));
        placeOrderBtn.setForeground(Color.WHITE);
        placeOrderBtn.setFont(new Font("Arial", Font.BOLD, 14));
        placeOrderBtn.setFocusPainted(false);
        panel.add(placeOrderBtn);

        //navbar
        JPanel navbar = new JPanel();
        navbar.setBounds(0, 520, 350, 50);
        navbar.setLayout(new GridLayout(1, 3));
        panel.add(navbar);

        // icon button
        homeBtn = createIconButton("/view/icons/maison.png", 15, 15);
        cartBtn = createIconButton("/view/icons/panier.png", 20, 20);
        personBtn = createIconButton("/view/icons/utilisateur.png", 20, 20);

        // Add icons to navbar
        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);
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




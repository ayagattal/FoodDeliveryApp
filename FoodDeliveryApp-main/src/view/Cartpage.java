package view;

import java.awt.*;
import model.FoodItem;
import javax.swing.*;

public class Cartpage {

    private JPanel panel;
    private JPanel itemsPanel;
    private JScrollPane scrollPane;
    private int yPosition = 20;

    public JButton checkoutBtn, backBtn, homeBtn, cartBtn, personBtn;
    private double totalPrice = 0;
    private JLabel totalLabel;

    public Cartpage(MainFrame main) {

        // Panel principal de la page
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Panel des items
        itemsPanel = new JPanel();
        itemsPanel.setLayout(null); 
        itemsPanel.setBackground(Color.WHITE);

        // ScrollPane pour les items
        scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Use a container panel to hold scroll and bottom controls
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for total and checkout/back buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(null); // absolute positioning for buttons
        bottomPanel.setPreferredSize(new Dimension(350, 150));
        bottomPanel.setBackground(Color.WHITE);

        // Total label
        totalLabel = new JLabel("Total: 0 DA");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setBounds(20, 10, 200, 30);
        bottomPanel.add(totalLabel);

        // Checkout button
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.setBounds(80, 50, 180, 45);
        checkoutBtn.setBackground(Color.decode("#BC1414"));
        checkoutBtn.setForeground(Color.WHITE);
        checkoutBtn.setFont(new Font("Arial", Font.BOLD, 14));
        checkoutBtn.setFocusPainted(false);
        bottomPanel.add(checkoutBtn);

        // Back button
        backBtn = new JButton("Back to Menu");
        backBtn.setBounds(80, 100, 180, 45);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        bottomPanel.add(backBtn);

        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        panel.add(centerPanel, BorderLayout.CENTER);

        // Navbar
        JPanel navbar = new JPanel();
        navbar.setLayout(new GridLayout(1, 3));
        navbar.setPreferredSize(new Dimension(350, 50));

        homeBtn = createIconButton("/view/icons/maison.png", 15, 15);
        cartBtn = createIconButton("/view/icons/panier.png", 20, 20);
        personBtn = createIconButton("/view/icons/utilisateur.png", 20, 20);

        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);

        panel.add(navbar, BorderLayout.SOUTH);
    }

    private JButton createIconButton(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        JButton btn = new JButton(new ImageIcon(img));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        return btn;
    }

    // Ajouter un item
    public void addItem(FoodItem item){
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(null);
        itemPanel.setBounds(20, yPosition, 330, 80);
        itemPanel.setBackground(new Color(230,230,230));

        JLabel imgLabel = new JLabel(item.getImage());
        imgLabel.setBounds(5,5,70,70);
        itemPanel.add(imgLabel);

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setBounds(85,10,200,20);
        itemPanel.add(nameLabel);

        JLabel priceLabel = new JLabel(item.getPrice()+" DA");
        priceLabel.setBounds(85,35,200,20);
        itemPanel.add(priceLabel);
        
     // ---- REMOVE BUTTON ----
        JButton removeBtn = createIconButton("/view/icons/croix-cercle.png", 18, 18);
        removeBtn.setBounds(270, 5, 30, 30);
        itemPanel.add(removeBtn);

        // Remove action
        removeBtn.addActionListener(e -> {
            totalPrice -= item.getPrice();
            totalLabel.setText("Total: " + totalPrice + " DA");

            itemsPanel.remove(itemPanel);

            yPosition -= 90;
            itemsPanel.setPreferredSize(new Dimension(330, yPosition));

            itemsPanel.revalidate();
            itemsPanel.repaint();
        });
        
        // ---- + and - icons BUTTON ----
        JButton increaseBtn = createIconButton("/view/icons/ajouter.png", 18, 18);
        increaseBtn.setBounds(245, 35, 30, 30);
        itemPanel.add(increaseBtn);
        
        JLabel qtyLabel = new JLabel("1", SwingConstants.CENTER);
        qtyLabel.setBounds(225, 35, 30, 30);
        qtyLabel.setFont(new Font("Arial", Font.BOLD, 14));
        itemPanel.add(qtyLabel);

        
        JButton decreaseBtn = createIconButton("/view/icons/minus.png", 18, 18);
        decreaseBtn.setBounds(200, 35, 30, 30);
        itemPanel.add(decreaseBtn);
        
//      ACTION LISTENERS (+ / -)


//Increase quantity
      increaseBtn.addActionListener(e -> {
      int qty = Integer.parseInt(qtyLabel.getText());
      qty++;
      qtyLabel.setText(String.valueOf(qty));

      totalPrice += item.getPrice();
      totalLabel.setText("Total: " + totalPrice + " DA");
      });

//Decrease quantity
      decreaseBtn.addActionListener(e -> {
      int qty = Integer.parseInt(qtyLabel.getText());
      if (qty > 1) {  // prevent qty going to 0
      qty--;
      qtyLabel.setText(String.valueOf(qty));

      totalPrice -= item.getPrice();
      totalLabel.setText("Total: " + totalPrice + " DA");
      }
      });
        
        
        

        itemsPanel.add(itemPanel);
        yPosition += 90;

        totalPrice += item.getPrice();
        totalLabel.setText("Total: " + totalPrice + " DA");

        itemsPanel.setPreferredSize(new Dimension(330, yPosition));
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }


    public JPanel getPanel(){ return panel; }

    public Iterable<FoodItem> getCartItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
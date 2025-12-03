package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import java.awt.Image;

public class FoodItem {
    private String name;
    private double price;
    private String imagePath;
    private ImageIcon image;

    public FoodItem(String name, double price, String imagePath, int width, int height) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;

        ImageIcon original = new ImageIcon(getClass().getResource(imagePath));
        Image scaled = original.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(scaled);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public ImageIcon getImage() { return image; }
    
    // Crée un JLabel prêt à être ajouté dans un JPanel
    public JLabel getLabel() {
        JLabel label = new JLabel(image);
        label.setSize(image.getIconWidth(), image.getIconHeight());
        return label;
    }
}

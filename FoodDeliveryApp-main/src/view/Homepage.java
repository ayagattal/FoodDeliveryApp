package view;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.FoodItem;

public class Homepage {

    private JPanel panel;  
    public JButton orderButton;   //  controller will use this button

    public Homepage(MainFrame main) {

        panel = new JPanel();
        panel.setLayout(null); // manual positioning

        // Top red panel
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.decode("#BC1414"));
        redPanel.setBounds(0, 0, 350, 200);
        redPanel.setLayout(null); 

        
        FoodItem photo = new FoodItem("Pi", 1200, "/view/icons/image1.png", 90, 90);
        JLabel photoLabel = photo.getLabel(); // déjà prêt
        photoLabel.setBounds(119, 50, 90, 90);
        redPanel.add(photoLabel, BorderLayout.CENTER);
        //redPanel.add(photoLabel);

        //  White bottom panel
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 200, 350, 400);
        whitePanel.setLayout(new GridBagLayout()); 
        // GridBagLayout ==> centers inner content

        //  Inner text panel (vertical stack)
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("Welcome to Food Delivery App", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtitle
        JLabel subtitle = new JLabel("ENJOY YOUR FOOD!", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Order button
        orderButton = new JButton("ORDER NOW");
        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderButton.setFont(new Font("Arial", Font.BOLD, 14));
        orderButton.setBackground(Color.decode("#58A565"));
        orderButton.setForeground(Color.WHITE);
        orderButton.setFocusPainted(false);
        orderButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Add everything
        textPanel.add(title);
        textPanel.add(subtitle);
        textPanel.add(orderButton);

        whitePanel.add(textPanel);

        panel.add(whitePanel);
        panel.add(redPanel);
    }

    public JPanel getPanel() {
        return panel;
    }
}


































/*package view;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Homepage {
	 private JPanel panel;  // this is your screen
	 private MainFrame main;

	    public Homepage(MainFrame main) {//Homepage can call mainFrame.getCardLayout() or mainFrame.getMainPanel().
	        
	    	this.main = main;
	    	
	    	panel = new JPanel();
	        panel.setLayout(null); // manual positioning

	        JPanel redPanel = new JPanel();
	        redPanel.setBackground(Color.decode("#BC1414"));
	        redPanel.setBounds(0, 0, 350, 200); 
	        JPanel whitePanel = new JPanel();
	       whitePanel.setBackground(Color.WHITE);
	       whitePanel.setBounds(0, 200, 350, 400);

	     // White panel (the background box)
	        whitePanel.setLayout(new GridBagLayout()); // centers whatever you add inside it: vertically and horizontally :X Y

	        // Create an inner panel to hold the two labels
	        JPanel textPanel = new JPanel();
	        textPanel.setBackground(Color.WHITE);
	        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS)); // ya3ni We use BoxLayout with Y_AXIS so that components are stacked vertically — one on top of another.
	        // Title label
	        JLabel title = new JLabel("Welcome to Food Delivery App", SwingConstants.CENTER);//SwingConstants.CENTER → centers the text inside the label itself.
	        title.setFont(new Font("Arial", Font.BOLD, 18));
	        title.setAlignmentX(Component.CENTER_ALIGNMENT);//setAlignmentX(...) → tells BoxLayout to align the label horizontally in the center of the textPanel.

	        // Subtitle label
	        JLabel subtitle = new JLabel("ENJOY YOUR FOOD!", SwingConstants.CENTER);
	        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
	        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
	        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // ndirou espace bin labels

	      //button:
	        JButton ORDERButton = new JButton("ORDER NOW");
	        ORDERButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	        ORDERButton.setFont(new Font("Arial", Font.BOLD, 14));
	        ORDERButton.setBackground(Color.decode("#58A565"));
	        ORDERButton.setForeground(Color.WHITE);
	        ORDERButton.setFocusPainted(false);
	        ORDERButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // padding inside button
	        
	     // 🔹 Add action to switch page
	        ORDERButton.addActionListener(e -> {//when the button is clicked, do :
	            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "menu1");
	        });

	        // Add labels to the inner text panel
	        textPanel.add(title);
	        textPanel.add(subtitle);
	        textPanel.add(ORDERButton);

	        
	        // Add inner panel to white panel (centered automatically)
	        whitePanel.add(textPanel);
	     //  Add whitePanel to main red panel
	        panel.add(whitePanel);
	        panel.add(redPanel);
	       
	    }
	    public JPanel getPanel() {
	        return panel;
	    }
}*/

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FoodItem;

public class Menupage4 {

    private JPanel panel;
    private FoodItem[] items;
    // Buttons exposed for the controller
    public JButton backBtn;
    public JButton nextBtn;
    public JButton homeBtn;
    public JButton cartBtn;
    public JButton personBtn;
    public JButton[] addButtons;
    public Menupage4(MainFrame main) {

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(350, 600));
//titre
        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(10, 10, 250, 40);
        panel.add(title);
//grid of 6 items
        int[][] positions = {
             {80, 70}, {255, 70},
                 {80, 230}, {255, 230},
                 {80, 390}, {255, 390}
        };

        ImageIcon plusIcon = new ImageIcon(getClass().getResource("/view/icons/ajouter.png"));
        Image plusImg = plusIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon finalPlus = new ImageIcon(plusImg);
        
       // FoodItem items[] = {
            //  new FoodItem("chessecake",400, "/view/icons/chessecake.png", 75, 75),
          //    new FoodItem("strawbery Cake",400, "/view/icons/strawbery cake.png", 75, 75),
            //  new FoodItem("orange Cake",  400, "/view/icons/corange cake.png", 75, 75),
           //   new FoodItem("Lemon Cake", 400, "/view/icons/lemon cake.png", 75, 75),
            //  new FoodItem("Choclat Cake",400, "/view/icons/choclat cake.png", 75, 75),
            //  new FoodItem("vanillastrawbery cake", 400, "/view/icons/vanilla strawbery cake.png", 75, 75)
        //  };

        items = new FoodItem[] {
              new FoodItem("chessecake", 400, "/view/icons/chessecake.png", 75, 75),
              new FoodItem("strawbery cake",400, "/view/icons/strawbery cake.png", 75, 75),
              new FoodItem("orange cake",  400, "/view/icons/orange cake.png", 75, 75),
              new FoodItem("lemon cake",       400, "/view/icons/lemon cake.png", 75, 75),
              new FoodItem("choclat cake",    400, "/view/icons/choclat cake.png", 75, 75),
              new FoodItem("vanilla strawbery", 400, "/view/icons/vanilla strawbery cake.png", 75, 75)
          };
        addButtons = new JButton[items.length];


        for (int i = 0; i < positions.length; i++) {

            JPanel item = new JPanel();
            item.setBounds(positions[i][0], positions[i][1],150, 135);
            item.setLayout(null);
            panel.add(item);
            
            // Image
            JLabel imgLabel = new JLabel(items[i].getImage());
            imgLabel.setBounds(3, 0, 140, 140);
            item.add(imgLabel);

            // Nom
            JLabel nameLabel = new JLabel(items[i].getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 13));
            nameLabel.setBounds(10, 99, 100, 15);
            item.add(nameLabel);

            // Prix
            JLabel priceLabel = new JLabel(items[i].getPrice() + " DA");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            priceLabel.setBounds(10, 116, 80, 15);
            item.add(priceLabel);

            JButton addBtn = new JButton(finalPlus);
            addBtn.setBorderPainted(false);
            addBtn.setContentAreaFilled(false);
            addBtn.setFocusPainted(false);
            addBtn.setBounds(117, 100, 25, 25);

            item.add(addBtn);
            addButtons[i] = addBtn; 
        }//back button
        backBtn = new JButton("Go Back");
        backBtn.setBounds(100, 570, 110, 51);
        backBtn.setBackground(Color.decode("#BC1414"));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("Arial", Font.BOLD, 14));
        backBtn.setFocusPainted(false);
        panel.add(backBtn);

      //next button
        nextBtn = new JButton("Next");
        nextBtn.setBounds(260, 570, 110, 51);
        nextBtn.setBackground(Color.decode("#BC1414"));
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 14));
        nextBtn.setFocusPainted(false);
        panel.add(nextBtn);
//navbar
        JPanel navbar = new JPanel();
        navbar.setBounds(0, 642, 500, 80);
        navbar.setLayout(new GridLayout(1, 3));
        panel.add(navbar);

        // ICONS
        homeBtn = createIconButton("/view/icons/maison.png", 30, 30);
        cartBtn = createIconButton("/view/icons/panier.png", 30, 30);
        personBtn = createIconButton("/view/icons/utilisateur.png", 30, 30);
        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);
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

    public JPanel getPanel() {
        return panel;
    }
    public FoodItem[] getItems() {
        return items;
    }
}


/*package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menupage4 {

	private JPanel Menupagepanel;  // full screen
	 private MainFrame main;


    public Menupage4(MainFrame main) {
    	this.main = main;
    	
        Menupagepanel = new JPanel();
        Menupagepanel.setBackground(Color.WHITE);
        Menupagepanel.setLayout(null); 
        Menupagepanel.setPreferredSize(new Dimension(350, 600));


        // Title label
        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(10, 10, 250, 40);
        Menupagepanel.add(title);
        
        // POSITIONS of the 6 panels
           int[][] positions = {
               {40, 60},  {190, 60},
               {40, 190}, {190, 190},
               {40, 320}, {190, 320}
           };

           // Load + icon once
           ImageIcon plusIcon = new ImageIcon(getClass().getResource("/view/icons/ajouter.png"));
           Image plusImg = plusIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
           ImageIcon plusFinalIcon = new ImageIcon(plusImg);

           // Create the 6 items using a loop
           for (int i = 0; i < positions.length; i++) {

               JPanel item = new JPanel();
               item.setBounds(positions[i][0], positions[i][1], 110, 115);
               item.setLayout(null);
               // item.setBackground(Color.LIGHT_GRAY); // (debug, optional)
               Menupagepanel.add(item);

               // Create a (+) button
               JButton addBtn = new JButton(plusFinalIcon);
               addBtn.setBorderPainted(false);
               addBtn.setContentAreaFilled(false);
               addBtn.setFocusPainted(false);

               // Position bottom-right inside item panel
               addBtn.setBounds(80, 80, 25, 25);

               item.add(addBtn);
           }

        
        
      //button go back3:
        JButton goback4 = new JButton("Go Back");
        goback4.setBounds(40, 450, 100, 45);
       goback4.setBackground(Color.decode("#BC1414"));
        goback4.setFont(new Font("Arial", Font.BOLD, 14));
        goback4.setFocusPainted(false);
        Menupagepanel.add(goback4);
        
        // 🔹 Add action to switch page
	      goback4.addActionListener(e -> {//when the button is clicked, do :
	            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "menu3");
	        });

        //  button next4
           JButton Next4 = new JButton("Next");
           Next4.setBounds(200, 450, 100, 45);
           Next4.setBackground(Color.decode("#BC1414"));
           Next4.setFont(new Font("Arial", Font.BOLD, 14));
           Next4.setFocusPainted(false);
           Menupagepanel.add(Next4);
           // 🔹 Add action to switch page
   	       Next4.addActionListener(e -> {//when the button is clicked, do :
   	            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "cart");
   	        });

           // 🔹 Navbar panel (bottom bar)
              JPanel navbar = new JPanel();
              navbar.setBounds(0, 520, 350, 50); 
              navbar.setLayout(new GridLayout(1, 3)); // 3 icons horizontally
              Menupagepanel.add(navbar);
          
              

              

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
        return Menupagepanel;
    }
}
*/
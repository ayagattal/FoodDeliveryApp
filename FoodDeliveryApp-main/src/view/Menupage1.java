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

public class Menupage1 {

    private JPanel panel;
    public JPanel redpanel;

    // Navigation buttons
    public JButton pizzaBtn;
    public JButton burgerBtn;
    public JButton dessertBtn;

    // Navbar buttons
    public JButton homeBtn;
    public JButton cartBtn;
    public JButton personBtn;
    // food buttons items for cart
    public JButton[] addButtons;
    private FoodItem[] items;

    public FoodItem[] getItems() {
        return items;
    }

    public Menupage1(MainFrame main) {

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(500, 900));

        // title
        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(20, 10, 250, 40);
        panel.add(title);
//pizza
        pizzaBtn = new JButton();
        pizzaBtn.setBounds(58, 55, 75, 75);
        pizzaBtn.setBorderPainted(false);
        pizzaBtn.setFocusPainted(false);
        pizzaBtn.setContentAreaFilled(false);//enleve le font
        pizzaBtn.setOpaque(false);//rend transparent 
        panel.add(pizzaBtn);
//pizza label
        JLabel pizzaLabel = new JLabel("Pizza");
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 17));
        pizzaLabel.setBounds(70, 140, 140, 30);
        panel.add(pizzaLabel);
        FoodItem pizza = new FoodItem(
            "Pizza",
            1200,
           
            "/view/icons/menu11.jpg",
            80, 85   // largeur, hauteur
        );
        pizzaBtn.setIcon(pizza.getImage());
        //burger:
        burgerBtn = new JButton();
        burgerBtn.setBounds(205,55,75,75);
        burgerBtn.setBorderPainted(false);
        burgerBtn.setFocusPainted(false);
        burgerBtn.setContentAreaFilled(false); // enlève le fond
        burgerBtn.setOpaque(false);            // rend transparent 100%
        panel.add(burgerBtn);
     // Burger label
        JLabel burgerLabel = new JLabel("Burger");
        burgerLabel.setFont(new Font("Arial", Font.BOLD, 17));
        burgerLabel.setBounds(215, 147, 100, 20); 
        panel.add(burgerLabel);
        
        FoodItem  burger= new FoodItem(
            "Pi",
            1200,
          
            "/view/icons/Classic Burger.png",
            110, 100   // largeur, hauteur
        );
        burgerBtn.setIcon(burger.getImage());

        //desert:
        dessertBtn = new JButton();
        dessertBtn.setBounds(363,55,75,75);
        dessertBtn.setBorderPainted(false);
        dessertBtn.setFocusPainted(false);
        dessertBtn.setContentAreaFilled(false); // enlève le fond
        dessertBtn.setOpaque(false);            // rend transparent 100%
        panel.add(dessertBtn);
     // Dessert label
        JLabel dessertLabel = new JLabel("Dessert ");
        dessertLabel.setFont(new Font("Arial", Font.BOLD, 17));
        dessertLabel.setBounds(370, 148, 100, 20);
        panel.add(dessertLabel);
        
        FoodItem  desert= new FoodItem(
            "Pi",
            1200,
          
            "/view/icons/menu113.jpg",
            90, 90   // largeur, hauteur
        );
        dessertBtn.setIcon(desert.getImage());

        // rromo panel
        
        JLabel promo = new JLabel("Promotions");
        promo.setFont(new Font("Arial", Font.BOLD, 19));
        promo.setBounds(20, 202, 200, 30);
        panel.add(promo); redpanel = new JPanel();
        redpanel.setBackground(Color.decode("#BC1414"));
        redpanel.setLayout(null);
        redpanel.setBounds(20, 240, 440, 130);
        panel.add(redpanel);
        //
        JLabel promoTitle = new JLabel("Today's Offer");
        promoTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        promoTitle.setForeground(Color.black);
        promoTitle.setBounds(20, 10, 200, 30);  // x, y, width, height
        redpanel.add(promoTitle); 
        //
        JLabel promoText = new JLabel("Free Box Of Fries!");
        promoText.setFont(new Font("Arial", Font.BOLD, 16));
        promoText.setForeground(Color.black);
        promoText.setBounds(20, 44, 200, 30);  // x, y, width, height
        redpanel.add(promoText);
        
        //
        JLabel promodescription = new JLabel("On all orders Above 1800DA. ");
        promodescription.setFont(new Font("Arial", Font.PLAIN, 16));
        promodescription.setForeground(Color.black);
        promodescription.setBounds(20, 66, 240, 30);  // x, y, width, height
        redpanel.add(promodescription);
        //
        FoodItem promoPhoto = new FoodItem("Burger", 500, "/view/icons/fritefotor.png", 100, 100);
        JLabel promoPhotoLabel = promoPhoto.getLabel();
        promoPhotoLabel.setBounds(320, 20, 100, 80);
        redpanel.add(promoPhotoLabel);

        // 2 popular items
        JLabel popular = new JLabel("Popular");
        popular.setFont(new Font("Arial", Font.BOLD, 16));
        popular.setBounds(20, 380, 240, 60);
        panel.add(popular);

        int[][] positions = { {100, 455}, {250, 455} };

        ImageIcon plusIcon = new ImageIcon(getClass().getResource("/view/icons/ajouter.png"));
        Image plusImg = plusIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon finalPlus = new ImageIcon(plusImg);

        items = new FoodItem[] {
            new FoodItem("Smash Burger", 600, "/view/icons/smash Burger.png", 75, 75),
            new FoodItem("Italian Pizza", 1000, "/view/icons/italian pizza.png", 75, 75)
        };

        addButtons = new JButton[items.length];

        for (int i = 0; i < positions.length; i++) {
            JPanel itemPanel = new JPanel();
            itemPanel.setBounds(positions[i][0], positions[i][1], 130, 140);
            itemPanel.setLayout(null);
            panel.add(itemPanel);

            JLabel imgLabel = new JLabel(items[i].getImage());
            imgLabel.setBounds(25, 7, 75, 75);
            itemPanel.add(imgLabel);

            JLabel nameLabel = new JLabel(items[i].getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 13));
            nameLabel.setBounds(5, 85, 100, 15);
            itemPanel.add(nameLabel);

            JLabel priceLabel = new JLabel(items[i].getPrice() + " DA");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            priceLabel.setBounds(6, 110, 80, 15);
            itemPanel.add(priceLabel);

            JButton addBtn = new JButton(finalPlus);
            addBtn.setBorderPainted(false);
            addBtn.setContentAreaFilled(false);
            addBtn.setFocusPainted(false);
            addBtn.setBounds(90, 96, 25, 25);
            itemPanel.add(addBtn);

            addButtons[i] = addBtn;
        }

        // navbar
        JPanel navbar = new JPanel();
        navbar.setBounds(0, 642, 500, 80);
        navbar.setLayout(new GridLayout(1, 3));
        panel.add(navbar);

        homeBtn = createIconButton("/view/icons/maison.png", 15, 15);
        cartBtn = createIconButton("/view/icons/panier.png", 20, 20);
        personBtn = createIconButton("/view/icons/utilisateur.png", 20, 20);

        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);
    }private JButton createIconButton(String path, int w, int h) {
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FoodItem;

public class Menupage1 {

    private JPanel panel;
    public JPanel redpanel;

   
    public JButton pizzaBtn;
    public JButton burgerBtn;
    public JButton dessertBtn;
    public JButton homeBtn;
    public JButton cartBtn;
    public JButton personBtn;
    
 // Food buttons for controller
    public JButton[] addButtons;
    private FoodItem[] items;

    public FoodItem[] getItems() {
        return items;
    }

    public Menupage1(MainFrame main) {

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(350, 600));

        // TITLE
        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(20, 10, 250, 40);
        panel.add(title);
        //pizza:
        pizzaBtn = new JButton();
        pizzaBtn.setBounds(28,55,75,75);
        pizzaBtn.setBorderPainted(false);
        pizzaBtn.setFocusPainted(false);
        pizzaBtn.setContentAreaFilled(false); // enlève le fond
        pizzaBtn.setOpaque(false);            // rend transparent 100%
        panel.add(pizzaBtn);
        // Pizza label
         JLabel pizzaLabel = new JLabel("Pizza");
         pizzaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
         pizzaLabel.setBounds(50, 140, 100, 20); 
         panel.add(pizzaLabel);
         FoodItem pizza = new FoodItem(
        		    "Pizza",
        		    1200,
        		   
        		    "/view/icons/pizza.png",
        		    75, 75   // largeur, hauteur
        		);
        		pizzaBtn.setIcon(pizza.getImage());
        //burger:
        burgerBtn = new JButton();
        burgerBtn.setBounds(131,55,75,75);
        burgerBtn.setBorderPainted(false);
        burgerBtn.setFocusPainted(false);
        burgerBtn.setContentAreaFilled(false); // enlève le fond
        burgerBtn.setOpaque(false);            // rend transparent 100%
        panel.add(burgerBtn);
     // Burger label
        JLabel burgerLabel = new JLabel("Burger");
        burgerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        burgerLabel.setBounds(151, 140, 100, 20); 
        panel.add(burgerLabel);
        
        FoodItem  burger= new FoodItem(
    		    "Pi",
    		    1200,
    		  
    		    "/view/icons/Classic Burger.png",
    		    110, 110   // largeur, hauteur
    		);
    		burgerBtn.setIcon(burger.getImage());

        //desert:
        dessertBtn = new JButton();
        dessertBtn.setBounds(237,55,75,75);
        dessertBtn.setBorderPainted(false);
        dessertBtn.setFocusPainted(false);
        dessertBtn.setContentAreaFilled(false); // enlève le fond
        dessertBtn.setOpaque(false);            // rend transparent 100%
        panel.add(dessertBtn);
     // Dessert label
        JLabel dessertLabel = new JLabel("Dessert ");
        dessertLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dessertLabel.setBounds(255, 140, 100, 20);
        panel.add(dessertLabel);
        
        FoodItem  desert= new FoodItem(
    		    "Pi",
    		    1200,
    		  
    		    "/view/icons/desserttest.png",
    		    90, 90   // largeur, hauteur
    		);
    		dessertBtn.setIcon(desert.getImage());
        //promo
        JLabel promo = new JLabel("Promotions");
        promo.setFont(new Font("Arial", Font.BOLD, 16));
        promo.setBounds(20, 160, 200, 30);  
       promo.setText("");
        panel.add(promo);
        //panel promo:
        
        
        redpanel = new JPanel();
        redpanel.setBackground(Color.decode("#BC1414"));
        redpanel.setLayout(null);
        redpanel.setBounds(20, 200, 300, 110);
        panel.add(redpanel);
        
        
        //popular
        JLabel popular = new JLabel("Popular");
        popular.setFont(new Font("Arial", Font.BOLD, 16));
        popular.setBounds(20, 320, 200, 30);  
        panel.add(popular);
       

        // panels POPULAR:
        int[][] positions = {
                {40, 365},
                {190, 365},
        };

        ImageIcon plusIcon = new ImageIcon(getClass().getResource("/view/icons/ajouter.png"));
        Image plusImg = plusIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon finalPlus = new ImageIcon(plusImg);
        

        FoodItem items[] = {
        	    new FoodItem("smash Burger", 600, "/view/icons/smash Burger.png", 75, 75),
        	    new FoodItem("italian pizza",1000, "/view/icons/italian pizza.png", 75, 75),
        };
        for (int i = 0; i < positions.length; i++) {

            JPanel item = new JPanel();
            item.setBounds(positions[i][0], positions[i][1], 110, 115);
            item.setLayout(null);
            panel.add(item);
            
            // Image
            JLabel imgLabel = new JLabel(items[i].getImage());
            imgLabel.setBounds(15, 5, 75, 75);
            item.add(imgLabel);

            // Nom
            JLabel nameLabel = new JLabel(items[i].getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 11));
            nameLabel.setBounds(5, 80, 100, 15);
            item.add(nameLabel);

            // Prix
            JLabel priceLabel = new JLabel(items[i].getPrice() + " DA");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            priceLabel.setBounds(5, 95, 80, 15);
            item.add(priceLabel);

            JButton addBtn = new JButton(finalPlus);
            addBtn.setBorderPainted(false);
            addBtn.setContentAreaFilled(false);
            addBtn.setFocusPainted(false);
            addBtn.setBounds(80, 80, 25, 25);
            item.add(addBtn);
        }


        
        // NAVBAR
        JPanel navbar = new JPanel();
        navbar.setBounds(0, 520, 350, 50);
        navbar.setLayout(new GridLayout(1, 3));
        panel.add(navbar);

        //icons
        ImageIcon homeIcon = new ImageIcon(getClass().getResource("/view/icons/maison.png"));
        Image homeImg = homeIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        homeBtn = new JButton(new ImageIcon(homeImg));

        ImageIcon cartIcon = new ImageIcon(getClass().getResource("/view/icons/panier.png"));
        Image cartImg = cartIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        cartBtn = new JButton(new ImageIcon(cartImg));

        ImageIcon personIcon = new ImageIcon(getClass().getResource("/view/icons/utilisateur.png"));
        Image personImg = personIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        personBtn = new JButton(new ImageIcon(personImg));

        // REMOVE borders
        JButton[] buttons = { homeBtn, cartBtn, personBtn };
        for (JButton b : buttons) {
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
        }

        // ADD to navbar
        navbar.add(homeBtn);
        navbar.add(cartBtn);
        navbar.add(personBtn);
    }

    public JPanel getPanel() {
        return panel;
   
    }
}*/























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

public class Menupage1 {
	private JPanel Menupagepanel;  // full screen

    public Menupage1(MainFrame mainFrame) {
        
        Menupagepanel = new JPanel();
        Menupagepanel.setBackground(Color.WHITE);
        Menupagepanel.setLayout(null); 
        Menupagepanel.setPreferredSize(new Dimension(350, 600));


        // Title label
        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(10, 10, 250, 40);
        Menupagepanel.add(title);


        //  button
           JButton Next = new JButton("Next");
           Next.setBounds(80, 450, 180, 45);
           Next.setBackground(Color.decode("#BC1414"));
           Next.setFont(new Font("Arial", Font.BOLD, 14));
           Next.setFocusPainted(false);
           Menupagepanel.add(Next);
           // 🔹 Add action to switch page
	       Next.addActionListener(e -> {//when the button is clicked, do :
	            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "menu2");
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
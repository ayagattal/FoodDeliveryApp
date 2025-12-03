package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Appcontroller;

public class MainFrame {

    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Make pages PUBLIC so the controller can access their buttons
    public Homepage homepage;
    public Menupage1 menu1;
    public Menupage2 menu2;
    public Menupage3 menu3;
    public Menupage4 menu4;
    public Cartpage cartpage;
    public Checkoutpage checkoutpage;
    public Feedbackpage feedbackpage;
    
    //add login and signup
    public Loginpage loginpage;
    public Signuppage signuppage;

    public MainFrame() {

        frame = new JFrame("Food Delivery App");
        frame.setSize(350, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create pages (save in fields!)
        homepage = new Homepage(this);
        menu1 = new Menupage1(this);
        menu2 = new Menupage2(this);
        menu3 = new Menupage3(this);
        menu4 = new Menupage4(this);
        cartpage = new Cartpage(this);
        checkoutpage = new Checkoutpage(this);
        feedbackpage = new Feedbackpage(this);
        
//login and signup pages
        loginpage = new Loginpage(this);
        signuppage = new Signuppage(this);

        // Add panels
        mainPanel.add(homepage.getPanel(), "home");
        mainPanel.add(menu1.getPanel(), "menu1");
        mainPanel.add(menu2.getPanel(), "menu2");
        mainPanel.add(menu3.getPanel(), "menu3");
        mainPanel.add(menu4.getPanel(), "menu4");
        mainPanel.add(cartpage.getPanel(), "cart");
        mainPanel.add(checkoutpage.getPanel(), "checkout");
        mainPanel.add(feedbackpage.getPanel(), "feedback");
        
        mainPanel.add(loginpage.getPanel(), "login");
        mainPanel.add(signuppage.getPanel(), "signup");

        frame.add(mainPanel);
//starting from login
        cardLayout.show(mainPanel, "login"); 

        // Create controller AFTER pages are created
        new Appcontroller(this);

        frame.setVisible(true);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}










/*package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {

    private JFrame frame;
    private JPanel mainPanel;     // container for all pages
    private CardLayout cardLayout;

    public MainFrame() {

        frame = new JFrame("Food Delivery App");
        frame.setSize(350, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔹 1. Create the CardLayout
        cardLayout = new CardLayout();

        // 🔹 2. Create mainPanel and set CardLayout
        mainPanel = new JPanel(cardLayout);

        // 🔹 3. Create all pages
        Homepage homepage = new Homepage(this);
        Menupage1 menupage1 = new Menupage1(this);
        Menupage2 menupage2 = new Menupage2(this);
        Menupage3 menupage3 = new Menupage3(this);
        Menupage4 menupage4 = new Menupage4(this);
        Cartpage cartpage = new Cartpage(this);
        Checkoutpage checkoutpage = new Checkoutpage(this);
        Feedbackpage feedbackpage = new Feedbackpage(this);

        // 🔹 4. Add pages to mainPanel with IDs (names)
        mainPanel.add(homepage.getPanel(), "home");
        mainPanel.add(menupage1.getPanel(), "menu1");
        mainPanel.add(menupage2.getPanel(), "menu2");
        mainPanel.add(menupage3.getPanel(), "menu3");
        mainPanel.add(menupage4.getPanel(), "menu4");
        mainPanel.add(cartpage.getPanel(), "cart");
        mainPanel.add(checkoutpage.getPanel(), "checkout");
        mainPanel.add(feedbackpage.getPanel(), "feedback");

        // 🔹 5. Add mainPanel to frame
        frame.add(mainPanel);

        // 🔹 6. Show the home page first
        cardLayout.show(mainPanel, "home");

        frame.setVisible(true);
    }

    // Getter (for giving pages access to layout)
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}*/
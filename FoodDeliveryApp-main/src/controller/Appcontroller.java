package controller;

import view.*;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement; 
import java.sql.ResultSet; 

import javax.swing.JTextField;
import javax.swing.JOptionPane;

import model.FoodItem; 
import util.Database;

public class Appcontroller {

    private MainFrame main;
    // currentAuthId stores the ID of the authenticated user from the auth_users table.
    // It is used as the foreign key (user_id) for cart_items and orders.
    private int currentAuthId = 0; 

    public Appcontroller(MainFrame main) {
        this.main = main;
        setPlaceholders(); // Set placeholders for text fields
        addListeners();    // Add all action listeners
    }

    private void addListeners() {
        
        // --- AUTHENTICATION LISTENERS --- //
        
        // Switch from Login page to Signup page
        main.loginpage.switchToSignupBtn.addActionListener(e -> 
            main.getCardLayout().show(main.getMainPanel(), "signup")
        );
        
        // Switch from Signup page to Login page
        main.signuppage.switchToLoginBtn.addActionListener(e -> 
            main.getCardLayout().show(main.getMainPanel(), "login")
        );
        
        // Handle Signup logic
        main.signuppage.signupBtn.addActionListener(e -> handleSignup());
        
        // Handle Login logic
        main.loginpage.loginBtn.addActionListener(e -> handleLogin());


        //  HOMEPAGE  //
        main.homepage.orderButton.addActionListener(e ->
            main.getCardLayout().show(main.getMainPanel(), "menu1")
        );

        // MENU 1 Navigation listeners
        main.menu1.pizzaBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu2"));
        main.menu1.burgerBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu3"));
        main.menu1.dessertBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu4"));
        main.menu1.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.menu1.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.menu1.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));

        // MENU 2 Navigation listeners
        main.menu2.backBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.menu2.nextBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu3"));
        main.menu2.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.menu2.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.menu2.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));

        // MENU 3 Navigation listeners
        main.menu3.backBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu2"));
        main.menu3.nextBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu4"));
        main.menu3.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.menu3.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.menu3.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));

        // MENU 4 Navigation listeners
        main.menu4.backBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu3"));
        main.menu4.nextBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.menu4.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.menu4.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.menu4.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));

        // Cart page listeners
        main.cartpage.backBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu4"));
        main.cartpage.checkoutBtn.addActionListener(e -> {
            // Check if user is logged in
            if (currentAuthId == 0) {
                JOptionPane.showMessageDialog(main.cartpage.getPanel(), "You must login first to proceed to checkout.", "Login Required", JOptionPane.WARNING_MESSAGE);
                main.getCardLayout().show(main.getMainPanel(), "login");
            } else {
                main.getCardLayout().show(main.getMainPanel(), "checkout");
            }
        });
        main.cartpage.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.cartpage.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.cartpage.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));


        // Checkout page listeners
        main.checkoutpage.homeBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "menu1"));
        main.checkoutpage.cartBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "cart"));
        main.checkoutpage.personBtn.addActionListener(e -> main.getCardLayout().show(main.getMainPanel(), "checkout"));

        // Place Order validation and Database INSERT
        main.checkoutpage.placeOrderBtn.addActionListener(e -> {
            // Check if user is authenticated (essential for saving order)
            if (currentAuthId == 0) {
                JOptionPane.showMessageDialog(main.checkoutpage.getPanel(), "Please log in first!", "Error", JOptionPane.ERROR_MESSAGE);
                main.getCardLayout().show(main.getMainPanel(), "login");
                return;
            }
            
            if (isCheckoutValid()) {
                String fullName = main.checkoutpage.fullNameField.getText();
                String address  = main.checkoutpage.addressField.getText();
                String phone    = main.checkoutpage.numberField.getText();
                
                // INSERT new order/shipping details into the 'users' table
                try (Connection conn = Database.getConnection()) {
                    
                    // The users table is used here for storing shipping details associated with an order.
                    String sql = "INSERT INTO users (full_name, address, phone) VALUES (?, ?, ?)";
                    
                    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, fullName);
                    stmt.setString(2, address);
                    stmt.setString(3, phone);
                    stmt.executeUpdate();
                    
                    // If necessary, retrieve the generated Order ID here (omitted for brevity)
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(main.checkoutpage.getPanel(),
                                    "Error while saving the order to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                main.getCardLayout().show(main.getMainPanel(), "feedback");
            } else {
                JOptionPane.showMessageDialog(main.checkoutpage.getPanel(),
                                    "Please fill all order detail fields correctly!",
                                    "Missing Information",
                                    JOptionPane.WARNING_MESSAGE);
            }
        });

        // Feedback page listener
        main.feedbackpage.backBtn.addActionListener(e ->
            main.getCardLayout().show(main.getMainPanel(), "home")
        );
        
        // --- Listeners for adding items to the cart ---
        
        // menu1 items
        for (int i = 0; i < main.menu1.getItems().length; i++) {
            final int index = i;
            main.menu1.addButtons[i].addActionListener(e -> {
                FoodItem selectedItem = main.menu1.getItems()[index]; 
                main.cartpage.addItem(selectedItem);

                // Insert item into the database (cart_items table)
                try (Connection conn = Database.getConnection()) {
                    // FIX: Added user_id to satisfy the FOREIGN KEY constraint in the cart_items table
                    String sql = "INSERT INTO cart_items (user_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    // 1. Set the authenticated user ID
                    stmt.setInt(1, currentAuthId); 
                    
                    // 2. Set item details
                    stmt.setString(2, selectedItem.getName());
                    stmt.setInt(3, 1); // Initial quantity = 1
                    stmt.setDouble(4, selectedItem.getPrice());
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    // This catch block will now catch the error if currentAuthId is 0 and user_id is NOT NULL, 
                    // or if there's any other DB error (like connection failure).
                    ex.printStackTrace();
                }

                main.getCardLayout().show(main.getMainPanel(), "cart");
            });
        }

        // menu2 items
        for (int i = 0; i < main.menu2.getItems().length; i++) {
            final int index = i;
            main.menu2.addButtons[i].addActionListener(e -> {
                FoodItem selectedItem = main.menu2.getItems()[index];
                main.cartpage.addItem(selectedItem);

                try (Connection conn = Database.getConnection()) {
                    // FIX: Added user_id
                    String sql = "INSERT INTO cart_items (user_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    stmt.setInt(1, currentAuthId); 
                    
                    stmt.setString(2, selectedItem.getName());
                    stmt.setInt(3, 1);
                    stmt.setDouble(4, selectedItem.getPrice());
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                main.getCardLayout().show(main.getMainPanel(), "cart");
            });
        }

        // menu3 items
        for (int i = 0; i < main.menu3.getItems().length; i++) {
            final int index = i;
            main.menu3.addButtons[i].addActionListener(e -> {
                FoodItem selectedItem = main.menu3.getItems()[index];
                main.cartpage.addItem(selectedItem);

                try (Connection conn = Database.getConnection()) {
                    // FIX: Added user_id
                    String sql = "INSERT INTO cart_items (user_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    stmt.setInt(1, currentAuthId); 
                    
                    stmt.setString(2, selectedItem.getName());
                    stmt.setInt(3, 1);
                    stmt.setDouble(4, selectedItem.getPrice());
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                main.getCardLayout().show(main.getMainPanel(), "cart");
            });
        }

        // menu4 items
        for (int i = 0; i < main.menu4.getItems().length; i++) {
            final int index = i;
            main.menu4.addButtons[i].addActionListener(e -> {
                FoodItem selectedItem = main.menu4.getItems()[index];
                main.cartpage.addItem(selectedItem);

                try (Connection conn = Database.getConnection()) {
                    // FIX: Added user_id
                    String sql = "INSERT INTO cart_items (user_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    stmt.setInt(1, currentAuthId); 
                    
                    stmt.setString(2, selectedItem.getName());
                    stmt.setInt(3, 1);
                    stmt.setDouble(4, selectedItem.getPrice());
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                main.getCardLayout().show(main.getMainPanel(), "cart");
            });
        }
    }

    // --- AUTHENTICATION HANDLERS --- //
    
    private void handleSignup() {
        String username = main.signuppage.usernameField.getText().trim();
        String password = new String(main.signuppage.passwordField.getPassword());
        String confirmPassword = new String(main.signuppage.confirmPasswordField.getPassword());
        
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(main.signuppage.getPanel(), "Please fill all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(main.signuppage.getPanel(), "Passwords do not match.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Register in the database (auth_users table)
        if (Database.registerUser(username, password)) {
            JOptionPane.showMessageDialog(main.signuppage.getPanel(), "Signup successful, you can now login.", "Success", JOptionPane.INFORMATION_MESSAGE);
            main.getCardLayout().show(main.getMainPanel(), "login");
        } else {
            JOptionPane.showMessageDialog(main.signuppage.getPanel(), "This username already exists or an error occurred.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleLogin() {
        String username = main.loginpage.usernameField.getText().trim();
        String password = new String(main.loginpage.passwordField.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(main.loginpage.getPanel(), "Please fill up the form.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate login against the database (auth_users table)
        int authId = Database.validateLogin(username, password);
        
        if (authId > 0) {
            currentAuthId = authId; // Store the authentication ID
            JOptionPane.showMessageDialog(main.loginpage.getPanel(), "Signed in successfully. Welcome!", "Success", JOptionPane.INFORMATION_MESSAGE);
            main.getCardLayout().show(main.getMainPanel(), "home");
        } else {
            JOptionPane.showMessageDialog(main.loginpage.getPanel(), "Wrong username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Placeholders setup
    private void setPlaceholders() {
        setPlaceholder(main.checkoutpage.fullNameField, "Enter full name");
        setPlaceholder(main.checkoutpage.addressField, "Enter your address");
        setPlaceholder(main.checkoutpage.numberField, "Enter mobile number");
    }

    private void setPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }

    // Checkout field validation 
    private boolean isCheckoutValid() {
        JTextField fullName = main.checkoutpage.fullNameField;
        JTextField address  = main.checkoutpage.addressField;
        JTextField number   = main.checkoutpage.numberField;

        // Check full name validity (not empty and not placeholder)
        if (fullName.getText().isEmpty() || fullName.getForeground() == Color.GRAY)
            return false;

        // Check address validity (not empty and not placeholder)
        if (address.getText().isEmpty() || address.getForeground() == Color.GRAY)
            return false;

        // Check number validity (not empty and not placeholder)
        if (number.getText().isEmpty() || number.getForeground() == Color.GRAY)
            return false;

        return true;
    }
}
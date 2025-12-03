package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL Driver not found!");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // --- 1. Hashing Helper Method ---
    /**
     * Hashes the password using the SHA-256 algorithm.
     * @return The 64-character hexadecimal hash string, or null on error.
     */
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                // Convert the byte to a two-digit hexadecimal format
                sb.append(String.format("%02x", b)); 
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not available.");
            e.printStackTrace();
            return null;
        }
    }
    
    // --- 2. Registration Logic (Saves Hash) ---
    /**
     * Registers a new user into the auth_users table (with hashing).
     */
    public static boolean registerUser(String username, String password) {
        // Hash the password before storage
        String hashedPassword = hashPassword(password);
        if (hashedPassword == null) return false;
        
        String sql = "INSERT INTO auth_users (username, password_hash) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            // Store the HASH, not the plain password
            stmt.setString(2, hashedPassword); 
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException ex) {
            
            // Error Code 1062 = Duplicate entry (Username already exists)
            if (ex.getErrorCode() == 1062) { 
                 return false;
            }
            ex.printStackTrace();
            return false;
        }
    }
    
    // --- 3. Validation Logic (Compares Hash) ---
    /**
     * Validates user login credentials against the auth_users table.
     * @return The authentication ID (auth_id) if successful, 0 otherwise.
     */
    public static int validateLogin(String username, String password) {
        String sql = "SELECT id, password_hash FROM auth_users WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHashedPassword = rs.getString("password_hash");
                    int authId = rs.getInt("id"); 
                    
                    // Hash the entered password for comparison
                    String enteredHashedPassword = hashPassword(password);
                    
                    // Compare the entered HASH against the stored HASH
                    if (enteredHashedPassword != null && enteredHashedPassword.equals(storedHashedPassword)) {
                        return authId; 
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
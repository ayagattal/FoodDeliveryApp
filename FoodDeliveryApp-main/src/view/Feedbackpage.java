package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Feedbackpage {

    private JPanel panel;

    // Public button so controller can access it
    public JButton backBtn;

    public Feedbackpage(MainFrame main) {

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout()); // center panel

        //  panel (success box)
        JPanel boxPanel = new JPanel();
        boxPanel.setPreferredSize(new Dimension(300, 200));
        boxPanel.setLayout(new GridBagLayout());
        boxPanel.setBackground(Color.decode("#F5F5F5")); // optional light yellow

        // Inner content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.decode("#F5F5F5")); 

        // Title
        JLabel message = new JLabel("Success!", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 22));
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtitle
        JLabel subtitle = new JLabel("Your order was successful", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Back button
        backBtn = new JButton("Go Back");
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backBtn.setFont(new Font("Arial", Font.BOLD, 14));
        backBtn.setBackground(Color.decode("#BC1414"));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Add everything inside the content panel
        contentPanel.add(message);
        contentPanel.add(subtitle);
        contentPanel.add(backBtn);

        // Add content panel to yellow box
        boxPanel.add(contentPanel);

        // Add box to main page
        panel.add(boxPanel);
    }

    public JPanel getPanel() {
        return panel;
    }
}












/*package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

	public class Feedbackpage {
	    private JPanel feedpanel;  // full screen

	    public Feedbackpage(MainFrame mainFrame) {
	        // Main page 
	        feedpanel = new JPanel();
	        feedpanel.setBackground(Color.WHITE);
	        feedpanel.setLayout(new GridBagLayout()); // centers  panel

	        // Inner yellow panel
	        JPanel Panel = new JPanel();
	       
	        Panel.setPreferredSize(new Dimension(300, 200)); // fixed size
	        Panel.setLayout(new GridBagLayout()); // centers its content

	        //  Create an inner content panel for labels
	        JPanel contentPanel = new JPanel();
	       
	        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

	        // Title label
	        JLabel message = new JLabel("Success!", SwingConstants.CENTER);
	        message.setFont(new Font("Arial", Font.BOLD, 22));
	        message.setAlignmentX(Component.CENTER_ALIGNMENT);

	        // Subtitle label
	        JLabel subtitle = new JLabel("Your Order was successeful", SwingConstants.CENTER);
	        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
	        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
	        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//button:
	        JButton backButton = new JButton("Go Back");
	        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	        backButton.setFont(new Font("Arial", Font.BOLD, 14));
	        backButton.setBackground(Color.decode("#BC1414"));
	        backButton.setForeground(Color.WHITE);
	        backButton.setFocusPainted(false);
	        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // padding inside button
	     // Add action to switch page
		      backButton.addActionListener(e -> {//when the button is clicked, do :
		            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "home");
		        });
	        // Add labels to content panel
	        contentPanel.add(message);
	        contentPanel.add(subtitle);
	        contentPanel.add(backButton);

	        // Add contentPanel to yellowPanel (centered automatically)
	        Panel.add(contentPanel);

	        // Add yellow panel to the center of the main feedpanel
	        feedpanel.add(Panel);
	    }

	    public JPanel getPanel() {
	        return feedpanel;
	    }
	}
*/
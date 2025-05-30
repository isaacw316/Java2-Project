package com.bushnell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStockPanel extends JPanel {
    private JComboBox<String> skuBox;
    private JTextField descriptionField, priceField, stockField;
    private JButton saveButton;

    private Connection conn;

    public UpdateStockPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));
        connectToDatabase();

        add(new JLabel("Select SKU:"));
        skuBox = new JComboBox<>();
        loadSKUs();
        add(skuBox);

        add(new JLabel("Description:"));
        descriptionField = new JTextField();
        descriptionField.setEditable(false);
        add(descriptionField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Stock:"));
        stockField = new JTextField();
        add(stockField);

        saveButton = new JButton("Save Changes");
        add(saveButton);

        skuBox.addActionListener(e -> loadProductData((String) skuBox.getSelectedItem()));
        saveButton.addActionListener(e -> saveChanges());

        // Load initial product data
        if (skuBox.getItemCount() > 0) {
            loadProductData((String) skuBox.getSelectedItem());
        }
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:mrp.db");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void loadSKUs() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT sku FROM products")) {
            while (rs.next()) {
                skuBox.addItem(rs.getString("sku"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProductData(String sku) {
        try (PreparedStatement ps = conn.prepareStatement("SELECT description, price, stock FROM products WHERE sku = ?")) {
            ps.setString(1, sku);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                descriptionField.setText(rs.getString("description"));
                priceField.setText(String.valueOf(rs.getDouble("price")));
                stockField.setText(String.valueOf(rs.getInt("stock")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveChanges() {
        String sku = (String) skuBox.getSelectedItem();
        String priceStr = priceField.getText();
        String stockStr = stockField.getText();

        try (PreparedStatement ps = conn.prepareStatement("UPDATE products SET price = ?, stock = ? WHERE sku = ?")) {
            ps.setDouble(1, Double.parseDouble(priceStr));
            ps.setInt(2, Integer.parseInt(stockStr));
            ps.setString(3, sku);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Product updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No rows updated.");
            }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error updating: " + e.getMessage());
        }
    }
}

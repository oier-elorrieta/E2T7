package Konexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonexioaPrueba {
    private static final String URL = "jdbc:mysql://localhost:3306/prueba"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    private Connection konexioa; 


    public void conectar() {
        try {
            if (konexioa == null || konexioa.isClosed()) {
            	konexioa = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Datu-basera konektatua!");
            }
        } catch (SQLException e) {
            System.err.println("Errorrea Datu.basera konektatzen: " + e.getMessage());
        }
    }

 
    public Connection getConnection() {
        if (konexioa == null) {
            System.err.println("Konexioa es dago seteatuta");
        }
        return konexioa;
    }

   
    public void disconnect() {
        try {
            if (konexioa != null && !konexioa.isClosed()) {
            	konexioa.close();
                System.out.println("Konexioa itxita.");
            }
        } catch (SQLException e) {
            System.err.println("Errorea konexioa isten: " + e.getMessage());
        }
    }
    

    public boolean isConnected() {
        try {
            return konexioa != null && !konexioa.isClosed();
        } catch (SQLException e) {
            System.err.println("Errorea konexioa berifikatzen: " + e.getMessage());
            return false;
        }
    }
    
    }
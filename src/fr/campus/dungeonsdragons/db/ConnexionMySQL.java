package fr.campus.dungeonsdragons.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnexionMySQL {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try (InputStream input = ConnexionMySQL.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Fichier config.properties introuvable !");
                return;
            }
            props.load(input);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");
        }
    }
}


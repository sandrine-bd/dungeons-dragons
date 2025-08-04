package fr.campus.dungeonsdragons.db;

import java.sql.*;

public class ConnexionMySQL {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Character";
        String user = "javauser";
        String password = "Azerty123!!!";
        return DriverManager.getConnection(url, user, password);
    }

    // récupération du DAO
    public CharacterDAO getCharacterDAO() {
        return new CharacterDaoImplementation();
    }
}

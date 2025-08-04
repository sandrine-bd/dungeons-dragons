package fr.campus.dungeonsdragons.db;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.campus.dungeonsdragons.character.Character;
import fr.campus.dungeonsdragons.character.Warrior;
import fr.campus.dungeonsdragons.character.Wizard;
import fr.campus.dungeonsdragons.equipment.offensive.*;
import fr.campus.dungeonsdragons.equipment.defensive.*;

public class CharacterDaoImplementation implements CharacterDAO {
    Connection connection = null;
    private final Gson gson = new Gson();

    public CharacterDaoImplementation() {
        try {
            connection = new ConnexionMySQL().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int add(Character character) throws SQLException {
        String query = "INSERT INTO Character (type, name, lifePoints, strength, offensiveEquipment, defensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, character.getType());
        stmt.setString(2, character.getName());
        stmt.setInt(3, character.getLifePoints());
        stmt.setInt(4, character.getStrength());
        stmt.setString(5, gson.toJson(character.getOffensiveEquipment())); // utilise Gson pour sérialiser les équipements
        stmt.setString(6, gson.toJson(character.getDefensiveEquipment()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // retourne l'ID généré
        }
        return -1;
    }

    public void delete (int id) throws SQLException {
        String query = "DELETE FROM Character WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    @Override
    public Character getCharacter(int id) throws SQLException {
        String query = "SELECT * FROM Character WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int characterId = rs.getInt("Id");
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                int lifePoints = rs.getInt("LifePoints");
                int strength = rs.getInt("Strength");
                String offensiveEquipment = rs.getString("OffensiveEquipment");
                String defensiveEquipment = rs.getString("DefensiveEquipment");

                // désérialisatin avec Gson
                OffensiveEquipment offensive = gson.fromJson(offensiveEquipment, OffensiveEquipment.class);
                DefensiveEquipment defensive = gson.fromJson(defensiveEquipment, DefensiveEquipment.class);

                return type.equalsIgnoreCase("Warrior")
                        ? new Warrior(characterId, name, lifePoints, strength, offensive, defensive)
                        : new Wizard(characterId, name, lifePoints, strength, offensive, defensive);
            }
        } return null;
    }

    @Override
    public List<Character> getCharacters() throws SQLException {
        List<Character> list = new ArrayList<>();
        String query = "SELECT * FROM Character";

        try (Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query)) {
            while(result.next()) {
                int id = result.getInt("id");
                String type = result.getString("Type");
                String name = result.getString("Name");
                int life = result.getInt("LifePoints");
                int strength = result.getInt("Strength");
                String offensiveJson = result.getString("OffensiveEquipment");
                String defensiveJson = result.getString("DefensiveEquipment");
                // utilise Gson pour désérialiser
                OffensiveEquipment offensive = gson.fromJson(offensiveJson, OffensiveEquipment.class);
                DefensiveEquipment defensive = gson.fromJson(defensiveJson, DefensiveEquipment.class);

                Character c;
                if (type.equalsIgnoreCase("Warrior")) {
                    c = new Warrior(id, name, life, strength, offensive, defensive);
                } else if (type.equalsIgnoreCase("Wizard")) {
                    c = new Wizard(id, name, life, strength, offensive, defensive);
                } else {
                    throw new IllegalArgumentException("Unknown character type: " + type);
                }
                list.add(c);
            }
        } return list;
    }

    @Override
    public void update(Character character) throws SQLException {
        String query = "UPDATE Character SET Type = ?, Name = ?, LifePoints = ?, Strength = ?, OffensiveEquipment = ?, DefensiveEquipment = ? WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, character.getType());
        stmt.setString(2, character.getName());
        stmt.setInt(3, character.getLifePoints());
        stmt.setInt(4, character.getStrength());
        stmt.setString(5, gson.toJson(character.getOffensiveEquipment()));
        stmt.setString(6, gson.toJson(character.getDefensiveEquipment()));
        stmt.setInt(7, character.getId());
        
        stmt.executeUpdate();
    }

    public void changeLifePoints(Character character) throws SQLException {
        String query = "UPDATE Character SET LifePoints = ? WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, character.getLifePoints());
        stmt.setInt(2, character.getId());

        stmt.executeUpdate();
    }
}

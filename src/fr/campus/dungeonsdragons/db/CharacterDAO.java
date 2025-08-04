package fr.campus.dungeonsdragons.db;

import java.sql.SQLException;
import java.util.List;
import fr.campus.dungeonsdragons.character.Character;

public interface CharacterDAO {
    public int add(Character character) throws SQLException;
    public void delete (int id) throws SQLException;
    public Character getCharacter(int id) throws SQLException;
    public List<Character> getCharacters() throws SQLException;
    public void update(Character character) throws SQLException;
}

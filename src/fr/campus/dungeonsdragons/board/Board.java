package fr.campus.dungeonsdragons.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final Cell[] cells = new Cell[64];

    public Board() {
        // Remplissage vide par défaut
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new EmptyCell(i);
        }

        // Création d'une liste de positions possibles
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions); // mélange aléatoire

        int index = 0;
        index = setCells(positions, index, 4, DragonCell::new);
        index = setCells(positions, index, 10, SorcererCell::new);
        index = setCells(positions, index, 10, GoblinCell::new);
        index = setCells(positions, index, 5, ClubCell::new);
        index = setCells(positions, index, 4, SwordCell::new);
        index = setCells(positions, index, 5, LightningCell::new);
        index = setCells(positions, index, 2, FireballCell::new);
        index = setCells(positions, index, 6, SmallPotionCell::new);
        index = setCells(positions, index, 2, BigPotionCell::new);
    }

    private int setCells(List<Integer> positions, int startIndex, int count, CellFactory factory) {
        for (int i = 0; i < count; i++) {
            int pos = positions.get(startIndex + i);
            cells[pos] = factory.create(pos);
        }
        return startIndex + count;
    }

    public Cell getCell(int position) {
        if (position >= 0 && position < cells.length) {
            return cells[position];
        } else {
            throw new IllegalArgumentException("Invalid board position" + position);
        }
    }

    public int getSize() {
        return cells.length;
    }

    public void printBoard() {
        for (int i = 0; i < cells.length; i++) {
            System.out.print("Case " + i + " : " + cells[i]);
        }
    }

    // Interface fonctionnelle pour créer dynamiquement les cellules selon leur type
    @FunctionalInterface
    private interface CellFactory {
        Cell create(int position);
    }
}

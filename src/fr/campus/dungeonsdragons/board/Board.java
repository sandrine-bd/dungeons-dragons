package fr.campus.dungeonsdragons.board;

public class Board {
    private final Cell[] cells = new Cell[64];

    public Board() {
        // Remplissage vide par défaut
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new EmptyCell(i);
        }

        // Ennemis
        setCells(new int[]{45, 52, 56, 62}, DragonCell::new);
        setCells(new int[]{10, 20, 25, 32, 35, 36, 34, 40, 44, 47}, SorcererCell::new);
        setCells(new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30}, GoblinCell::new);

        // Armes - Sorts
        setCells(new int[]{2, 11, 5, 22, 38}, ClubCell::new);
        setCells(new int[]{19, 26, 42, 53}, SwordCell::new);
        setCells(new int[]{1, 4, 8, 17, 23}, LightningCell::new);
        setCells(new int[]{48, 49}, FireballCell::new);

        // Potions
        setCells(new int[]{7, 13, 31, 33, 39, 43}, SmallPotionCell::new);
        setCells(new int[]{28, 41}, BigPotionCell::new);
    }

    private void setCells(int[] positions, CellFactory factory) {
        for (int pos : positions) {
            if (pos >= 0 && pos < cells.length) {
                cells[pos] = factory.create(pos);
            }
        }
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

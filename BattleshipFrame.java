import javax.swing.*;

public class BattleshipFrame extends Battleship {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Battleship Game = new Battleship();
            Game.setVisible(true);
        });
    }
}


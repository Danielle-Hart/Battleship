import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends Battleship {
    private final Battleship Battle;
    private final JButton[][] cells = new JButton[10][10];

    public GameBoard(Battleship Battle) {
        this.Battle = Battle;
        setLayout(new GridLayout(10, 10));

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton cell = new JButton();
                cell.setBackground(Color.ORANGE);
                cell.addActionListener(new CellClickListener(row, col));
                cells[row][col] = cell;
                add(cell);
            }
        }
        ResetBattle();
    }
    public void ResetBattle() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col].setBackground(Color.ORANGE);
                cells[row][col].setEnabled(true);
            }
        }

    }
    public void ResetGame() {
    }
    private class CellClickListener implements ActionListener {
        private final int row;
        private final int col;

        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton cell = cells[row][col];
            boolean isHit = checkHit(row, col);

            if (isHit) {
                cell.setText("X");
                cell.setBackground(Color.RED);
            } else {
                cell.setText("M");
                cell.setBackground(Color.YELLOW);
            }
            cell.setEnabled(false);
            Battle.UpdateCounters(isHit);
        }

        private boolean checkHit(int row, int col) {
            return Math.random() < 0.2;
        }
    }
}

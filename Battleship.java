import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battleship extends GameMessage {
    private GameBoard GameBoard;
    private int MissCount = 0;
    private int StrikeCount = 0;
    private int TotalMissCount = 0;
    private int TotalHitCount = 0;

    private JLabel MissLabel;
    private JLabel StrikeLabel;
    private JLabel TotalMissLabel;
    private JLabel TotalHitLabel;
    private JButton PlayButton;
    private JButton QuitButton;

    public Battleship() {
        setTitle("Danielle's Battleship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLayout(new BorderLayout());

        GameBoard = new GameBoard(this);
        add(GameBoard, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel();
        MissLabel = new JLabel("Miss Counter: 0");
        StrikeLabel = new JLabel("Strike Counter: 0");
        TotalMissLabel = new JLabel("Total Miss Counter: 0");
        TotalHitLabel = new JLabel("Total Hit Counter: 0");
        statusPanel.add(MissLabel);
        statusPanel.add(StrikeLabel);
        statusPanel.add(TotalMissLabel);
        statusPanel.add(TotalHitLabel);

        PlayButton = new JButton("Play Again");
        PlayButton.addActionListener(e -> ResetGame());
        QuitButton = new JButton("Quit");
        QuitButton.addActionListener(e -> System.exit(0));

        statusPanel.add(PlayButton);
        statusPanel.add(QuitButton);

        add(statusPanel, BorderLayout.SOUTH);
    }
    public void UpdateCounters(boolean isHit) {
        if (isHit) {
            TotalHitCount++;
            MissCount = 0;
            if (TotalHitCount >= 10) {
                if (GameMessage.ShowWinMessage(this)) ResetGame();
            }
        } else {
            MissCount++;
            TotalMissCount++;
            if (MissCount >= 5) {
                StrikeCount++;
                MissCount = 0;
            }
            if (StrikeCount >= 3) {
                if (GameMessage.ShowLoseMessage(this)) ResetGame();
            }
        }
        UpdateLabels();
}
    public void ResetGame() {
        MissCount = 0;
        StrikeCount = 0;
        TotalMissCount = 0;
        TotalHitCount = 0;
        GameBoard.ResetGame();
        UpdateLabels();
    }
    public void UpdateLabels() {
        MissLabel.setText("Miss Counter: " + MissCount);
        StrikeLabel.setText("Strike Counter: " + StrikeCount);
        TotalMissLabel.setText("Total Miss Counter: " + TotalMissCount);
        TotalHitLabel.setText("Total Hit Counter: " + TotalHitCount);
    }
}
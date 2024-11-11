import javax.swing.*;

public class GameMessage {

    public static boolean ShowWinMessage(JFrame Parent) {
        JOptionPane.showMessageDialog(Parent, "Hooray! You've Won the Game!", "You Win!", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
    public static boolean ShowLoseMessage(JFrame Parent) {
        JOptionPane.showMessageDialog(Parent, "Sorry! You've Lost the Game. Try Again!", "You Lose!", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
    public static boolean ShowGameOverMessage(JFrame Parent) {
        int Result = JOptionPane.showConfirmDialog(Parent, "Do you want to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
        return Result == JOptionPane.YES_OPTION;
    }
}

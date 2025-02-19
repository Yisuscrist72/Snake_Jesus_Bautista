package main;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import game.GamePanel;
public class SnakeGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setResizable(false); // Hacer que la ventana no sea redimensionable
            frame.add(new GamePanel());
            frame.setVisible(true);
        });
    }
}
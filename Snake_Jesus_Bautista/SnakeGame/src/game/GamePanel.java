package game;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    private Snake snake;
    private Food food;
    private Timer timer;
    private int score;
    private boolean gameOver;

    public GamePanel() {
        this.snake = new Snake();
        this.food = new Food(800, 600);
        this.score = 0;
        this.gameOver = false;
        this.timer = new Timer(100, this);
        this.timer.start();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        snake.setDirection("UP");
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.setDirection("DOWN");
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.setDirection("LEFT");
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.setDirection("RIGHT");
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.drawString("Game Over! Score: " + score, 100, 100);
        } else {
            snake.draw(g);
            g.setColor(Color.RED);
            g.fillRect(food.getX(), food.getY(), 10, 10);
            g.drawString("Score: " + score, 10, 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            if (snake.checkCollision()) {
                gameOver = true;
            }
            if (snake.getX()[0] == food.getX() && snake.getY()[0] == food.getY()) {
                snake.grow();
                score++;
                food.generateRandomPosition(800, 600);
            }
            repaint();
        }
    }
}
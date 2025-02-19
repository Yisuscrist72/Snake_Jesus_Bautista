package game;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
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
    private JButton restartButton;
    private static final int TEXT_HEIGHT = 30; // Altura del área del texto
    private static final int TEXT_WIDTH = 50; // Ancho del área del texto
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    public GamePanel() {
        this.snake = new Snake();
        this.food = new Food(GAME_WIDTH, GAME_HEIGHT, TEXT_HEIGHT);
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
                        if (!snake.getDirection().equals("DOWN")) {
                            snake.setDirection("UP");
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!snake.getDirection().equals("UP")) {
                            snake.setDirection("DOWN");
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (!snake.getDirection().equals("RIGHT")) {
                            snake.setDirection("LEFT");
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!snake.getDirection().equals("LEFT")) {
                            snake.setDirection("RIGHT");
                        }
                        break;
                }
            }
        });

        // Crear el botón de reinicio
        restartButton = new JButton("Restart");
        restartButton.setBounds(GAME_WIDTH / 2 - 50, GAME_HEIGHT - 80, 100, 30); // Ajustar la posición del botón
        restartButton.setVisible(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        this.setLayout(null);
        this.add(restartButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el borde alrededor del área de juego
        g.setColor(Color.BLACK);
        g.drawRect(0, TEXT_HEIGHT, GAME_WIDTH, GAME_HEIGHT - TEXT_HEIGHT);

        // Dibujar el puntaje
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);

        if (gameOver) {
            g.drawString("Game Over! Score: " + score, 100, 100);
            restartButton.setVisible(true);
        } else {
            snake.draw(g);
            food.draw(g);
            restartButton.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            if (snake.checkCollision(GAME_WIDTH, GAME_HEIGHT, TEXT_HEIGHT)) {
                gameOver = true;
            }
            if (snake.getX()[0] == food.getX() && snake.getY()[0] == food.getY()) {
                snake.grow();
                score++;
                food.generateRandomPosition(GAME_WIDTH, GAME_HEIGHT, TEXT_HEIGHT);
            }
            repaint();
        }
    }

    private void restartGame() {
        snake = new Snake();
        food = new Food(GAME_WIDTH, GAME_HEIGHT, TEXT_HEIGHT);
        score = 0;
        gameOver = false;
        timer.start();
        repaint();
    }

    private boolean snakeTouchesText() {
        return snake.getY()[0] < TEXT_HEIGHT && snake.getX()[0] < TEXT_WIDTH;
    }

    private boolean snakeTouchesBorder() {
        return snake.getX()[0] < 0 || snake.getX()[0] >= GAME_WIDTH || snake.getY()[0] < TEXT_HEIGHT || snake.getY()[0] >= GAME_HEIGHT;
    }
}
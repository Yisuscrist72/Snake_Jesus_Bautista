package game;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements ActionListener {
    private Snake snake;
    private Food food;
    private Timer timer;
    private int score;
    private boolean gameOver;
    private static final int TEXT_HEIGHT = 50; // Altura del área del texto
    private static final int TEXT_WIDTH = 200; // Ancho del área del texto
    private JButton restartButton;
    private Image backgroundImage;

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

        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir botón de reinicio
        restartButton = new JButton("Reiniciar");
        restartButton.setBounds(350, 500, 100, 50); // Colocar el botón en la parte inferior
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        this.setLayout(null);
        this.add(restartButton);
        restartButton.setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 30); // Alinear el texto en la parte superior

        // Dibujar el borde alrededor del área de la puntuación
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, TEXT_WIDTH, TEXT_HEIGHT);

        if (gameOver) {
            g.drawString("Game Over", 300, 300); // Alinear el texto en la parte superior
            restartButton.setVisible(true);
        } else {
            snake.draw(g);
            g.drawImage(food.getImage(), food.getX(), food.getY(), 10, 10, this);
            restartButton.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            actualizarLogica();
            repaint();
        }
    }

    private void actualizarLogica() {
        snake.move();
        if (snake.checkCollision() || snakeTouchesText()) {
            gameOver = true;
        }
        if (snake.eat(food)) {
            score++;
            food.generateRandomPosition(800, 600, TEXT_HEIGHT, TEXT_WIDTH);
        }
    }

    private boolean snakeTouchesText() {
        return snake.getY()[0] < TEXT_HEIGHT && snake.getX()[0] < TEXT_WIDTH;
    }

    private void restartGame() {
        this.snake = new Snake();
        this.food = new Food(800, 600);
        this.score = 0;
        this.gameOver = false;
        this.timer.restart();
        repaint();
    }
}

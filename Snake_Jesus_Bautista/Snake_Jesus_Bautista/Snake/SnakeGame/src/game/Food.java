package game;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
    private int x;
    private int y;
    private final int SIZE = 10;

    public Food(int width, int height, int textHeight) {
        generateRandomPosition(width, height, textHeight);
    }

    public void generateRandomPosition(int width, int height, int textHeight) {
        do {
            x = (int) (Math.random() * ((width - SIZE) / SIZE)) * SIZE;
            y = (int) (Math.random() * ((height - textHeight - SIZE) / SIZE)) * SIZE + textHeight;
        } while (y < textHeight);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE);
    }
}
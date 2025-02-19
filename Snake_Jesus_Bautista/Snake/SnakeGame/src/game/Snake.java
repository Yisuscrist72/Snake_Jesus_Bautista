package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake {
    private int length;
    private int[] x;
    private int[] y;
    private String direction;
    private boolean isAlive;

    public Snake() {
        length = 3;
        x = new int[100];
        y = new int[100];
        x[0] = 50;
        y[0] = 50;
        direction = "RIGHT";
        isAlive = true;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void move() {
        for (int i = length - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case "UP":
                y[0] -= 10;
                break;
            case "DOWN":
                y[0] += 10;
                break;
            case "LEFT":
                x[0] -= 10;
                break;
            case "RIGHT":
                x[0] += 10;
                break;
        }
    }

    public boolean checkCollision(int gameWidth, int gameHeight, int textHeight) {
        // Check collision with itself
        for (int i = length - 1; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                isAlive = false;
                return true;
            }
        }
        // Check collision with borders
        if (x[0] < 0 || x[0] >= gameWidth || y[0] < textHeight || y[0] >= gameHeight) {
            isAlive = false;
            return true;
        }
        return false;
    }

    public void grow() {
        length++;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < length; i++) {
            g.fillRect(x[i], y[i], 10, 10);
        }
    }

    public boolean eat(Food food) {
        if (x[0] == food.getX() && y[0] == food.getY()) {
            grow();
            return true;
        }
        return false;
    }
}
package game;

import java.awt.Graphics;
import java.awt.Color;

public class Snake {
    private int length;
    private int[] x;
    private int[] y;
    private String direction;
    private boolean isAlive;

    public Snake() {
        length = 1;
        x = new int[100]; // Tamaño máximo de la serpiente
        y = new int[100];
        x[0] = 100; // Posición inicial
        y[0] = 100; // Posición inicial
        direction = "RIGHT"; // Dirección inicial
        isAlive = true;
    }

    public void move() {
        for (int i = length; i > 0; i--) {
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

    public void grow() {
        length++;
    }

    public void setDirection(String newDirection) {
        if ((newDirection.equals("UP") && !direction.equals("DOWN")) ||
            (newDirection.equals("DOWN") && !direction.equals("UP")) ||
            (newDirection.equals("LEFT") && !direction.equals("RIGHT")) ||
            (newDirection.equals("RIGHT") && !direction.equals("LEFT"))) {
            direction = newDirection;
        }
    }

    public boolean checkCollision() {
        // Colisión con las paredes
        if (x[0] < 0 || x[0] >= 800 || y[0] < 0 || y[0] >= 600) {
            isAlive = false;
        }
        // Colisión con sí misma
        for (int i = 1; i < length; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                isAlive = false;
            }
        }
        return !isAlive;
    }

    public int getLength() {
        return length;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
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
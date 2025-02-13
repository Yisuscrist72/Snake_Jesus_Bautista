package game;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Food {
    private int x;
    private int y;
    private Image image;

    public Food(int width, int height) {
        generateRandomPosition(width, height, 50, 200); // Altura y ancho del área del texto
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("manzana.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateRandomPosition(int width, int height, int textHeight, int textWidth) {
        do {
            x = (int) (Math.random() * (width / 10)) * 10;
            y = (int) (Math.random() * (height / 10)) * 10;
        } while (y < textHeight && x < textWidth);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
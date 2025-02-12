package game;

public class Food {
    private int x;
    private int y;

    public Food(int width, int height) {
        generateRandomPosition(width, height);
    }

    public void generateRandomPosition(int width, int height) {
        x = (int) (Math.random() * (width / 10)) * 10;
        y = (int) (Math.random() * (height / 10)) * 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
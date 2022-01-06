package modules;

public class Point {
    private final int x;
    private final int y;
    private String character;


    public Point(int x, int y, String character) {
        this.x = x;
        this.y = y;
        this.character = character;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCharacter() {
        return character;
    }
}

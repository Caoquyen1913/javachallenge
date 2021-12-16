package modules;

public class Rectangle implements IShape {
    private int x1, x2, y1, y2;
    String[][] canvas;

    public Rectangle(String[][] canvas, int x1, int y1, int x2, int y2) {
        this.canvas = canvas;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public String[][] draw() {
        if (isPointOverCanvas(x1, y1) && isPointOverCanvas(x2, y2)) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                canvas[i][x1] = "x";
                canvas[i][x2] = "x";
            }
            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                canvas[y1][j] = "x";
                canvas[y2][j] = "x";
            }
        }
        return canvas;
    }

    @Override
    public boolean isPointOverCanvas(int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }
}

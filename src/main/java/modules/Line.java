package modules;

public class Line implements IShape {
    private int x1, x2, y1, y2;
    String[][] canvas;
    final String lineCharacter = "x";
    public Line(String[][] canvas, int x1, int y1, int x2, int y2) {
        this.canvas = canvas;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public String[][] draw() {
        if (isPointOverCanvas(x1, y1) && isPointOverCanvas(x2, y2)) {
            if(isHorizontalLine(y1,y2)){
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                    canvas[y1][i] = lineCharacter;
                }
            }
            else if (isVerticalLine(x1,x2)){
                for (int i = Math.min(y1, y2); i <= (Math.max(y2, y1)); i++) {
                    canvas[i][x1] = lineCharacter;
                }
            }
        }
        return canvas;
    }

    public boolean isHorizontalLine( int y1, int y2) {
        return y1 == y2;
    }


    public boolean isVerticalLine(int x1, int x2) {
        return x1 == x2;
    }

    @Override
    public boolean isPointOverCanvas(int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }

}

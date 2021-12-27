package modules;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Canvas implements ICanvas {
    static int CANVAS_BORDER = 2;
    private String[][] canvas;

    @Override
    public String[][] buildCanvas(int w, int h) {
        canvas = new String[h + CANVAS_BORDER][w + CANVAS_BORDER];

        for (int i = 0; i < h + CANVAS_BORDER; i++) {
            for (int j = 0; j < w + CANVAS_BORDER; j++) {
                if (i == 0 || i == h + CANVAS_BORDER - 1) canvas[i][j] = "-";
                else if (j == 0 || j == w + CANVAS_BORDER - 1) canvas[i][j] = "|";
                else canvas[i][j] = " ";
            }
        }
        return canvas;
    }

    public void add(@NotNull IShape shape) {
        ArrayList<Point> shapeDrawer = shape.draw();
        Point startPoint = shape.getStartPoint();
        Point endPoint = shape.getEndPoint();
        if (isPointOverCanvas(startPoint) && isPointOverCanvas(endPoint)) {
            shapeDrawer.forEach(point -> {
                canvas[point.getX()][point.getY()] = point.getCharacter();
            });
        }
    }

    public void add(@NotNull Color color) {
        Point fillPoint = color.getFillPoint();
        if (isPointOverCanvas(fillPoint)) {
            ArrayList<Point> shapeDrawer = color.fillColor(canvas);
            shapeDrawer.forEach(point -> {
                canvas[point.getX()][point.getY()] = point.getCharacter();
            });
        }
    }

    public String[][] getCanvas() {
        return canvas;
    }

    @Override
    public void printCanvas() {
        for (String[] row : canvas) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    @Override
    public boolean checkCanvasEmpty() {
        return canvas.length == 0;
    }

    boolean isPointOverCanvas(Point point) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        int x = point.getX();
        int y = point.getY();
        return y < maxRow - 1 && y > 0 && x < maxCol && x > 0;
    }
}

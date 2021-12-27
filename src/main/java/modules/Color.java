package modules;

import java.util.ArrayList;
import java.util.Objects;

public class Color implements IColor {
    private final String c;
    private final Point fillPoint;
    static final private String lineCharacter = "x";
    static final private String horizontalLineBorderCharacter = "-";
    static final private String verticalBorderCharacter = "|";
    static final private int[] row = new int[]{0, 0, -1, 1};
    static final private int[] col = new int[]{-1, 1, 0, 0}; //left, right,up, down

    public Color(Point fillPoint, String c) {
        this.fillPoint = fillPoint;
        this.c = c;
    }

    public Point getFillPoint() {
        return fillPoint;
    }

    @Override
    public ArrayList<Point> fillColor(String[][] canvas) {
        Point colorPoint;
        int x = fillPoint.getX();
        int y = fillPoint.getY();
        ArrayList<Point> color = new ArrayList<>();
        if (isPointOverCanvas(canvas, x, y)) {
            ArrayList<int[]> listPoint = new ArrayList<>();
            listPoint.add(new int[]{y, x});
            int[] point = new int[]{y, x};

            while (listPoint.size() >= 1) {
                for (int i = 0; i < row.length; i++) {
                    int pointX = point[0] + row[i];
                    int pointY = point[1] + col[i];
                    if (checkExist(canvas[pointX][pointY])) {
                        fillPoint(canvas, pointX, pointY);
                        colorPoint = new Point(pointX, pointY, c);
                        color.add(colorPoint);
                        listPoint.add(new int[]{pointX, pointY});
                    }
                }
                listPoint.remove(0);
                if (listPoint.size() >= 1) {
                    int[] firstPoint = listPoint.get(0);
                    point = new int[]{firstPoint[0], firstPoint[1]};
                }
            }
        }
        return color;
    }

    void fillPoint(String[][] canvas, int x, int y) {
        canvas[x][y] = c;
    }

    boolean checkExist(String point) {
        return !isPointDuplicateBorder(point) && !isPointDuplicateColor(point) && !isPointDuplicate(point);
    }

    boolean isPointDuplicateBorder(String point) {
        return Objects.equals(point, horizontalLineBorderCharacter) || Objects.equals(point, verticalBorderCharacter);
    }

    boolean isPointDuplicateColor(String point) {
        return Objects.equals(point, c);
    }

    boolean isPointDuplicate(String point) {
        return Objects.equals(point, lineCharacter);
    }

    boolean isPointOverCanvas(String[][] canvas, int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }
}

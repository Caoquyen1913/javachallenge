package modules;

import java.util.ArrayList;
import java.util.Objects;

public class Color implements IColor {
    private final int x;
    private final int y;
    private static String c;
    private static String[][] canvas;
    static final private String lineCharacter = "x";
    static final private String horizontalLineBorderCharacter = "-";
    static final private String verticalBorderCharacter = "|";
    static final private int[] row = new int[]{0, 0, -1, 1};
    static final private int[] col = new int[]{-1, 1, 0, 0}; //left, right,up, down

    public Color(String[][] canvas, int x, int y, String c) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.canvas = canvas;
    }

    @Override
    public String[][] fillColor() {
        if (isPointOverCanvas(x, y)) {
            ArrayList<int[]> listPoint = new ArrayList<>();
            listPoint.add(new int[]{y, x});
            int[] point = new int[]{y, x};

            while (listPoint.size() >= 1) {
                for (int i = 0; i < row.length; i++) {
                    int pointX = point[0] + row[i];
                    int pointY = point[1] + col[i];
                    if (checkExist(canvas[pointX][pointY])) {
                        fillPoint(pointX, pointY);
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
        return canvas;
    }

    static void fillPoint(int x, int y) {
        canvas[x][y] = c;
    }

    public boolean checkExist(String point) {
        return !isPointDuplicateBorder(point) && !isPointDuplicateColor(point) && !isPointDuplicate(point);
    }

    public boolean isPointDuplicateBorder(String point) {
        return Objects.equals(point, horizontalLineBorderCharacter) || Objects.equals(point, verticalBorderCharacter);
    }

    public boolean isPointDuplicateColor(String point) {
        return Objects.equals(point, c);
    }

    public boolean isPointDuplicate(String point) {
        return Objects.equals(point, lineCharacter);
    }

    @Override
    public boolean isPointOverCanvas(int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }
}

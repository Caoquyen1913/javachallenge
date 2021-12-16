package modules;

import java.util.ArrayList;
import java.util.Objects;

public class Color implements IColor {
    private int x, y;
    private String c;
    private String[][] canvas;
    final private String lineCharacter = "x";
    final private String horizontalLineBorderCharacter = "-";
    final private String verticalBorderCharacter = "|";

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
                String leftPoint = canvas[point[0]][point[1] - 1];
                String rightPoint = canvas[point[0]][point[1] + 1];
                String upPoint = canvas[point[0] - 1][point[1]];
                String downPoint = canvas[point[0] + 1][point[1]];
                if (checkExist(leftPoint, c)) {
                    canvas[point[0]][point[1] - 1] = c;
                    listPoint.add(new int[]{point[0], point[1] - 1});
                }
                if (checkExist(rightPoint, c)) {
                    canvas[point[0]][point[1] + 1] = c;
                    listPoint.add(new int[]{point[0], point[1] + 1});
                }
                if (checkExist(upPoint, c)) {
                    canvas[point[0] - 1][point[1]] = c;
                    listPoint.add(new int[]{point[0] - 1, point[1]});
                }
                if (checkExist(downPoint, c)) {
                    canvas[point[0] + 1][point[1]] = c;
                    listPoint.add(new int[]{point[0] + 1, point[1]});
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

    public boolean checkExist(String point, String c) {
        if (Objects.equals(point, c) || Objects.equals(point, lineCharacter) || isPointDuplicate(point)) {
            return false;
        }
        return true;
    }

    public boolean isPointDuplicate(String point) {
        return Objects.equals(point, horizontalLineBorderCharacter) || Objects.equals(point, verticalBorderCharacter);
    }

    @Override
    public boolean isPointOverCanvas(int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }
}

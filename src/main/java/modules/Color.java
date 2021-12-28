package modules;

import java.util.ArrayList;

public class Color implements IColor {
    private final String c;
    private final Point fillPoint;
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
    public ArrayList<Point> fillColor(ArrayList<Point> listPointNotEmpty) {
        Point colorPoint;
        int x = fillPoint.getX();
        int y = fillPoint.getY();
        ArrayList<Point> color = new ArrayList<>();
        ArrayList<int[]> listPoint = new ArrayList<>();
        listPoint.add(new int[]{y, x});
        int[] point = new int[]{y, x};

        while (listPoint.size() >= 1) {
            for (int i = 0; i < row.length; i++) {
                int pointX = point[0] + row[i];
                int pointY = point[1] + col[i];
                System.out.println(checkExist(listPointNotEmpty, pointX, pointY));
                if (!checkExist(listPointNotEmpty, pointX, pointY)) {
                    colorPoint = new Point(pointX, pointY, c);
                    color.add(colorPoint);
                    listPointNotEmpty.add(new Point(pointX, pointY));
                    listPoint.add(new int[]{pointX, pointY});
                }
            }
            listPoint.remove(0);
            if (listPoint.size() >= 1) {
                int[] firstPoint = listPoint.get(0);
                point = new int[]{firstPoint[0], firstPoint[1]};
            }
        }
        return color;
    }


    boolean checkExist(ArrayList<Point> arr, int pointX, int pointY) {
        return arr.stream().anyMatch(element -> element.getX() == pointX && element.getY() == pointY);
    }

}

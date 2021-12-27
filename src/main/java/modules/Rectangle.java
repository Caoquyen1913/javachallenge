package modules;

import java.util.ArrayList;

public class Rectangle implements IShape {
    final String rectangleCharacter = "x";
    private final Point startPoint;
    private final Point endPoint;

    public Rectangle(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }


    @Override
    public ArrayList<Point> draw() {
        Point point;
        int x1 = startPoint.getX();
        int x2 = endPoint.getX();
        int y1 = startPoint.getY();
        int y2 = endPoint.getY();
        ArrayList<Point> rectangle = new ArrayList<>();
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                if (i == minY || j == minX || i == maxY || j == maxX) {
                    point = new Point(i, j, rectangleCharacter);
                    rectangle.add(point);
                }
            }
        }
        return rectangle;
    }

    boolean isPointOverCanvas(String[][] canvas, int x, int y) {
        int maxCol = canvas[0].length;
        int maxRow = canvas.length;
        return x < maxCol - 1 && x > 0 && y < maxRow && y > 0;
    }
}

package modules;

import java.util.ArrayList;

public class Line implements IShape {
    static final String LINE_CHARACTER = "x";
    private final Point startPoint;
    private final Point endPoint;

    public Line(Point startPoint, Point endPoint) {
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
        ArrayList<Point> line = new ArrayList<>();
        if (isHorizontalLine(y1, y2)) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                point = new Point(y1, i, LINE_CHARACTER);
                line.add(point);
            }
        } else if (isVerticalLine(x1, x2)) {
            for (int i = Math.min(y1, y2); i <= (Math.max(y2, y1)); i++) {
                point = new Point(i, x1, LINE_CHARACTER);
                line.add(point);
            }
        }
        return line;
    }

    boolean isHorizontalLine(int y1, int y2) {
        return y1 == y2;
    }


    boolean isVerticalLine(int x1, int x2) {
        return x1 == x2;
    }

}

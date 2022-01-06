package modules;

import java.util.ArrayList;

public interface IShape {
    ArrayList<Point> draw();
    Point getStartPoint();
    Point getEndPoint();
}

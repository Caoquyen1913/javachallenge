import modules.Line;
import modules.Point;
import modules.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.util.ArrayList;

public class RectangleTest {
    private final ArrayList<Point> arrayList = new ArrayList<>();

    Validator validator = new Validator();

    @BeforeEach
    public void init() {
        arrayList.add(new Point(1, 14, "x"));
        arrayList.add(new Point(1, 15, "x"));
        arrayList.add(new Point(1, 16, "x"));
        arrayList.add(new Point(1, 17, "x"));
        arrayList.add(new Point(1, 18, "x"));
        arrayList.add(new Point(2, 14, "x"));
        arrayList.add(new Point(2, 18, "x"));
        arrayList.add(new Point(3, 14, "x"));
        arrayList.add(new Point(3, 15, "x"));
        arrayList.add(new Point(3, 16, "x"));
        arrayList.add(new Point(3, 17, "x"));
        arrayList.add(new Point(3, 18, "x"));

    }


    @Test
    void draw() {
        Point point1 = new Point(14, 1);
        Point point2 = new Point(18, 3);
        Rectangle rectangle = new Rectangle(point1, point2);
        ArrayList<Point> result = rectangle.draw();
        validator.testEqualArray(arrayList, result);
    }
}

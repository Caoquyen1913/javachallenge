import modules.Line;
import modules.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import static org.junit.Assert.*;


public class LineTest {
    private final ArrayList<Point> arrayList = new ArrayList<>();

    Validator validator = new Validator();

    @BeforeEach
    public void init() {
        for (int i = 1; i <= 6; i++) {
            arrayList.add(new Point(2, i, "x"));
        }
    }

    @Test
    void checkHorizontalLine() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        Line line = new Line(point1, point2);
        ArrayList<Point> expectedResult = new ArrayList<>();
        ArrayList<Point> result = line.draw();
        validator.testEqualArray(expectedResult, result);
    }

    @Test
    void checkVerticalLine() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(6, 4);
        Line line = new Line(point1, point2);
        ArrayList<Point> expectedResult = new ArrayList<>();
        ArrayList<Point> result = line.draw();
        validator.testEqualArray(expectedResult, result);
    }

    @Test
    void draw() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(6, 2);
        Line line = new Line(point1, point2);
        ArrayList<Point> result = line.draw();
        validator.testEqualArray(arrayList, result);
    }
}

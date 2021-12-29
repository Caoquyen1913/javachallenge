import modules.Color;
import modules.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.util.ArrayList;

public class ColorTest {
//    private final String[][] newCanvasArr = {
//            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
//    };
//
//    private final String[][] newCanvasArrHasLine = {
//            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
//    };
//
    Validator validator = new Validator();

    @Test
    void fillColor() {
        ArrayList<Point> arr = new ArrayList<>();
        arr.add(new Point(0,0,"-"));
        arr.add(new Point(0,1,"-"));
        arr.add(new Point(0,2,"-"));
        arr.add(new Point(1,0,"|"));
        arr.add(new Point(1,2,"|"));
        arr.add(new Point(2,0,"-"));
        arr.add(new Point(2,1,"-"));
        arr.add(new Point(2,2,"-"));
        Point point = new Point(1,1);
        Color color = new Color(point, "o");
        ArrayList<Point> expectedResult = new ArrayList<>();
        expectedResult.add(new Point(1,1,"o"));
        ArrayList<Point> result = color.fillColor(arr);

        validator.testEqualArray(expectedResult, result);
    }

}

import modules.Canvas;
import modules.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class CanvasTest {
    Validator validator = new Validator();
    @Test
    void buildCanvas() {
        Canvas canvas = new Canvas();
        ArrayList<Point> row1 = new ArrayList<>();
        row1.add(new Point(0,0,"-"));
        row1.add(new Point(0,1,"-"));
        row1.add(new Point(0,2,"-"));
        ArrayList<Point> row2 = new ArrayList<>();
        row2.add(new Point(1,0,"|"));
        row2.add(new Point(1,1," "));
        row2.add(new Point(1,2,"|"));
        ArrayList<Point> row3 = new ArrayList<>();
        row3.add(new Point(2,0,"-"));
        row3.add(new Point(2,1,"-"));
        row3.add(new Point(2,2,"-"));
        ArrayList<ArrayList<Point>> expectedResult = new ArrayList<>();
        expectedResult.add(row1);
        expectedResult.add(row2);
        expectedResult.add(row3);
        ArrayList<ArrayList<Point>> result = canvas.buildCanvas(1, 1);
        validator.testEqualArray2D(expectedResult, result);
    }

    @Test
    void printCanvas() throws Exception {
        String expectedResult = """
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                                """;
        String result = tapSystemOut(() -> {
            Canvas canvas = new Canvas();
            canvas.buildCanvas(20,4);
            canvas.printCanvas();
        });
        Assertions.assertEquals(expectedResult,result);
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Validator;

public class LineTest {
    private final String[][] newCanvasArr = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" }
    };

    Validator validator = new Validator();

    @Test
    void checkPointOverCanvas(){
        int x1 = -1;
        int y1 = 2;
        int x2 = 6;
        int y2 = 2;
        Line line = new Line(newCanvasArr, x1, y1, x2, y2);
        Assertions.assertTrue(line.isPointOverCanvas(x1, y1));
        Assertions.assertFalse(line.isPointOverCanvas(x2, y2));
    }

    @Test
    void checkHorizontalLine(){
        int x1 = 1;
        int y1 = 2;
        int x2 = 6;
        int y2 = 2;
        Line line = new Line(newCanvasArr, x1, y1, x2, y2);
        Assertions.assertTrue(line.isHorizontalLine(x1, y1, x2, y2));
        x1 = 1;
        y1 = 2;
        x2 = 6;
        y2 = 3;
        Assertions.assertFalse(line.isHorizontalLine(x1, y1, x2, y2));
    }

    @Test
    void checkVerticalLine(){

        int x1 = 6;
        int y1 = 2;
        int x2 = 6;
        int y2 = 4;
        Line line = new Line(newCanvasArr, x1, y1, x2, y2);
        Assertions.assertTrue(line.isVerticalLine(x1, y1, x2, y2));
        x1 = 1;
        y1 = 2;
        x2 = 6;
        y2 = 3;
        Assertions.assertFalse(line.isVerticalLine(x1, y1, x2, y2));
    }

    @Test
    void draw(){
        String[][] expectedResult = {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", "x", "x", "x", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" }
        };
        Line line = new Line(newCanvasArr,1, 2,6,2);
        String[][] result = line.draw();
        validator.testEqualArray(expectedResult, result);
        line = new Line(newCanvasArr,1,2,6,3);
        result = line.draw();
        validator.testEqualArray(newCanvasArr,result);
    }
}

import modules.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Validator;

public class ColorTest {
    private final String[][] newCanvasArr = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
    };

    private final String[][] newCanvasArrHasLine = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
    };

    Validator validator = new Validator();

    @Test
    void fillColor() {
        String[][] expectedResult = {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "|"},
                {"|", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "|"},
                {"|", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "|"},
                {"|", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };
        Color color = new Color(newCanvasArr, 10, 3, "o");
        String[][] result = color.fillColor();
        validator.testEqualArray(expectedResult, result);
    }

    @Test
    void checkPointOverCanvas() {
        int x = -1;
        int y = 2;
        String c = "o";
        Color color = new Color(newCanvasArr, x, y, c);
        Assertions.assertTrue(color.isPointOverCanvas(x, y));
        x = 1;
        y = 2;
        Assertions.assertFalse(color.isPointOverCanvas(x, y));
    }

    @Test
    void checkPointDuplicateWithLineOrRectangle() {
        int x = 1;
        int y = 2;
        String c = "o";
        Color color = new Color(newCanvasArrHasLine, x, y, c);
        Assertions.assertTrue(color.isPointDuplicate("o"));
        x = 1;
        y = 2;
        Assertions.assertFalse(color.isPointDuplicate("o"));
    }
}

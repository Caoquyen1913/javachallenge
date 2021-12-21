import modules.Canvas;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class CanvasTest {
    private final String[][] newCanvasArr = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
    };

    void testEqualArray(String[][] expectedResult, String[][] result) {
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(Arrays.toString(expectedResult[i]), Arrays.toString(result[i]));
        }
    }

    @Test
    void buildCanvas() {
        Canvas canvas = new Canvas();
        String[][] expectedResult = {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };
        String[][] result = canvas.buildCanvas(20, 4);
        testEqualArray(expectedResult, result);
    }

    @Test
    void checkCanvasEmpty() {
        String[][] emptyArr = new String[][]{};
        Canvas canvas = new Canvas();
        Assertions.assertTrue(canvas.checkCanvasEmpty(emptyArr));
        Assertions.assertFalse(canvas.checkCanvasEmpty(newCanvasArr));
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

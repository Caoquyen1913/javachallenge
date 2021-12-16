import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CanvasTest {
    private final String[][] newCanvasArr = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" }
    };
    void testEqualArray(String[][] expectedResult, String[][] result) {
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(Arrays.toString(expectedResult[i]), Arrays.toString(result[i]));
        }
    }

    @Test
    void buildCanvas(){
        Canvas canvas = new Canvas();
        String[][] expectedResult = {
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" }
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


}

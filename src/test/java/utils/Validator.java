package utils;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class Validator {
    public void testEqualArray(String[][] expectedResult, String[][] result) {
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(Arrays.toString(expectedResult[i]), Arrays.toString(result[i]));
        }
    }
}

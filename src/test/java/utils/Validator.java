package utils;

import modules.Point;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class Validator {
    public void testEqualArray(ArrayList<Point> expectedResult, ArrayList<Point> result) {
        System.out.println(expectedResult.size());
        System.out.println(result.size());
        Assertions.assertEquals(expectedResult.size(),result.size());
        for (int i = 0; i < result.size(); i++) {
            Point resultCol = result.get(i);
            Point expectedResultCol = expectedResult.get(i);
            Assertions.assertSame(expectedResultCol.getClass(), resultCol.getClass());
            Assertions.assertEquals(expectedResultCol.getX(), resultCol.getX());
            Assertions.assertEquals(expectedResultCol.getY(), resultCol.getY());
            Assertions.assertEquals(expectedResultCol.getCharacter(), resultCol.getCharacter());
        }
    }

    public void testEqualArray2D(ArrayList<ArrayList<Point>> expectedResult, ArrayList<ArrayList<Point>> result) {

        Assertions.assertEquals(expectedResult.size(),result.size());

        for (int i = 0; i < result.size(); i++) {
            ArrayList<Point> resultRow = result.get(i);
            ArrayList<Point> expectedResultRow = expectedResult.get(i);
            Assertions.assertEquals(expectedResultRow.size(),resultRow.size());
            for (int j = 0; j < resultRow.size(); j++) {
                Point resultCol = resultRow.get(j);
                Point expectedResultCol = expectedResultRow.get(j);
                Assertions.assertSame(expectedResultCol.getClass(), resultCol.getClass());
                Assertions.assertEquals(expectedResultCol.getX(), resultCol.getX());
                Assertions.assertEquals(expectedResultCol.getY(), resultCol.getY());
                Assertions.assertEquals(expectedResultCol.getCharacter(), resultCol.getCharacter());
            }
        }
    }
}

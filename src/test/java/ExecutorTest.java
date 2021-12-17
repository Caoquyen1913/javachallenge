import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class ExecutorTest {

    @Test
    void executeLine() throws Exception {
        String expectedResult = """
                ----------------------
                |                    |
                |xxxxxx              |
                |                    |
                |                    |
                ----------------------
                                """;
        String input = """
                C 20 4
                L 1 2 6 2
                 q
                """;
        String result = tapSystemOut(() -> {
            Executor executor = new Executor();
            executor.exec(new Scanner(input));
        });
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void executeRectangle() throws Exception {
        String expectedResult = """
                ----------------------
                |             xxxxx  |
                |             x   x  |
                |             xxxxx  |
                |                    |
                ----------------------
                                """;
        String input = """
                C 20 4
                R 14 1 18 3
                 q
                """;
        String result = tapSystemOut(() -> {
            Executor executor = new Executor();
            executor.exec(new Scanner(input));
        });
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void executeColor() throws Exception {
        String expectedResult = """
                ----------------------
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                ----------------------
                                """;
        String input = """
                C 20 4
                B 10 3 o
                q
                 """;
        String result = tapSystemOut(() -> {
            Executor executor = new Executor();
            executor.exec(new Scanner(input));
        });
        Assertions.assertEquals(expectedResult, result);
    }

}

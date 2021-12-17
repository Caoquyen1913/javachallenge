import modules.Executor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class ExecutorTest {

    @Test
    void executeLine() throws Exception {
        String expectedResult = """
                enter: ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                enter: ----------------------
                |                    |
                |xxxxxx              |
                |                    |
                |                    |
                ----------------------
                enter:\s""";
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
                enter: ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                enter: ----------------------
                |             xxxxx  |
                |             x   x  |
                |             xxxxx  |
                |                    |
                ----------------------
                enter:\s""";
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
                enter: ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                enter: ----------------------
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                |oooooooooooooooooooo|
                ----------------------
                enter:\s""";
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

    @Test
    void checkNull() throws Exception{
        String expectedResult = """
                enter: enter:\s""";
        String input = """
                
                q
                 """;
        String result = tapSystemOut(() -> {
            Executor executor = new Executor();
            executor.exec(new Scanner(input));
        });
        Assertions.assertEquals(expectedResult, result);
    }
}

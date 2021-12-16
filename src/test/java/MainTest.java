import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    void main() throws Exception {
        String[] args = null;
        Main.main(args);
        String text = tapSystemOut(() -> {
            Main.main(args);
        });
        Assertions.assertEquals("Hello World", text.trim());
    }
}
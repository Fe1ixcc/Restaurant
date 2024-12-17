import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class basicMethodTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void testMenuPrint() {
        basicMethod.menuPrint();
        Assertions Assertions = null;

        Assertions.assertTrue(outContent.toString().contains("1. " + MenuItem.menu[0].getName()));
        Assertions.assertTrue(outContent.toString().contains(MenuItem.menu[0].getDescription()));
        Assertions.assertTrue(outContent.toString().contains(MenuItem.menu[0].getPrice() + "$"));
    }

    @Test
    public void interactiveSystemTest() {
        basicMethod.interactiveSystem();
    }
}
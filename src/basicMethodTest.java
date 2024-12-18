import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class basicMethodTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Scanner scanner;
    InputStream originalInput = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        ByteArrayInputStream textInput = new ByteArrayInputStream("3/n10/nyes/n".getBytes());
        System.setIn(textInput);
        scanner = new Scanner(System.in);
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
    public void testInteractiveSystem_PositiveNumber_Continue() {
        String input = "3\n10\nyes\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        basicMethod.interactiveSystem();
    }

    @Test
    public void testInteractiveSystem_NonPositiveNumber_Exit() {
        String input = "-5\nno\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        basicMethod.interactiveSystem();
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput);
        scanner.close();
        System.setOut(originalOut);
        outContent.reset();
    }
}
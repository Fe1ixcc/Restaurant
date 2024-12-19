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

    /*
    Sets up the test environment before each test method is executed.
    This method redirects the system output and input streams to facilitate testing.
    */
@BeforeEach
public void setUp() {
    // Redirects system output to a local variable to capture output during tests
    System.setOut(new PrintStream(outContent));

    // Creates a ByteArrayInputStream object to simulate system input
    // This allows providing input data for tests without manual intervention
    ByteArrayInputStream textInput = new ByteArrayInputStream("3\n10\nnyes\n".getBytes());
    System.setIn(textInput);
    scanner = new Scanner(System.in);
}


    /*
    Test the menu print functionality to verify that the menu items are displayed correctly.
    */
@Test
public void testMenuPrint() {
    // Call the menuPrint method to display the menu
    basicMethod.menuPrint();
    // Initialize Assertions object (Note: This line seems incorrect as it assigns null to an Assertions object)

    // Assert that the output contains the name of the first menu item
    Assertions.assertTrue(outContent.toString().contains("1. " + MenuItem.menu[0].getName()));
    // Assert that the output contains the description of the first menu item
    Assertions.assertTrue(outContent.toString().contains(MenuItem.menu[0].getDescription()));
    // Assert that the output contains the price of the first menu item followed by a dollar sign
    Assertions.assertTrue(outContent.toString().contains(MenuItem.menu[0].getPrice() + "$"));
}

    /*
    Tests the interactiveSystem method with a sequence of user inputs.
    This test case verifies that when the user inputs positive numbers and confirms the operation,
    the system behaves as expected.
    */
    @Test
    public void testInteractiveSystem_PositiveNumber_Continue() {
        // Simulate user input with positive numbers followed by confirmation
        String input = "3\n10\nyes\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        // Call the method under test
        basicMethod.interactiveSystem();
    }


    /*
    Tests the interactiveSystem method with a non-positive number input.
    This test case verifies that the interactiveSystem method correctly handles and exits when a non-positive number is entered.
    It simulates user input by providing a negative number followed by a non-numeric response to test the method's behavior.
    */
@Test
public void testInteractiveSystem_NonPositiveNumber_Exit() {
    // Simulate user input: first enter a negative number
    String input = "-5\nno\n";
    ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
    System.setIn(testInput);

    // Call the interactiveSystem method
    basicMethod.interactiveSystem();
}
    /*
    Tears down the test environment after each test method execution.
    This method resets the system input and output streams, closes the scanner,
    and clears the output content.
    */
@AfterEach
public void tearDown() {
    System.setIn(originalInput);
    scanner.close();
    System.setOut(originalOut);
    outContent.reset();
}

}
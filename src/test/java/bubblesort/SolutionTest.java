package bubblesort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private PrintStream systemOut;
    private Scanner scanner;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUpClass() {
        systemOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        out.reset();
        System.setOut(systemOut);
    }

    @Test
    void test1() {
        Solution.main("5 1 2 5 4 3".split(" "));
        scanner = new Scanner(out.toString());
        assertTrue(scanner.nextLine().endsWith("3 swaps."));
        assertTrue(scanner.nextLine().endsWith("1"));
        assertTrue(scanner.nextLine().endsWith("5"));
    }

}
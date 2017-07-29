package staircases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class SolutionTest {

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
        Solution.main("3 1 3 7".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.next(), is("1"));
        assertThat(scanner.next(), is("4"));
        assertThat(scanner.next(), is("44"));
    }

}
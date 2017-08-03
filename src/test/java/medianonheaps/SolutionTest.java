package medianonheaps;

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
        Solution.heap = new Solution.SortingHeap(100);
        Solution.main("6 12 4 5 3 8 7".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextDouble(), is(12d));
        assertThat(scanner.nextDouble(), is(8d));
        assertThat(scanner.nextDouble(), is(5d));
        assertThat(scanner.nextDouble(), is(4.5d));
        assertThat(scanner.nextDouble(), is(5d));
        assertThat(scanner.nextDouble(), is(6d));
    }

    @Test
    void test2() {
        Solution.heap = new Solution.MinsMaxsHeaps();
        Solution.main("6 12 4 5 3 8 7".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextDouble(), is(12d));
        assertThat(scanner.nextDouble(), is(8d));
        assertThat(scanner.nextDouble(), is(5d));
        assertThat(scanner.nextDouble(), is(4.5d));
        assertThat(scanner.nextDouble(), is(5d));
        assertThat(scanner.nextDouble(), is(6d));
    }
}
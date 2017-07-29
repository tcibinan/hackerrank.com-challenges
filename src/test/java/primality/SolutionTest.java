package primality;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
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
        Solution.main("3 12 5 7".split(" "));
        scanner = new Scanner(out.toString());
        assertNextIsNotPrime();
        assertNextIsPrime();
        assertNextIsPrime();
    }

    @Test
    void test2() {
        Solution.main("4 1 2 3 4".split(" "));
        scanner = new Scanner(out.toString());
        assertNextIsNotPrime();
        assertNextIsPrime();
        assertNextIsPrime();
        assertNextIsNotPrime();
    }

    private void assertNextIsPrime() {
        assertThat(scanner.next(), is("Prime"));
    }

    private void assertNextIsNotPrime() {
        assertThat(scanner.next(), is("Not"));
        assertThat(scanner.next(), is("prime"));
    }
}
package contacts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

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
    public void test1SetImpl() {
        Solution.contacts = new Solution.SetContacts();
        Solution.main("4 add hack add hackerrank find hac find hak".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextInt(), is(2));
        assertThat(scanner.nextInt(), is(0));
    }

    @Test
    public void test2SetImpl() {
        Solution.contacts = new Solution.SetContacts();
        Solution.main("4 add hack add hackerrank find hack find hak".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextInt(), is(2));
        assertThat(scanner.nextInt(), is(0));
    }

    @Test
    public void test3TreeImpl() {
        Solution.contacts = new Solution.TreeContacts();
        Solution.main("4 add hack add hackerrank find hac find hak".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextInt(), is(2));
        assertThat(scanner.nextInt(), is(0));
    }

    @Test
    public void test4TreeImpl() {
        Solution.contacts = new Solution.TreeContacts();
        Solution.main("4 add hack add hackerrank find hack find hak".split(" "));
        scanner = new Scanner(out.toString());
        assertThat(scanner.nextInt(), is(2));
        assertThat(scanner.nextInt(), is(0));
    }
}
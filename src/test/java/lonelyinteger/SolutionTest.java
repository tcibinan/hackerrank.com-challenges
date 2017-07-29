package lonelyinteger;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test1() {
        Solution.main("1 1".split(" "));
        assertThat(Solution.solution, is(1));
    }

    @Test
    void test2() {
        Solution.main("5 0 0 1 2 1".split(" "));
        assertThat(Solution.solution, is(2));
    }

    @Test
    void test3() {
        Solution.main("3 1 1 2".split(" "));
        assertThat(Solution.solution, is(2));
    }

    @Test
    void test4() {
        Solution.main("9 4 9 95 93 57 4 57 93 9".split(" "));
        assertThat(Solution.solution, is(95));
    }
}
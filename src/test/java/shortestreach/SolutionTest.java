package shortestreach;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        Solution.main("1 4 2 1 2 1 3 1".split(" "));
        assertThat(Solution.solution, is(new int[] {0, 6, 6, -1}));
    }

    @Test
    void test2() {
        Solution.main("1 3 1 2 3 2".split(" "));
        assertThat(Solution.solution, is(new int[] {-1, 0, 6}));
    }

    @Test
    void test3() {
        Solution.main("1 3 2 2 3 3 2 2".split(" "));
        assertThat(Solution.solution, is(new int[] {-1, 0, 6}));
    }
}
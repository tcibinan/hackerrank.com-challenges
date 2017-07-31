package cellsinagrid;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        Solution.main("4 4 1 1 0 0 0 1 1 0 0 0 1 0 1 0 0 0".split(" "));
        assertThat(Solution.solution, is(5));
    }

    @Test
    void test2() {
        Solution.main("4 4 0 1 0 0 1 1 0 1 0 0 0 1 0 1 1 1".split(" "));
        assertThat(Solution.solution, is(5));
    }
}
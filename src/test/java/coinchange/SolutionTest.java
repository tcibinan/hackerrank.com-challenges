package coinchange;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        Solution.main("4 3 1 2 3".split(" "));
        assertThat(Solution.solution, is(4l));
    }

    @Test
    void test2() {
        Solution.main("10 4 2 5 3 6".split(" "));
        assertThat(Solution.solution, is(5l));
    }

    @Test
    void test3() {
        Solution.main("2 2 1 2".split(" "));
        assertThat(Solution.solution, is(2l));
    }

    @Test
    void test4() {
        Solution.main("3 3 1 2 3".split(" "));
        assertThat(Solution.solution, is(3l));
    }

}
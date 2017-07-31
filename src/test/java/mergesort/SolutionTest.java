package mergesort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class SolutionTest {

    @Test
    void test1() {
        Solution.main("1 5 2 1 3 1 2".split(" "));
        assertThat(Solution.swapsCount, is(4l));
    }

    @Test
    void test2() {
        Solution.main("1 5 1 1 1 2 2".split(" "));
        assertThat(Solution.swapsCount, is(0l));
    }

    @Test
    void test3() {
        Solution.main("1 1 1".split(" "));
        assertThat(Solution.swapsCount, is(0l));
    }

}
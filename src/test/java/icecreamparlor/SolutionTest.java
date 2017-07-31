package icecreamparlor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    void test1() {
        Solution.main("1 4 5 1 4 5 3 2".split(" "));
        assertThat(Solution.iceCreamA, is(1));
        assertThat(Solution.iceCreamB, is(4));
    }

    @Test
    void test2() {
        Solution.main("1 4 4 2 2 4 3".split(" "));
        assertThat(Solution.iceCreamA, is(1));
        assertThat(Solution.iceCreamB, is(2));
    }

}
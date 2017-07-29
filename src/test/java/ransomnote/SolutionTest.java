package ransomnote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @BeforeEach
    void tearDown() {
        Solution.map = new HashMap<>();
        Solution.result = true;
    }

    @Test
    void test1() {
        String args = "6 4 " +
                "give me one grand today night " +
                "give one grand today";
        Solution.main(args.split(" "));
        assertTrue(Solution.result);
    }

    @Test
    void test2() {
        String args = "6 4 " +
                "give me one grand today night " +
                "give one grand tommorrow";
        Solution.main(args.split(" "));
        assertFalse(Solution.result);
    }

    @Test
    void test3() {
        String args = "6 5 " +
                "two times three is not four " +
                "two times two is four";
        Solution.main(args.split(" "));
        assertFalse(Solution.result);
    }
}
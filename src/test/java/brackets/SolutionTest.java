package brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @Test
    public void test1() {
        assertTrue(Solution.isBalanced("{[()]}"));
    }

    @Test
    public void test2() {
        assertFalse(Solution.isBalanced("{[(])}"));
    }

    @Test
    public void test3() {
        assertTrue(Solution.isBalanced("{{[[(())]]}}"));
    }
}
package medianonheaps;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        //12 8 5 4.5 5 6
        Solution.heap = new Solution.SortingHeap(100);
        Solution.main("6 12 4 5 3 8 7".split(" "));
    }

    @Test
    void test2() {
        //12 8 5 4.5 5 6
        Solution.heap = new Solution.MinsMaxsHeaps();
        Solution.main("6 12 4 5 3 8 7".split(" "));
    }
}
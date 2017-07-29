package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Solution.contacts = new Solution.SetContacts();
        Solution.main("4 add hack add hackerrank find hac find hak".split(" "));
    }

    @Test
    public void test2() {
        Solution.contacts = new Solution.SetContacts();
        Solution.main("4 add hack add hackerrank find hack find hak".split(" "));
    }

    @Test
    public void test3() {
        Solution.contacts = new Solution.TreeContacts();
        Solution.main("4 add hack add hackerrank find hac find hak".split(" "));
    }

    @Test
    public void test4() {
        Solution.contacts = new Solution.TreeContacts();
        Solution.main("4 add hack add hackerrank find hack find hak".split(" "));
    }
}
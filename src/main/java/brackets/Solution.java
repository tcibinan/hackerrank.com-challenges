package brackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Deque<Bracket> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            Bracket bracket = new Bracket(expression.charAt(i));
            if (!stack.isEmpty() && stack.peek().correlatesTo(bracket)) {
                stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }

    private static class Bracket {
        private char c;

        public Bracket(char c) {
            this.c = c;
        }

        public boolean correlatesTo(Bracket bracket) {
            return this.c == '{' && bracket.c == '}'
                    || this.c == '(' && bracket.c == ')'
                    || this.c == '[' && bracket.c == ']';
        }
    }
}

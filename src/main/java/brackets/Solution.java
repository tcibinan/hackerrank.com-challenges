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
            if (!stack.isEmpty()) {
                if (stack.peek().correlatesTo(bracket)) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
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

    static class Bracket {
        BracketType type;
        char c;

        public Bracket(char c) {
            this.c = c;
            this.type = BracketType.of(c);
        }

        public boolean correlatesTo(Bracket bracket) {
            if (this.type == bracket.type
                    && this.c == this.type.start
                    && bracket.c == this.type.end) {
                return true;
            }
            return false;
        }
    }

    enum BracketType {
        BRACKET1('(', ')'),
        BRACKET2('{', '}'),
        BRACKET3('[', ']');

        final char start;
        final char end;

        BracketType(char start, char end) {
            this.start = start;
            this.end = end;
        }

        static BracketType of(char c) {
            switch (c) {
                case '(':
                case ')':
                    return BRACKET1;
                case '{':
                case '}':
                    return BRACKET2;
                case '[':
                case ']':
                    return BRACKET3;
                default:
                    throw new RuntimeException("NOT BRACKET");
            }
        }
    }
}

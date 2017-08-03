package lonelyinteger;

import java.util.*;

public class Solution {

    static int solution;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        solution = calculate(a);
        System.out.println(solution);
    }

    private static int calculate(int[] a) {
        LonelyIntegerFinder lif = new LonelyIntegerFinder();
        Arrays.stream(a).forEach(lif::consume);

        return lif.getLonelyInteger();
    }

    private static class LonelyIntegerFinder {
        private final static int smallBitsSize = 50;
        private long smallBits = ~0;
        private long bigBits = ~0;

        public void consume(int num) {
            if (num > smallBitsSize) {
                int bit = num - smallBitsSize;
                bigBits ^= (long) 1 << bit;
            } else {
                smallBits ^= (long) 1 << num;
            }
        }

        public int getLonelyInteger() {
            smallBits = ~smallBits;
            bigBits = ~bigBits;

            if (smallBits != 0) {
                return getIntegerByMarkedBit(smallBits);
            } else {
                return getIntegerByMarkedBit(bigBits) + smallBitsSize;
            }
        }

        private int getIntegerByMarkedBit(long bits) {
            return Long.numberOfTrailingZeros(bits);
        }
    }
}


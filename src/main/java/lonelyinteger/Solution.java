package lonelyinteger;

import java.util.*;

public class Solution {

    static int solution;
    private static int smallBitsSize = 50;

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
        long smallBits = ~0;
        long bigBits = ~0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > smallBitsSize) {
                int bit = a[i] - smallBitsSize;
                bigBits ^= (long) 1 << bit;
            } else {
                smallBits ^= (long) 1 << a[i];
            }
        }

        smallBits = ~smallBits;
        bigBits = ~bigBits;

        if (smallBits != 0) {
            return getNum(smallBits);
        } else {
            return getNum(bigBits) + smallBitsSize;
        }
    }

    private static int getNum(long bits) {
        int num = 0;
        while (bits != 1) {
            bits >>= 1;
            num++;
        }
        return num;
    }
}


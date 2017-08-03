package staircases;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    private static int[] buff = new int[36];

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            Arrays.fill(buff, -1);
            int n = in.nextInt();
            System.out.println(getVariantsCount(n));
        }
    }

    private static int getVariantsCount(int n) {
        return countStairCasesVariants(0, n);
    }

    private static int countStairCasesVariants(int start, int finish) {
        if (start > finish) {
            return 0;
        }
        if (start == finish) {
            return 1;
        }

        if (buff[start] == -1) {
            buff[start] = 0;
            for (int i = 1; i < 4; i++) {
                buff[start] += countStairCasesVariants(start + i, finish);
            }
        }
        return buff[start];
    }
}

package icecreamparlor;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static int iceCreamA;
    static int iceCreamB;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            calculate(m, a);
            System.out.printf("%d %d%n", iceCreamA, iceCreamB);
        }
    }

    private static void calculate(int money, int[] costs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            map.put(costs[i], i);
        }

        for (int i = 0; i < costs.length; i++) {
            int diff = money - costs[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                int j = map.get(diff);
                iceCreamA = Math.min(i, j) + 1;
                iceCreamB = Math.max(i, j) + 1;
                return;
            }
        }

        throw new RuntimeException("No such pair of flavors");
    }
}

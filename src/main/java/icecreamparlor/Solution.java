package icecreamparlor;

import java.util.*;

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
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            if (map.containsKey(costs[i])) {
                map.get(costs[i]).add(i);
            } else {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(i);
                map.put(costs[i], value);
            }
        }

        for (int i = 0; i < costs.length; i++) {
            int diff = money - costs[i];
            if (map.containsKey(diff)) {
                List<Integer> list = map.get(diff);
                if (list.size() == 1 && !list.get(0).equals(i)) {
                    iceCreamA = i;
                    iceCreamB = list.get(0);
                    fixIceCreams();
                    return;
                } else if (list.size() > 1) {
                    iceCreamA = i;
                    if (list.get(0).equals(i)) {
                        iceCreamB = list.get(1);
                    } else {
                        iceCreamB = list.get(0);
                    }
                    fixIceCreams();
                    return;
                }
            }
        }

        throw new RuntimeException("No such pair of flavors");
    }

    private static void fixIceCreams() {
        if (iceCreamA > iceCreamB) {
            int temp = iceCreamA;
            iceCreamA = iceCreamB;
            iceCreamB = temp;
        }

        iceCreamA++;
        iceCreamB++;
    }
}

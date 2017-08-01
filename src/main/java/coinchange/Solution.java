package coinchange;

import java.util.*;

public class Solution {

    static long solution;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        solution = getCountOfCases(n, coins);

        System.out.println(solution);
    }

    private static long getCountOfCases(int n, int[] coins) {
        int[] dynamic = new int[n + 1];
        dynamic[0] = 1;

        Arrays.stream(coins)
                .forEach((coin) -> {
                    for (int sum = coin; sum < dynamic.length; sum++) {
                        dynamic[sum] += dynamic[sum - coin];
                    }
                });

        return dynamic[n];
    }


}
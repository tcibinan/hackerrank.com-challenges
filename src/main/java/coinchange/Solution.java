package coinchange;

import java.util.*;

public class Solution {

    static long solution;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }

        solution = getCountOfCases(n, coins);

        System.out.println(solution);
    }

    private static long getCountOfCases(int n, int[] coins) {
        Arrays.sort(coins);
        return getCountOfCasesRecursively(0, n, 0, coins);
    }

    private static long getCountOfCasesRecursively(int sum, int top, int coinIndex, int[] coins) {
        if (sum == top) {
            return 1;
        } else if (sum > top) {
            return 0;
        } else {
            int counts = 0;

            for (int i = coinIndex; i < coins.length; i++) {
                counts += getCountOfCasesRecursively(sum+coins[i], top, i, coins);
            }

            return counts;
        }
    }
}
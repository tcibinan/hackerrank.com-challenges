package bubblesort;

import java.util.Scanner;

public class Solution {

    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.join(" ", args));
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, j+1);
                    numberOfSwaps++;
                }
            }
            totalSwaps += numberOfSwaps;

            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.printf("Array is sorted on %d swaps.%n", totalSwaps);
        System.out.printf("First Element: %d%n", a[0]);
        System.out.printf("Last Element: %d", a[a.length-1]);
    }

    private static void swap(int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}

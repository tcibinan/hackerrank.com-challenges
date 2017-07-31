package mergesort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long swapsCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            swapsCount = 0;
            mergeSort(arr);
            System.out.println(swapsCount);
        }
    }

    private static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int start, int finish) {
        if (start >= finish) {
            return;
        }

        int middle = (start + finish) / 2;
        mergeSortRecursive(arr, temp, start, middle);
        mergeSortRecursive(arr, temp, middle+1, finish);
        merge(arr, temp, start, middle, finish);
    }

    private static void merge(int[] arr, int[] temp, int start, int middle, int finish) {
        int leftStart = start;
        int leftEnd = middle;
        int rightStart = middle+1;
        int rightEnd = finish;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
                swapsCount += leftEnd - left + 1;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }
}

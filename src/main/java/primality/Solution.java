package primality;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int halfN = (int) Math.sqrt(n);
        for (int i = 2; i <= halfN; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

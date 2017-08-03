package ransomnote;

import java.util.*;

public class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static boolean result = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();

            map.merge(magazine[magazine_i], 1, (a, b) -> a+1);
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();

            if (!isSuchWordInMagazine(ransom[ransom_i])) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "Yes" : "No");
    }

    private static boolean isSuchWordInMagazine(String key) {
        if (map.getOrDefault(key, 0) == 0) {
            return false;
        } else {
            map.compute(key, (s, i) -> i-1);
        }
        return true;
    }
}

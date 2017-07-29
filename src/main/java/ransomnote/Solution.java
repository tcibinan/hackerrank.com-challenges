package ransomnote;

import java.util.*;

public class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public static boolean result = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            map.merge(magazine[magazine_i], 1, (a, b) -> a+1);
        }
        System.out.println(map);
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            if (Optional.ofNullable(map.get(ransom[ransom_i])).orElse(0) == 0) {
                result = false;
                break;
            } else {
                map.merge(ransom[ransom_i], 1, (a, b) -> a-1);
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

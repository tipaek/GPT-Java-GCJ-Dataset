import java.util.*;
import java.util.Scanner;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k = 1; k <= num; k++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String arrays[] = new String[n];
            for(int i = 0; i < n; i++) {
                arrays[i] = scanner.nextLine();
            }
            System.out.println("Case #" + k + ": " + helper(arrays, n));
        }
    }

    static String helper(String arrays[], int m) {
        int ptrs[] = new int[m];
        int longestIndex = 0;
        int maxIndex = -1;
        for(int i = 0; i < m; i++) {
            ptrs[i] = arrays[i].length() - 1;
            if(ptrs[i] > maxIndex) {
                maxIndex = ptrs[i];
                longestIndex = i;
            }
        }

        String compare = arrays[longestIndex];
        while(ptrs[longestIndex] > 0) {
            char c = compare.charAt(ptrs[longestIndex]);
            for(int i = 0; i < m; i++) {
                if(i != longestIndex) {
                    String str = arrays[i];
                    char tmp = str.charAt(ptrs[i]);

                    if(tmp != '*') {
                        if(tmp != c) {
                            return "*";
                        }
                        ptrs[i]--;
                    }
                }

            }
            ptrs[longestIndex]--;
        }
        return compare.substring(1);
    }

}

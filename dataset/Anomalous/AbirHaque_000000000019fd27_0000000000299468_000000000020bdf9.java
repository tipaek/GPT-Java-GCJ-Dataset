import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            String[] possible = new String[n];
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                s[j] = in.nextInt();
                e[j] = in.nextInt();
            }

            int other = 1;
            for (int x = 0; x < n; x++) {
                if (x == n - 1) {
                    if (e[x] - s[0] > 0) {
                        possible[x] = (other % 2 == 1) ? "C" : "J";
                    } else {
                        possible[x] = (other % 2 == 1) ? "J" : "C";
                    }
                } else {
                    if (e[x] - s[x + 1] > 0) {
                        possible[x] = (other % 2 == 1) ? "J" : "C";
                    } else {
                        possible[x] = (other % 2 == 1) ? "C" : "J";
                    }
                }
                other++;
            }

            for (String p : possible) {
                result.append(p);
            }

            boolean isImpossible = false;
            for (int x = 0; x < n - 1; x++) {
                for (int r = x + 1; r < n; r++) {
                    if (s[x] < s[r] && e[x] > e[r]) {
                        isImpossible = true;
                        break;
                    }
                }
                if (isImpossible) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
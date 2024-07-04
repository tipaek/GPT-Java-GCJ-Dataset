import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int id = 1;
        while (t != 0) {
            t--;
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = sc.nextInt();
                }
            }
            int k = 0;
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> justForSize = new HashSet<>();
                Set<Integer> justForSizeClmn = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    justForSize.add(m[i][j]);
                    justForSizeClmn.add(m[j][i]);
                }
                if (justForSize.size() < n) {
                    r++;
                }
                if (justForSizeClmn.size() < n) {
                    c++;
                }
                k += m[i][i];
            }
            System.out.println("Case #" + id + ": " + k + " " + r + " " + c);
            id++;
        }
    }
}

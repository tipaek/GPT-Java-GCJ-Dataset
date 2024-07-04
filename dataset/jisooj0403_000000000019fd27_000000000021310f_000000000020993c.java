
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in.nextInt(), in, i + 1);
        }
    }

    static void solve(int len, Scanner in, int t) {
        int[][] mat = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        int k = 0, r = 0, c = 0;

        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    k += mat[i][j];
                }
                set.add(mat[i][j]);
            }
            if (set.size() != len) {
                r++;
            }
        }

        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                set.add(mat[j][i]);
            }
            if (set.size() != len) {
                c++;
            }
        }
        System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
    }
}
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = scan.nextInt();
            int x = 0;
            for (int i = 0; i < n; i++) x+=arr[i][i];
            int r = 0;
            for (int i = 0; i < n; i++) {
                set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(arr[i][j])) {
                        r++; break;
                    }
                    set.add(arr[i][j]);
                }
            }
            int c = 0;
            for (int j = 0; j < n; j++) {
                set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (set.contains(arr[i][j])) {
                        c++; break;
                    }
                    set.add(arr[i][j]);
                }
            }
            System.out.println("Case #" + t + ": " + x + " " + r + " " + c);
        }
    }
}
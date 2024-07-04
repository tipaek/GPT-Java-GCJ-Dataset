import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scn.nextInt();
    int no = 1;
    while (t-- > 0) {
        int n = scn.nextInt();
        int a[][] = new int[n][n];
        int sum = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; ++i) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                a[i][j] = scn.nextInt();
                if (i == j) {
                    sum += a[i][j];
                }
                set.add(a[i][j]);
            }
            if (set.size() != n) {
                r++;
            }
        }
        for (int i = 0; i < n; ++i) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                set.add(a[j][i]);
            }
            if (set.size() != n) {
                c++;
            }
        }
        System.out.println("Case #" + no + ": " + sum + " " + r + " " + c);
        no++;
    }
}
}

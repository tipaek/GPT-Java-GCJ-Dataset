import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] ar = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ar[j][k] = scanner.nextInt();
                }
            }

            int val = 0;
            for (int j = 0; j < n; j++) {
                val += ar[j][j];
            }

            int sum1 = 0;
            outer: for (int j = 0; j < n; j++) {
                HashSet<Integer> rep = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if(rep.contains(ar[j][k])) {
                        sum1++;
                        continue outer;
                    }
                    rep.add(ar[j][k]);
                }
            }

            int sum2 = 0;
            outer: for (int j = 0; j < n; j++) {
                HashSet<Integer> rep = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if(rep.contains(ar[k][j])) {
                        sum2++;
                        continue outer;
                    }
                    rep.add(ar[k][j]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + val + " " + sum1 + " " + sum2);
        }
    }
}

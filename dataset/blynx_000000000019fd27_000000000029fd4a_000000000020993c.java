import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] m = readInts(sc, n);
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += m[j][j];
            }
            Set<Integer> s = new TreeSet<>();
            int r = 0;
            int c = 0;
            for (int j = 0; j < n; j++) {
                s.clear();
                for (int k = 0; k < n; k++) {
                    s.add(m[j][k]);
                }
                if (s.size() < n) {
                    r++;
                }
            }
            for (int j = 0; j < n; j++) {
                s.clear();
                for (int k = 0; k < n; k++) {
                    s.add(m[k][j]);
                }
                if (s.size() < n) {
                    c++;
                }
            }
            print(i, sum, r, c);
        }
        sc.close();
    }

    private static int[][] readInts(Scanner sc, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = sc.nextInt();
            }
        }
        return result;
    }

    private static void print(int caseNum, int s, int r, int c) {
        System.out.println("Case #" + caseNum + ": " + s + " " + r + " " + c);
    }
}

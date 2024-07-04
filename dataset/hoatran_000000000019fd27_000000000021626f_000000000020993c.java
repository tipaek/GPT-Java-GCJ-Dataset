import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int a[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                }
            }
            findSolution(i, n, a);
        }
    }

    public static void findSolution(int index, int n, int[][] a) {
        int numberOfRows = 0;
        int numberOfColumns = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i][i];
            Set<Integer> r = new HashSet<>();
            Set<Integer> c = new HashSet<>();
            for (int j = 0; j < n; j++) {
                r.add(a[i][j]);
                c.add(a[j][i]);
            }
            if (r.size() < n) {
                numberOfRows++;
            }
            if (c.size() < n) {
                numberOfColumns++;
            }
        }

        System.out.println("Case #" + index + ": " + sum + " " + numberOfRows + " " + numberOfColumns);
    }
}

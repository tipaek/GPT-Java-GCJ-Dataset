import java.io.*;
import java.util.*;

public class Forgone {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] data = new int[n][n];
            int sum = 0;
            int rcount = 0;

            for (int j = 0; j < n; j++) {
                Set<Integer> row = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    data[j][k] = sc.nextInt();
                    if (!row.add(data[j][k])) {
                        rcount++;
                    }
                    if (j == k) {
                        sum += data[j][k];
                    }
                }
            }

            int ccount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> col = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!col.add(data[k][j])) {
                        ccount++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + sum + " " + rcount + " " + ccount);
        }
    }
}
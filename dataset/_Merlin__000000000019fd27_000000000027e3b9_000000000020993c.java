

import java.util.HashSet;
import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int incorrectRowsCount = 0, incorrectColumnsCount = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int g = 0; g < n; g++) {
                    a[j][g] = sc.nextInt();
                    hashSet.add(a[j][g]);
                }
                if (hashSet.size() != n) {
                    incorrectRowsCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int g = 0; g < n; g++) {
                    hashSet.add(a[g][j]);
                }
                if (hashSet.size() != n) {
                    incorrectColumnsCount++;
                }
            }


            int traceMatrics = 0;
            for (int j = 0; j < n; j++) {
                traceMatrics += a[j][j];
            }

            System.out.println("Case #" + (i + 1) + ": " + traceMatrics + " " + incorrectRowsCount + " " + incorrectColumnsCount);

        }

    }
}

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int k = getTrace(a);
            int r = getRepeatedRows(a);
            int c = getRepeatedColumns(a);
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
        sc.close();
    }

    public static int getTrace(int a[][]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    count += a[i][j];
                }
            }
        }
        return count;
    }

    public static int getRepeatedRows(int a[][]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < a.length; j++) {
                if (set.add(a[i][j]) == false) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int getRepeatedColumns(int a[][]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < a.length; j++) {
                if (set.add(a[j][i]) == false) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

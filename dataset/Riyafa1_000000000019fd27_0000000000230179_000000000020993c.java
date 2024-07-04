
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = sc.nextInt();
            int[][] mat = getMatrix(n, sc);
            System.out.print("Case #" + i+":");
            checkMatrix(n, mat);
        }
    }

    private static int[][] getMatrix(int n, Scanner sc) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        return a;
    }

    private static void checkMatrix(int n, int[][] a) {
        int trace = 0;
        int repeat = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            boolean repeatFount = false;
            for (int j = 0; j < n; j++) {
                int val = a[i][j];
                if (set.contains(val)) {
                    repeatFount = true;
                } else if (!repeatFount) {
                    set.add(val);
                }
                if (i == j) {
                    trace += val;
                }
            }
            if (repeatFount) {
                repeat++;
            }
        }
        System.out.print(" " + trace + " " + repeat);
        repeat = 0;
        for (int i = 0; i < a[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            boolean repeatFount = false;
            for (int j = 0; j < a.length; j++) {
                int val = a[j][i];
                if (set.contains(val)) {
                    repeatFount = true;
                    break;
                }
                set.add(val);
            }
            if (repeatFount) {
                repeat++;
            }
        }
        System.out.println(" " + repeat);
    }
}

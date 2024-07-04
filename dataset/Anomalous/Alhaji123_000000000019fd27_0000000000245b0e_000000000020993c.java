import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int size = sc.nextInt();
        int[][] mat = new int[size][size];

        int k = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
                if (i == j) k += mat[i][j];
            }
        }
        int r = getR(mat);
        int c = getC(mat);
        System.out.println("Case #" + (tn++) + ": " + k + " " + r + " " + c);
    }

    private static int getR(int[][] mat) {
        int r = 0;
        for (int i = 0; i < mat.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < mat[i].length; j++) {
                if (!rowSet.add(mat[i][j])) {
                    r++;
                    break;
                }
            }
        }
        return r;
    }

    private static int getC(int[][] mat) {
        int c = 0;
        for (int j = 0; j < mat[0].length; j++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int i = 0; i < mat.length; i++) {
                if (!colSet.add(mat[i][j])) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}
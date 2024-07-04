import java.util.HashSet;
import java.util.Scanner;

class Test {
    static int countIdenticalRows(int[][] mat, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (hs.contains(mat[i][j])) {
                    count++;
                    break;
                }
                hs.add(mat[i][j]);
            }
        }
        return count;
    }

    static int findTrace(int[][] mat, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    static void transpose(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int m = 0; m < t; m++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int trace = findTrace(mat, n);
            int rows = countIdenticalRows(mat, n);
            transpose(mat, n);
            int cols = countIdenticalRows(mat, n);
            System.out.println("Case #" + (m + 1) + ": " + trace + " " + rows + " " + cols);
        }
        sc.close();
    }
}
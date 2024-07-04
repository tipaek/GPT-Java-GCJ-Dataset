
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
public class Solution {

    static class Case {

        public int N;
        public int K;
    }

    public static void main(String[] args) {
        List<Case> cases = readCases();
        int i = 1;
        for (Case c : cases) {
            System.out.print("Case #" + (i++) + ": ");
            int[][] matrix = populateMatrix(findTrace(c));
            if (matrix != null) {
                System.out.println("POSSIBLE");
                printArray(matrix);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static List<Case> readCases() {
        List<Case> cases = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Case c = new Case();
            c.N = in.nextInt();
            c.K = in.nextInt();
            cases.add(c);
        }
        return cases;
    }

    static int[][] findTrace(Case c) {
        if (c.K < c.N || c.K > c.N * c.N) {
            return null;
        }
        int[][] matrix = new int[c.N][c.N];
        int remaining = c.K;
        int i = 0;
        while (i < c.N) {
            int s = findNumber(remaining, c.N, i);
            remaining -= s;
            matrix[i][i] = s;
            i++;
        }
        if (remaining != 0) {
            return null;
        }
        return matrix;
    }

    static int[][] populateMatrix(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != 0) {
                        continue;
                    }
                    int n = findNumber(matrix, i, j, true);
                    if (n < 0) {
                        return null;
                    }
                    matrix[i][j] = n;
                }
        }
        return matrix;
    }

    static int findNumber(int[][] matrix, int I, int J, boolean min2max) {
        int num = 1;
        if (!min2max) {
            num = matrix.length;
        }
        while (num <= matrix.length && num > 0) {
            final int n = num;
            boolean inRow = Arrays.stream(matrix[I]).anyMatch(x -> x == n);
            if (inRow) {
                if (min2max) {
                    num++;
                } else {
                    num--;
                }
                continue;
            }
            boolean inCol = false;
            for (int i = 0; i < matrix.length && !inCol; i++) {
                if (matrix[i][J] == n) {
                    inCol = true;
                }
            }
            if (!inCol && !inRow) {
                return n;
            }

            if (min2max) {
                num++;
            } else {
                num--;
            }
        }
        return -1;
    }

    static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                if (j + 1 != matrix.length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static int findNumber(int K, int N, int i) {
        int rem = K;
        int sel = N;
        while (!(rem - sel >= N - i - 1)) {
            sel--;
        }
        return sel;
    }

    static int[][] shuffle(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            if (matrix[i][i] == matrix[i + 1][i + 1]) {
                int t = matrix[i+1][i+1];
                matrix[i+1][i+1] = matrix[matrix.length-i-1][matrix.length-i-1];
                matrix[matrix.length-i-1][matrix.length-i-1] = t;
            }
        }
        return matrix;
    }

}

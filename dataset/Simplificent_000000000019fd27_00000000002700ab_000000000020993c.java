

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int mumCases = sc.nextInt();
        sc.nextLine();
        for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
            pw.print("Case #" + (caseNumber + 1) + ": ");
            solve(sc, pw);
            pw.println();
        }
        pw.println();
        pw.flush();
        pw.close();
        sc.close();
    }

    private static void solve(Scanner sc, PrintWriter pw) {
        final int N = sc.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // we need to determine k (the trace of the matrix),
        // r (the number of rows having duplicates) and
        // c (the number of columns having duplicates)
        int k = getTraceOf(matrix, N);
        int r = rowsWithDuplicatesIn(matrix, N);
        int c = columnsWithDuplicatesIn(matrix, N);

        pw.print(k + " " + r + " " +c);
    }

    private static int columnsWithDuplicatesIn(int[][] matrix, final int N) {
        int result = 0;
        for (int j = 0; j < N; j++) {
            Set<Integer> haveSeen = new HashSet<>();
            int dups = 0;
            for (int i = 0; i < N; i++) {
                int element = matrix[i][j];
                if (haveSeen.contains(element)) {
                    dups++;
                }
                haveSeen.add(element);
            }
            if (dups > 0) {
                result++;
            }
        }
        return result;
    }

    private static int rowsWithDuplicatesIn(int[][] matrix, final int N) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> haveSeen = new HashSet<>();
            int dups = 0;
            for (int j = 0; j < N; j++) {
                int element = matrix[i][j];
                if (haveSeen.contains(element)) {
                    dups++;
                }
                haveSeen.add(element);
            }
            if (dups > 0) {
                result++;
            }
        }
        return result;
    }



    private static int getTraceOf(int[][] matrix, final int N) {
        // The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += matrix[i][i];
        }
        return result;
    }


}

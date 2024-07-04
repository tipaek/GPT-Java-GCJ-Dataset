import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int rowRepeats = 0;
        int columnRepeats = 0;
        int diagonalSum = 0;
        int[][] matrix = new int[n][n];
        Set<Integer> uniqueSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            boolean rowHasDuplicate = false;
            uniqueSet.clear();

            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (!rowHasDuplicate && !uniqueSet.add(matrix[i][j])) {
                    rowRepeats++;
                    rowHasDuplicate = true;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            uniqueSet.clear();
            for (int i = 0; i < n; i++) {
                if (!uniqueSet.add(matrix[i][j])) {
                    columnRepeats++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }

        System.out.print(diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }
}
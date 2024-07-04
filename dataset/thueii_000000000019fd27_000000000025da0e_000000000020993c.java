import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int i = 1; i <= nCases; ++i) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    int value = scanner.nextInt();
                    matrix[j][k] = value;
                }
            }
            long trace = 0;
            for (int j = 0; j < n; ++j) {
                trace += matrix[j][j];
            }
            int nRowsW = 0;
            for (int j = 0; j < n; ++j) {
                boolean isW = false;
                BitSet marked = new BitSet(n);
                for (int k = 0; k < n; ++k) {
                    if (marked.get(matrix[j][k] - 1)) {
                        isW = true;
                        break;
                    }
                    marked.set(matrix[j][k] - 1);
                }
                if (isW) {
                    ++nRowsW;
                }
            }
            int nColumnsW = 0;
            for (int k = 0; k < n; ++k) {
                boolean isW = false;
                BitSet marked = new BitSet(n);
                for (int j = 0; j < n; ++j) {
                    if (marked.get(matrix[j][k] - 1)) {
                        isW = true;
                        break;
                    }
                    marked.set(matrix[j][k] - 1);
                }
                if (isW) {
                    ++nColumnsW;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", i, trace, nRowsW, nColumnsW));
        }
    }

}

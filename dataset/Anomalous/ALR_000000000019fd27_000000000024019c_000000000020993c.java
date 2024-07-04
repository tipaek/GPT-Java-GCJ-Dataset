import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Input {
        int N;
        int[][] matrix;

        public Input(int n, int[][] matrix) {
            this.N = n;
            this.matrix = matrix;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(new File("./data/data1.in"));

        int T = scan.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            Input input = readInput(scan);
            String solution = solve(input);
            System.out.println("Case #" + ks + ": " + solution);
        }
    }

    private static String solve(Input input) {
        int sum = 0;
        int n = input.N;

        // Calculate the trace of the matrix
        for (int i = 0; i < n; i++) {
            sum += input.matrix[i][i];
        }

        int rowDuplicates = 0;
        // Check for duplicate values in each row
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(input.matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        int colDuplicates = 0;
        // Check for duplicate values in each column
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(input.matrix[i][j])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return sum + " " + rowDuplicates + " " + colDuplicates;
    }

    private static Input readInput(Scanner scan) {
        int N = scan.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        return new Input(N, matrix);
    }
}
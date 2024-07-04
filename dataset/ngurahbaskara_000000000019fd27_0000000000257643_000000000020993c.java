import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int[][][] cases = new int[T][][];
        for (int i = 0; i < T; i++) {
            cases[i] = getMatrix(scanner);
        }

        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(cases[i]);
            System.out.println();
        }
    }

    private static void solve(int[][] matrix) {
        int k = getTrace(matrix);
        System.out.print(k);
        int r = countRepeatedRow(matrix);
        System.out.print(" " + r);
        int c = countRepeatedCol(matrix);
        System.out.print(" " + c);
    }

    private static int countRepeatedCol(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            boolean repeated = false;
            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = j + 1; k < matrix.length ; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        repeated = true;
                        break;
                    }
                }
                if (repeated) {
                    break;
                }
            }
            if (repeated) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedRow(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            boolean repeated = false;
            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = j + 1; k < matrix.length ; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        repeated = true;
                        break;
                    }
                }
                if (repeated) {
                    break;
                }
            }
            if (repeated) {
                count++;
            }
        }
        return count;
    }

    private static int getTrace(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count += matrix[i][i];
        }
        return count;
    }

    private static int[][] getMatrix(Scanner scanner) {
        int N = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            String[] rowData = scanner.nextLine().split(" ");
            int[] row = new int[rowData.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = Integer.valueOf(rowData[i]);
            }
            matrix[r] =  row;
        }
        return matrix;
    }

}

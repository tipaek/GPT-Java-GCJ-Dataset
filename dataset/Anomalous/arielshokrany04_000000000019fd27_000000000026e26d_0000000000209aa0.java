import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static int[][] matrix;
    public static String result;
    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCases; ++i) {
            String[] params = input.nextLine().split(" ");
            int N = Integer.parseInt(params[0]);
            int K = Integer.parseInt(params[1]);
            matrix = new int[N][N];
            output.append(solve(i, K, N)).append("\n");
        }

        System.out.println(output.toString());
    }

    public static String solve(int caseNum, int K, int N) {
        int sum = 0;
        StringBuilder matrixBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sum += K / N;
        }

        if (sum != K) {
            return "Case #" + caseNum + ": IMPOSSIBLE";
        }

        int k = N;
        for (int i = 1; i <= N; i++) {
            int temp = k;
            while (temp <= N) {
                matrixBuilder.append(temp).append(" ");
                temp++;
            }
            for (int j = 1; j < k; j++) {
                matrixBuilder.append(j).append(" ");
            }
            k--;
            matrixBuilder.append("\n");
        }

        String[] rows = matrixBuilder.toString().split("\n");
        String[][] table = new String[rows.length][rows.length];

        for (int i = 0; i < table.length; i++) {
            table[i] = rows[i].split(" ");
            for (int j = 0; j < table.length; j++) {
                matrix[i][j] = Integer.parseInt(table[i][j]);
            }
        }

        flipInPlace(matrix);
        matrixBuilder.setLength(0);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                matrixBuilder.append(matrix[i][j]).append(" ");
            }
            if (i != table.length - 1) {
                matrixBuilder.append("\n");
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (containsDuplicates(matrix[i])) {
                return "Case #" + caseNum + ": IMPOSSIBLE";
            }
            int[] column = new int[matrix[i].length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (containsDuplicates(column)) {
                return "Case #" + caseNum + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNum + ": POSSIBLE\n" + matrixBuilder.toString();
    }

    public static boolean containsDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void flipInPlace(int[][] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int[] temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
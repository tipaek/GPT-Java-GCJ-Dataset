import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[] result = new int[3];
            calculateVestigium(matrix, n, result);
            System.out.println("Case #" + caseNumber + ": " + result[0] + " " + result[1] + " " + result[2]);
            caseNumber++;
        }

        sc.close();
    }

    public static void calculateVestigium(int[][] matrix, int n, int[] result) {
        int[][] rowCheck = new int[n][n + 1];
        int[][] colCheck = new int[n + 1][n];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (rowCheck[i][value] == 1) {
                    rowRepeats++;
                }
                if (colCheck[value][j] == 1) {
                    colRepeats++;
                }
                rowCheck[i][value]++;
                colCheck[value][j]++;
                if (i == j) {
                    trace += value;
                }
            }
        }

        result[0] = trace;
        result[1] = rowRepeats;
        result[2] = colRepeats;
    }
}
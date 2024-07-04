import java.util.Scanner;

public class Solution {
    public static String Solution(int[][] matrix, int n, int idx) {
        int k = 0;
        int r = 0;
        int c = 0;
        int[] rowCheck;
        int[][] colCheck = new int[n][n];

        for (int i = 0; i < n; i++) {
            rowCheck = new int[n];
            for (int j = 0; j < n; j++) {
                int checkIdx = matrix[i][j];
                if (rowCheck[checkIdx] != 0) {
                    r++;
                } else {
                    rowCheck[checkIdx] = 1;
                }
                if (colCheck[j][checkIdx] != 0) {
                    c++;
                } else {
                    colCheck[j][checkIdx] = 1;
                }
                if (i == j) {
                    k += checkIdx;
                }
            }
        }

        return String.format("Case #%d: %d %d %d", idx, k, r, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        for(int i = 0; i < total; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                String line = sc.nextLine();
                String[] integerStrings = line.split(" ");
                int[] integers = new int[integerStrings.length];
                for (int k = 0; k < integers.length; k++){
                    integers[i] = Integer.parseInt(integerStrings[i]);
                }
                matrix[j] = integers;
            }
            System.out.println(Solution(matrix, n, i+1));
        }
    }
}
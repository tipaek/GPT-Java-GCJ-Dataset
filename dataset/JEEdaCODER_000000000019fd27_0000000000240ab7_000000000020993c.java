import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            int[][] rowCount = new int[size][size];
            int[][] colCount = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int number = in.nextInt();
                    matrix[j][k] = number;
                    rowCount[j][number-1]++;
                    colCount[number-1][k]++;
                }
            }
            int trace = 0;
            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];
            }



            int row = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (rowCount[j][k] > 1) {
                        row ++;
                        break;
                    }
                }
            }

            int col = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (colCount[k][j] > 1) {
                        col ++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + row + " " + col);

        }
    }
}

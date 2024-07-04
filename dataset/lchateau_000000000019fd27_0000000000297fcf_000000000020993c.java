import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i < t + 1; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][];
            for (int j = 0; j < matrix.length; j++) {
                int[] line = new int[n];
                for (int k = 0; k < line.length; k++) {
                    line[k] = sc.nextInt();
                }
                matrix[j] = line;
            }

            // matrix exploration
            int trace = 0;
            int r = 0;
            int c = 0;
            for (int j = 0; j < matrix.length; j++) {
                String row = "";
                String col = "";
                boolean checkRow = true;
                boolean checkCol = true;
                for (int j2 = 0; j2 < matrix.length; j2++) {
                    if (j == j2) {
                        trace += matrix[j][j];
                    }
                    if (checkRow && row.contains(""+matrix[j][j2])){
                        r++;
                        checkRow = !checkRow;
                    }
                    if (checkCol && col.contains(""+matrix[j2][j])){
                        c++;
                        checkCol = false;
                    }
                    row += matrix[j][j2];
                    col += matrix[j2][j];
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
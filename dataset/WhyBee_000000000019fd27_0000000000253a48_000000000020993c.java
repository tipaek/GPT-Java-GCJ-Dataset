import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                }
            }
            int trace = calculateTrace(matrix);
            int row = calculateRow(matrix);
            int column = calculateColumn(matrix);
            System.out.println("Case #" + (i+1) + ": " + trace + " " + row + " " + column);
        }
    }
    public static int calculateTrace(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
                sum+= matrix[i][i];
        }
        return sum;
    }

    public static int calculateRow(int[][] matrix) {
        int count = 0;
        boolean isTrue = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++) {
                if (isTrue) {
                    isTrue = false;
                    break;
                }
                for(int k = j + 1; k < matrix.length; k++)
                if(matrix[i][j] == matrix[i][k]) {
                    count++;
                    isTrue = true;
                    break;
                }
            }
        }
        return count;
    }

    public static int calculateColumn(int[][] matrix) {
        int count = 0;
        boolean isTrue = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++) {
                if (isTrue) {
                    isTrue = false;
                    break;
                }
                for(int k = j + 1; k < matrix.length; k++)
                    if(matrix[j][i] == matrix[k][i]) {
                        count++;
                        isTrue = true;
                        break;
                    }
            }
        }
        return count;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

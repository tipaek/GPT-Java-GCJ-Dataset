import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner io = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = io.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int N = io.nextInt();//size of the NxN matrix
            int[][] matrix= new int[N][N];
            int[][] matrix2= new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int next = io.nextInt();
                    matrix[j][k]=next;
                    matrix2[k][j]=next;
                }
            }
            int trace= findTrace(matrix);
            String repeatRowCol = repeatRow(matrix,matrix2);
            System.out.println("Case #"+(i+1)+": "+trace+ repeatRowCol);
        }
    }

    private static String repeatRow(int[][] matrix,int[][]matrix2) {

        int numberOfRows=0;
        int numberOfColums=0;
        for (int i = 0; i <matrix.length ; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < matrix[i].length-1; j++) {
                if(matrix[i][j]==matrix[i][j+1]){
                    numberOfRows++;
                    break;
                }
            }
            Arrays.sort(matrix2[i]);
            for (int j = 0; j < matrix2[i].length-1; j++) {
                if(matrix2[i][j]==matrix2[i][j+1]){
                    numberOfColums++;
                    break;
                }
            }

        }
        return " "+numberOfRows+" "+numberOfColums;
    }


    private static int findTrace(int[][] matrix) {
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            sum= sum+matrix[i][i];

        }
        return sum;
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();

        }
    }
}

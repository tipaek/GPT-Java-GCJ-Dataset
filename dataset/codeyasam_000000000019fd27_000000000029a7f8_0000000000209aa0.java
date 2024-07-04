import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int nMatrix = scanner.nextInt();
            int kTrace = scanner.nextInt();
            int[][] latinMatrix = attempToCreateLatin(nMatrix);
            boolean isPossible = isPossible(latinMatrix, kTrace);
            if (isPossible) {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                printLatin(latinMatrix);
            } else {
                rotate(latinMatrix);
                isPossible = isPossible(latinMatrix, kTrace);
                if (isPossible) {
                    System.out.println("Case #" + i + ": " + "POSSIBLE");
                    printLatin(latinMatrix);                    
                } else {
                    System.out.println("Case #" + i + ": " + "IMPOSSIBLE");                    
                }
            }

        }
    }

    static int[][] attempToCreateLatin(int n)  { 
        int[][] matrix = new int[n][n];
        int row = 0;
        int col = 0;

        int k = n+1; 
      
        for (int i = 1; i <= n; i++) { 
            col = 0;

            int temp = k; 
  
            while (temp <= n) 
            { 
                matrix[row][col] = temp;
                temp++; 
                col++;
            } 
      
            for (int j = 1; j < k; j++) {
                matrix[row][col++] = j;
            }

            row++;
            k--; 
        } 

        return matrix;
    }    

    private static void printLatin(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }        
    }

    public static void rotate(int[][] matrix) {
       for (int i = 0; i < matrix.length; i++) {
           for (int j = i; j < matrix.length; j++) {
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
           }
       } 
        
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix.length / 2; j++) {
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][matrix.length - 1 - j];
               matrix[i][matrix.length - 1 - j] = temp;
           }
       }
    }

    public static boolean isPossible(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < i + 1; j++) {
                sum += matrix[i][j];
            }
        }

        return sum == trace;
    }
}
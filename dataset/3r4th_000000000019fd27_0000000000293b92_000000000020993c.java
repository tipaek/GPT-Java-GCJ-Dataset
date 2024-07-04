import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int j = 1; j <= numCases; j++){
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int g = 0; g < n; g++){
                for (int h = 0; h < n; h++){
                    matrix[g][h] = in.nextInt();
                }
            }
            System.out.println("Case #" + j + ": " + trace(matrix) + " " + rowRep(matrix) + " " + colRep(matrix));
        }

    }

    public static int trace(int[][] matrix){
        int n = matrix.length;
        int result = 0;
        for (int a = 0; a < n; a++){
            result += matrix[a][a];
        }
        return result;
    }

    public static int rowRep(int[][] matrix){
        int result = 0;
        int n = matrix.length;
        for (int a = 0; a < n; a++){
            int[] occured = new int[n];
            for (int b = 0; b < n; b++){
                int num = matrix[a][b];
                if (occured[num - 1] == 1){
                    result++;
                    break;
                } else {
                    occured[num - 1] = 1;
                }
            }
        }
        return result;
    }

    public static int colRep(int[][] matrix){
        int result = 0;
        int n = matrix.length;
        for (int a = 0; a < n; a++){
            int[] occured = new int[n];
            for (int b = 0; b < n; b++){
                int num = matrix[b][a];
                if (occured[num - 1] == 1){
                    result++;
                    break;
                } else {
                    occured[num - 1] = 1;
                }
            }
        }
        return result;
    }
}
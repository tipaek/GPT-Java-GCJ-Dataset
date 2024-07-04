import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int MAX = 100;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for (int k = 0; k < numCases; k++) {

            // Get the matrix
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.print("Case #" + (k+1) + ": ");
            System.out.print(trace(matrix) + " ");
            System.out.print(numberOfRepeatedRows(matrix) + " ");
            System.out.println(numberOfRepeatedColumns(matrix));
        }

        sc.close();
    }

    public static int numberOfRepeatedRows(int[][] matrix) {
        int sum = 0;
        boolean[] flags = new boolean[MAX];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(flags, false);
            for (int j = 0; j < matrix.length; j++) {
                if(flags[matrix[i][j]] == true){
                    sum++;
                    break;
                } else {
                    flags[matrix[i][j]] = true;
                }
            }
        }
        return sum;
    }
    
    public static int numberOfRepeatedColumns(int[][] matrix) {
        int sum = 0;
        boolean[] flags = new boolean[MAX];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(flags, false);
            for (int j = 0; j < matrix.length; j++) {
                if(flags[matrix[j][i]] == true){
                    sum++;
                    break;
                } else {
                    flags[matrix[j][i]] = true;
                }
            }
        }
        return sum;
    }

    public static int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}



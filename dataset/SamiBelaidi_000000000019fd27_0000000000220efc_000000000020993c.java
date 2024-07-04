import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int matrixSize = in.nextInt();
            int trace = 0, occurencesColumn = 0, ocurrencesRow = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> set = new HashSet<Integer>();
                for (int k = 0; k < matrixSize; k++) {
                    int temp = in.nextInt();
                    matrix[j][k] = temp;
                    if(j==k){
                        trace+=temp;
                    }
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < matrixSize; k++) {
                    if (set.contains(matrix[j][k])) {
                        ocurrencesRow++;
                        break;
                    }
                    set.add(matrix[j][k]);
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < matrixSize; k++) {
                    if (set.contains(matrix[k][j])) {
                        occurencesColumn++;
                        break;
                    }
                    set.add(matrix[k][j]);
                }
            }
            int max = i + 1;
            System.out.println("Case #" + max + ": " + trace + " " + ocurrencesRow + " " + occurencesColumn);


        }

    }
}
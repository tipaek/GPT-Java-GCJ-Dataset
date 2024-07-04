import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        @SuppressWarnings("resource") 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int k = 0, r = 0, c = 0;
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] arr = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                boolean rowFound = false;
                for (int j = 0; j < matrixSize; j++) {
                    if (in.hasNext()) {
                        matrix[i][j] = in.nextInt();
                    } else {
                        matrix[i][j] = 0;
                    }
                    arr[j] = matrix[i][j];
                    if (i == j) {
                        k += matrix[i][j];
                    }
                    if (!rowFound) {
                        for (int l = 0; l < j; l++) {
                            if (arr[j] == arr[l]) {
                                rowFound = true;
                                r++;
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < matrixSize; i++) {
                boolean columnFound = false;
                for (int j = 0; j < matrixSize; j++) {
                    if (!columnFound) {
                        arr[j] = matrix[j][i];
                        for (int l = 0; l < j; l++) {
                            if (arr[j] == arr[l]) {
                                columnFound = true;
                                c++;
                                break;
                            }
                        }
                    }else {
                        break;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
    
}

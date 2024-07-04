import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] matrix = new int[n][n];

            int duplicateRow = 0;
            int duplicateColumn = 0;
            int trace = 0;


            // Construct the matrix
            for (int j = 0; j < n; j++) {
                int[] rowArray = new int[n];
                boolean duplicateFound = false;
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                    if(j==k){
                        trace += matrix[j][k];
                    }

                    int indexValue = matrix[j][k] -1;

                    if(duplicateFound)
                        continue;

                    if(rowArray[indexValue] == 1){
                        duplicateRow++;
                        duplicateFound = true;
                    }else{
                        rowArray[indexValue] = 1;
                    }

                }
            }

            // Check columns the same way as above but flipped index
            for (int k = 0; k < n; k++) {
                int[] columnArray = new int[n];
                boolean duplicateFound = false;
                for (int j = 0; j < n; j++) {

                    if(duplicateFound)
                        continue;

                    int indexValue = matrix[j][k]-1;

                    if(columnArray[indexValue] == 1){
                        duplicateColumn++;
                        duplicateFound = true;
                    }else{
                        columnArray[indexValue] = 1;
                    }
                }
            }
            
            System.out.println("Case #"+i+": "+trace+" "+duplicateRow+" "+duplicateColumn);
        }
    }

}
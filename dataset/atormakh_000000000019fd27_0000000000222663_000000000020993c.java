import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSetSize; ++i) {
            int sizeOfMatrix = in.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
            for(int j=0;j<sizeOfMatrix; j++){
                for(int k = 0;k<sizeOfMatrix;k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            String answer = solve(sizeOfMatrix,matrix);
            System.out.println("Case #" + i + ": " + answer );
        }


    }

    public static String solve(int sizeOfMatrix, int[][] matrix){
        int faultyRows = 0, faultyColumns = 0,trace  =0;
        boolean isFaulty=false;
        int[] sums = new int[sizeOfMatrix];
        //primero recorro las filas
        for(int i = 0;i< sizeOfMatrix;i++){
            isFaulty = false;
            for(int j=0;j<sizeOfMatrix;j++){
                sums[matrix[i][j]]++;
            }
            for(int k = 0; k<sizeOfMatrix || isFaulty;k++){
                if(sums[k] > 1){
                    faultyRows++;
                    isFaulty = true;
                }
            }
        }
        //desp recorro las columnas
        for(int i = 0;i< sizeOfMatrix;i++){
            isFaulty = false;
            for(int j=0;j<sizeOfMatrix;j++){
                sums[matrix[j][i]]++;
            }
            for(int k = 0; k<sizeOfMatrix || isFaulty;k++){
                if(sums[k] > 1){
                    faultyColumns++;
                    isFaulty = true;
                }
            }
        }
        //calculo el trace
        for(int i = 0;i<sizeOfMatrix;i++){
            trace += matrix[i][i];
        }
        return String.valueOf(trace) + ' ' + String.valueOf(faultyRows) + ' ' + String.valueOf(faultyColumns);
    }

}
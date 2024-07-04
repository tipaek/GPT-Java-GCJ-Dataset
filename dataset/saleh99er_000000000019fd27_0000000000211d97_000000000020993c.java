import java.util.*;
import java.io.*;
import java.util.Random;

class Soln {
    int trace;
    int rowsWithDups;
    int columnsWithDups;

}

public class Solution {

    public static boolean[] wasSeen;

    public static void resetState(int n){
        for(int i = 0; i < n+1; i++){
            wasSeen[i] = false;
        }
    }

    public static Soln vestigium(int[][] matrix, int N){
        Soln solution = new Soln();

        // get trace
        for(int i = 0; i < N; i++){
            solution.trace += matrix[i][i];
        }

        // get dups for col
        for(int c = 0; c < N; c++){
            boolean dupSeen = false;
            for(int r = 0; r < N; r++){
                int value = matrix[r][c];
                if(wasSeen[value])  {
                    dupSeen = true;
                    break;
                }
                wasSeen[value] = true;
            }
            if(dupSeen) solution.columnsWithDups++;
            resetState(N);
        }

        // get dups for row
        for(int r = 0; r < N; r++){
            boolean dupSeen = false;
            for(int c = 0; c < N; c++){
                int value = matrix[r][c];
                if(wasSeen[value])  {
                    dupSeen = true;
                    break;
                }
                wasSeen[value] = true;
            }
            if(dupSeen) solution.rowsWithDups++;
            resetState(N);
        }

        return solution;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int n;

        for (int i = 1; i <= testCases; ++i) {
            n = in.nextInt();
            wasSeen = new boolean[n+1];
            int[][] matrix = new int[n][n];

            for(int j = 0; j < n; j++){ // row
                for(int k = 0; k < n; k++){ // col
                    matrix[j][k] = in.nextInt();
                }
            }
            Soln soln = vestigium(matrix, n);

            //System.out.println("Finished reading input");
            System.out.println("Case #"+i + ": " + soln.trace + " " + soln.rowsWithDups + " " + soln.columnsWithDups);
            
            vestigium(matrix, n);
        }
    }
}
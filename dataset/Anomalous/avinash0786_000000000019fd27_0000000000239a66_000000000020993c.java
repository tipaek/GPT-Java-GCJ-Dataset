import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  // Number of test cases
        for (int i = 0; i < t; i++) {
            int N = inp.nextInt();  // Size of the matrix N*N
            int[][] arr = new int[N][N];
            int trace = 0;  // Trace of the matrix
            int rowRep = 0;  // Number of rows with repeated elements
            int colRep = 0;  // Number of columns with repeated elements

            // Reading the matrix
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = inp.nextInt();
                }
            }

            // Calculating trace
            for (int x = 0; x < N; x++) {
                trace += arr[x][x];
            }

            // Checking for repeated elements in rows
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowRep++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(arr[k][j])) {
                        colRep++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRep + " " + colRep);
        }
    }
}
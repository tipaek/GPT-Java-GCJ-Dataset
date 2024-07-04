import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            int N = inp.nextInt();  // Size of matrix N*N
            int[][] arr = new int[N][N];
            int trace = 0;  // Trace of matrix
            int rowRep = 0;  // Number of rows with repetitions
            int colRep = 0;  // Number of columns with repetitions

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

            // Checking rows for repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowRep++;
                        break;
                    }
                }
            }

            // Checking columns for repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(arr[k][j])) {
                        colRep++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRep + " " + colRep);
        }
    }
}
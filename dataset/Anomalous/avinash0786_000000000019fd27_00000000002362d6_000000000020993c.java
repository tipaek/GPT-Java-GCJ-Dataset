import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  // number of test cases

        for (int i = 0; i < t; i++) {
            int N = inp.nextInt();  // size of the matrix N*N
            int[][] arr = new int[N][N];
            int trace = 0;  // trace of the matrix
            int rowRep = 0;  // number of rows with repetitions
            int colRep = 0;  // number of columns with repetitions

            // Reading the matrix
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = inp.nextInt();
                }
            }

            // Calculating the trace
            for (int x = 0; x < N; x++) {
                trace += arr[x][x];
            }

            // Calculating the number of rows with repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowRep++;
                        break;
                    }
                }
            }

            // Calculating the number of columns with repetitions
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
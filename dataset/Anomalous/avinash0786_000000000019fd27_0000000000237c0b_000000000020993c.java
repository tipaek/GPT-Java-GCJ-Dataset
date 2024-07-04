import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  // number of test cases

        for (int i = 0; i < t; i++) {
            int N = inp.nextInt();  // size of matrix N*N
            int[][] arr = new int[N][N];
            int trace = 0;  // trace of the matrix
            int rowRep = 0;  // number of rows with repeated elements
            int colRep = 0;  // number of columns with repeated elements

            // Reading matrix elements
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = inp.nextInt();
                }
            }

            // Calculating trace
            for (int x = 0; x < N; x++) {
                trace += arr[x][x];
            }

            // Calculating number of rows with repeated elements
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowRep++;
                        break;
                    }
                }
            }

            // Calculating number of columns with repeated elements
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(arr[k][j])) {
                        colRep++;
                        break;
                    }
                }
            }

            // Printing matrix (optional, can be removed if not needed)
            for (int j = 0; j < N; j++) {
                for (int s : arr[j]) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            // Printing results
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRep + " " + colRep);
        }

        inp.close();
    }
}
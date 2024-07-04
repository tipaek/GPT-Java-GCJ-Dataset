import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++) {
            int n = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] s = in.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(s[k]);
                }
            }
            int k = trace(matrix, n);
            int row = 0, col = 0;
            for (int lol = 0; lol < n; lol++) {
                int[] r = new int[n];
                int[] co = new int[n];
                for (int l = 0; l < n; l++) {
                    r[l] = matrix[lol][l];
                    co[l] = matrix[l][lol];
                }
                if (checkDuplicatesWithinK(r, n-1)) {
                    row++;
                }
                if (checkDuplicatesWithinK(co, n-1)) {
                    col++;
                }
            }
            int caseNum = i+1;
            System.out.println("Case #" + caseNum + ": " + k + " " + row + " " + col);
        }
    }

    static int trace(int[][] m, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += m[i][i];
        }
        return trace;
    }

    static boolean checkDuplicatesWithinK(int arr[], int k)
    {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array
        for (int i=0; i<arr.length; i++)
        {
            // If already present n hash, then we found
            // a duplicate within k distance
            if (set.contains(arr[i]))
                return true;

            // Add this item to hashset
            set.add(arr[i]);

            // Remove the k+1 distant item
            if (i >= k)
                set.remove(arr[i-k]);
        }
        return false;
    }
}

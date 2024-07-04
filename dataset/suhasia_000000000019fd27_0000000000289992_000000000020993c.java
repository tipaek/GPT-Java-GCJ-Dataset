import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            //trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            //rows
            int rowcount = 0;
            for (int i = 0; i < n; i++) {
                int[] used = new int[n];
                for (int j = 0; j < n; j++) {
                    if (used[matrix[i][j] - 1] == 1) {
                        rowcount++;
                        break;
                    } else used[matrix[i][j] - 1] = 1;
                }
            }
            //columns
            int colcount = 0;
            for (int i = 0; i < n; i++) {
                int[] used = new int[n];
                for (int j = 0; j < n; j++) {
                    if (used[matrix[j][i] - 1] == 1) {
                        colcount++;
                        break;
                    } else used[matrix[j][i] - 1] = 1;
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + trace + " " + rowcount + " " + colcount);
        }
    }
}


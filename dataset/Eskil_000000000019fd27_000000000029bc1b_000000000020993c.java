import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int T = Integer.parseInt(s);
        for (int i = 0; i < T; i++) {
            s = r.readLine();
            int N = Integer.parseInt(s);
            int[][] square = new int[N][N];
            for (int j = 0; j < N; j++) {
                s = r.readLine();
                String[] parts = s.split(" ");
                for (int k = 0; k < N; k++) {
                    square[j][k] = Integer.parseInt(parts[k]);
                }
            }
            int sum = 0;
            int nRows = 0;
            int nCols = 0;
            for (int j = 0; j < N; j++) {
                TreeSet<Integer> rowNumbs = new TreeSet<>();
                sum += square[j][j];
                for (int k = 0; k < N; k++) {
                    if (rowNumbs.contains(square[j][k])) {
                        nRows++;
                        break;
                    } else {
                        rowNumbs.add(square[j][k]);
                    }
                }
                TreeSet<Integer> colNumbs = new TreeSet<>();
                for (int k = 0; k < N; k++) {
                    if (colNumbs.contains(square[k][j])) {
                        nCols++;
                        break;
                    } else {
                        colNumbs.add(square[k][j]);
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + sum + " " + nRows + " " + nCols);
        }
    }
}
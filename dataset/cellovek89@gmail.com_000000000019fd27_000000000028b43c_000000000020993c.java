import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main (String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] toks = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder("");
        int[][] matrix = new int[100][100];
        int t = Integer.parseInt(toks[0]);
        int n;
        for (int test = 0; test < t; test++) {
            toks = reader.readLine().split(" ");
            n = Integer.parseInt(toks[0]);
            for (int i = 0; i < n; i++) {
                toks = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(toks[j]);
                }
            }
            int r = 0;
            int c = 0;
            int trace = 0;
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) trace += matrix[i][i];

            for (int i = 0; i < n; i++) {
                int index = 0;
                int j = 0;
                while ((j < n) && (index == 0)) {
                    if (set.contains(matrix[i][j])) {
                        index = 1;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                        j++;
                    }

                }
                if (index == 1) r++;
                set.clear();
            }
            for (int i = 0; i < n; i++) {
                int index = 0;
                int j = 0;
                while ((j < n) && (index == 0)) {
                    if ((! set.isEmpty()) && (set.contains(matrix[j][i]))) {
                        index = 1;
                        break;
                    } else {
                        set.add(matrix[j][i]);
                        j++;
                    }

                }
                if (index == 1) c++;
                set.clear();
            }
            sb.append("Case #" + (test + 1) + ": " + trace + " " + r + " " + c);
            if (test != t - 1) sb.append("\n");
        }
        System.out.print(sb);

    }



}

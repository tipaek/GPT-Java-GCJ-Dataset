

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                int size = in.nextInt();
                int[][] matrix = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }
                int trace = 0;
                int dupRows = 0;
                int dupCols = 0;
                for (int i = 0; i < size; i++) {
                    Set<Integer> rows = new HashSet<>();
                    Set<Integer> cols = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        rows.add(matrix[i][j]);
                        cols.add(matrix[j][i]);
                        if (i == j) {
                            trace = trace + matrix[i][j];
                        }
                    }
                    if (rows.size() < size) {
                        dupRows++;
                    }
                    if (cols.size() < size) {
                        dupCols++;
                    }
                }
                System.out.println("Case #" + t + ": " + trace + " " + dupRows + " " + dupCols);
            }
        } finally {
            in.close();
        }
    }

}

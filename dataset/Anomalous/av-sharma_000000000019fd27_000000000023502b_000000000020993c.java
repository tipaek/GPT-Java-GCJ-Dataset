import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        long testCases = reader.nextLong();

        for (long t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            long[][] matrix = new long[n][n];
            long diagonalSum = 0;
            long repeatedRows = 0, repeatedCols = 0;
            List<Set<Long>> columnSets = new ArrayList<>();
            Set<Long> rowSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                columnSets.add(new HashSet<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextLong();
                    rowSet.add(matrix[i][j]);
                    columnSets.get(j).add(matrix[i][j]);
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowSet.size() != n) {
                    repeatedRows++;
                }
                rowSet.clear();
            }

            for (int i = 0; i < n; i++) {
                if (columnSets.get(i).size() != n) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }
}
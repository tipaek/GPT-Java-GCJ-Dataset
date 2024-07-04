import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int x = 1; x <= T; x++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                int trace = 0;

                for (int i = 0; i < N; i++) {
                    StringTokenizer tk = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(tk.nextToken());
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                HashSet<Integer> repeatedRows = new HashSet<>();
                HashSet<Integer> repeatedColumns = new HashSet<>();

                for (int i = 0; i < N; i++) {
                    HashSet<Integer> rowElements = new HashSet<>();
                    for (int j = 0; j < N; j++) {
                        if (!rowElements.add(matrix[i][j])) {
                            repeatedRows.add(i);
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    HashSet<Integer> columnElements = new HashSet<>();
                    for (int i = 0; i < N; i++) {
                        if (!columnElements.add(matrix[i][j])) {
                            repeatedColumns.add(j);
                        }
                    }
                }

                bw.write(String.format("Case #%d: %d %d %d%n", x, trace, repeatedRows.size(), repeatedColumns.size()));
            }

            bw.flush();
        }
    }
}
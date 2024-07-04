import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(bufferedReader.readLine().trim());
            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(bufferedReader.readLine().trim());
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    String[] row = bufferedReader.readLine().trim().split(" ");
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                    }
                }

                Vestigium vestigium = new Vestigium(N, matrix);
                bufferedWriter.write(String.format("Case #%d: %d %d %d%n", t, vestigium.getTrace(), vestigium.getRowRepeats(), vestigium.getColumnRepeats()));
            }
            bufferedWriter.flush();
        }
    }
}

class Vestigium {
    private final int N;
    private final int[][] matrix;
    private int trace;
    private int rowRepeats;
    private int columnRepeats;

    public Vestigium(int N, int[][] matrix) {
        this.N = N;
        this.matrix = matrix;
        calculateTrace();
        calculateRowRepeats();
        calculateColumnRepeats();
    }

    private void calculateTrace() {
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
    }

    private void calculateRowRepeats() {
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }
    }

    private void calculateColumnRepeats() {
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnRepeats++;
            }
        }
    }

    private boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[N + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    public int getTrace() {
        return trace;
    }

    public int getRowRepeats() {
        return rowRepeats;
    }

    public int getColumnRepeats() {
        return columnRepeats;
    }
}
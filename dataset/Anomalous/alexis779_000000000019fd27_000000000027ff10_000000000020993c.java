import java.io.*;

public class Vestigium {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] row = bufferedReader.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            Vestigium vestigium = new Vestigium(N, matrix);
            bufferedWriter.write(vestigium.k + " " + vestigium.r + " " + vestigium.c);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }

    private int N;
    private int[][] matrix;
    public int k;
    public int r;
    public int c;

    public Vestigium(int N, int[][] matrix) {
        this.N = N;
        this.matrix = matrix;
        this.k = calculateTrace();
        this.r = countRowRepeats();
        this.c = countColumnRepeats();
    }

    private int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowRepeats() {
        int rowRepeats = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private int countColumnRepeats() {
        int columnRepeats = 0;
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnRepeats++;
            }
        }
        return columnRepeats;
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
}
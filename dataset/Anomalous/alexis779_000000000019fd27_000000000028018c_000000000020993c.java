import java.io.*;

public class Vestigium {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        // InputStream inputStream = new FileInputStream(new File("Vestigium"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] tokens = bufferedReader.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    M[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            MatrixAnalyzer analyzer = new MatrixAnalyzer(N, M);
            bufferedWriter.write(analyzer.getTrace() + " " + analyzer.getRowRepeats() + " " + analyzer.getColumnRepeats());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class MatrixAnalyzer {
    private final int N;
    private final int[][] M;
    private int trace;
    private int rowRepeats;
    private int columnRepeats;

    public MatrixAnalyzer(int N, int[][] M) {
        this.N = N;
        this.M = M;
        this.trace = calculateTrace();
        this.rowRepeats = calculateRowRepeats();
        this.columnRepeats = calculateColumnRepeats();
    }

    private int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += M[i][i];
        }
        return trace;
    }

    private int calculateRowRepeats() {
        int repeats = 0;
        for (int i = 0; i < N; i++) {
            if (hasRepeats(M[i])) {
                repeats++;
            }
        }
        return repeats;
    }

    private int calculateColumnRepeats() {
        int repeats = 0;
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = M[i][j];
            }
            if (hasRepeats(column)) {
                repeats++;
            }
        }
        return repeats;
    }

    private boolean hasRepeats(int[] array) {
        boolean[] visited = new boolean[N + 1];
        for (int value : array) {
            if (visited[value]) {
                return true;
            }
            visited[value] = true;
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
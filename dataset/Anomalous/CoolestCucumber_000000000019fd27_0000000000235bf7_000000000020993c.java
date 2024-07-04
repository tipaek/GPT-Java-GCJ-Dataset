import java.io.*;
import java.util.HashSet;

class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int trace = calculateTrace(matrix, N);
            int rowDuplicates = calculateRowDuplicates(matrix, N);
            int colDuplicates = calculateColDuplicates(matrix, N);

            bw.write(String.format("Case #%d: %d %d %d%n", testCase, trace, rowDuplicates, colDuplicates));
        }

        bw.flush();
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateRowDuplicates(int[][] matrix, int N) {
        int rowDuplicates = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < N) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private static int calculateColDuplicates(int[][] matrix, int N) {
        int colDuplicates = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < N) {
                colDuplicates++;
            }
        }
        return colDuplicates;
    }
}
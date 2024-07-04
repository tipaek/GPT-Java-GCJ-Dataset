import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        for (int k = 0; k < T; k++) {
            int N = fastReader.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = fastReader.nextInt();
                }
            }
            displayOutput(matrix, k, N);
        }
        fastReader.close();
    }

    private static void displayOutput(int[][] matrix, int k, int N) {
        int sum = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            if (isDuplicateRow(matrix, i, N)) {
                rowCount++;
            }
            if (isDuplicateCol(matrix, i, N)) {
                colCount++;
            }
            sum += matrix[i][i];
        }

        System.out.println("Case #" + (k + 1) + ":" + sum + " " + rowCount + " " + colCount);
    }

    private static boolean isDuplicateRow(int[][] matrix, int row, int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!set.add(matrix[row][i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicateCol(int[][] matrix, int col, int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!set.add(matrix[i][col])) {
                return true;
            }
        }
        return false;
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    void close() throws IOException {
        br.close();
    }
}

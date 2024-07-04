import java.io.*;
import java.util.regex.Pattern;

class Solution {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1024);
    private static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out), 1024));

    private static int nextInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String nextLine() throws IOException {
        return reader.readLine();
    }

    private static int[][] nextMatrix(int n) throws IOException {
        int[][] matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            int[] row = Pattern.compile(" ").splitAsStream(nextLine())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[j] = row;
        }
        return matrix;
    }

    private static void write(int x, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = new int[matrix.length + 1];
            int[] column = new int[matrix.length + 1];
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) k += matrix[i][j];
                row[matrix[i][j]] += 1;
                column[matrix[j][i]] += 1;
            }
            for (int j = 1; j <= matrix.length; j++) {
                if (row[j] > 1) {
                    r++;
                    break;
                }
            }
            for (int j = 1; j <= matrix.length; j++) {
                if (column[j] > 1) {
                    c++;
                    break;
                }
            }
        }
        writer.println("Case #" + x + ": " + k + " " + r + " " + c);
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int x = 1; x <= t; x++) {
            int n = nextInt();
            int[][] matrix = nextMatrix(n);
            write(x, matrix);
        }
        writer.flush();
        writer.close();
    }
}
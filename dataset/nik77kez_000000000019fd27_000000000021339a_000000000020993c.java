import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new InputStreamReader(new BufferedInputStream(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int testNum = nextInt(in);
        int n;
        int[][] matrix;
        int trace;
        int repeatsRow;
        int repeatsColumn;
        for (int tmpTest = 1; tmpTest <= testNum; tmpTest++) {
            n = nextInt(in);
            matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    matrix[row][column] = nextInt(in);
                }
            }
            trace = 0;
            repeatsColumn = 0;
            repeatsRow = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                repeatsRow += countRepeatsRow(matrix, i, n);
                repeatsColumn += countRepeatsColumns(matrix, i, n);
            }
            out.println("Case #" + tmpTest + ": " + trace + " " + repeatsRow + " " + repeatsColumn);
            out.flush();
        }
    }

    private static int countRepeatsColumns(int[][] matrix, int i, int n) {
        Set<Integer> repeats = new HashSet<>();
        for (int j = 0; j < n; j++) {
            if (repeats.contains(matrix[j][i])) {
                return 1;
            } else {
                repeats.add(matrix[j][i]);
            }
        }
        return 0;
    }

    private static int countRepeatsRow(int[][] matrix, int i, int n) {
        Set<Integer> repeats = new HashSet<>();
        for (int j = 0; j < n; j++) {
            if (repeats.contains(matrix[i][j])) {
                return 1;
            } else {
                repeats.add(matrix[i][j]);
            }
        }
        return 0;
    }

    private static int nextInt(StreamTokenizer in) throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

}

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(getReader());

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            System.out.println( "Case #" + (i + 1) + ": " + processCase(matrix));
        }

    }

    private String processCase(int[][] matrix) {
        return getTrace(matrix) + " " + getRowsWithRepetitions(matrix) + " " + getColumnsWithRepetitions(matrix);
    }

    private String getTrace(int[][] m) {
        int trace = 0;
        for (int i=0; i < m.length; i++) {
            trace += m[i][i];
        }
        return trace + "";
    }

    private String getRowsWithRepetitions(int[][] m) {
        int duplicates = 0;
        for (int i=0; i < m.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j=0; j < m[i].length; j++) {
                if (! uniqueElements.add(m[i][j])) {
                    break;
                }
            }
            if (uniqueElements.size() < m.length) {
                duplicates++;
            }
        }

        return duplicates + "";
    }

    private String getColumnsWithRepetitions(int[][] m) {
        int duplicates = 0;
        for (int i=0; i < m.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j=0; j < m[i].length; j++) {
                if (! uniqueElements.add(m[j][i])) {
                    break;
                }
            }
            if (uniqueElements.size() < m.length) {
                duplicates++;
            }
        }

        return duplicates + "";
    }

    private InputStreamReader getReader() throws IOException {
        return new InputStreamReader(System.in);
        // return new InputStreamReader(getClass().getClassLoader().getResourceAsStream("vestigium.txt"));
    }
}

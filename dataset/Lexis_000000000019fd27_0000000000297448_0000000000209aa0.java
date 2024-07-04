import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String line = reader.readLine();
            String[] parts = line.split(" ", -1);
            int n = Integer.parseInt(parts[0]);
            int trace = Integer.parseInt(parts[1]);

            int[][] matrix = process(n, trace);
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int[] integers : matrix) {
                    StringBuilder sb = new StringBuilder();
                    for (int d = 0; d < matrix.length; d++) {
                        if (d != 0) sb.append(" ");
                        sb.append(integers[d]);
                    }
                    System.out.println(sb.toString());
                }
            }
        }

    }

    public int[][] process(int n, int trace) {
        for (int i = 1; i <= n; i++) {
            int[][] matrix = generate(n, i);
            if (calcDiagSum(matrix) == trace)
                return matrix;
            if (calcDiagSum2(matrix) == trace)
                return diagInverse(matrix);
            for (int z = 2; z < matrix.length; z++) {
                int[] tmp = matrix[z];
                matrix[z] =  matrix[z - 1];
                matrix[z -1]= tmp;
                if (calcDiagSum(matrix) == trace)
                    return matrix;
                if (calcDiagSum2(matrix) == trace)
                    return diagInverse(matrix);
            }
        }
        return null;
    }

    public static  int calcDiagSum(int[][] matrix) {
        int diag = 0;
        for (int i = 0; i < matrix.length; i++) {
            diag += matrix[i][i];
        }
        return diag;
    }

    public static int calcDiagSum2(int[][] matrix) {
        int diag = 0;
        for (int i = 0; i < matrix.length; i++) {
            diag += matrix[i][matrix.length - i - 1];
        }
        return diag;
    }

    public static int[][]  diagInverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int r = 0; r < matrix.length / 2; r++) {
                int tmp = matrix[i][r];
                matrix[i][r] = matrix[i][matrix.length - r - 1];
                matrix[i][matrix.length - r - 1] = tmp;
            }
        }
        return matrix;
    }

    public static int[][] generate(int n, int number) {
        int[][] matrix = null;

        LinkedList<Integer> digits = new LinkedList<>();
        digits.add(number);
        for (int i = 1; i <= n; i++) {
            if (i != number)
                digits.add(i);
        }

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Iterator<Integer> iter = digits.iterator();
            for (int r = 0; r < n; r++) {
                matrix[i][r] = iter.next();
            }
            digits.addFirst(digits.pollLast());
        }
        return matrix;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}

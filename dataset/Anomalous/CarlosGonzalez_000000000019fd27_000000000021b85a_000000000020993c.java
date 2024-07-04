import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        CustomScanner sc = new CustomScanner();
        int cases = Integer.parseInt(sc.next());
        int caseNumber = 1;

        while (cases-- > 0) {
            int size = Integer.parseInt(sc.next());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(sc.next());
                }
            }

            int rowDuplicates = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            int columnDuplicates = 0;
            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    static class CustomScanner {

        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }
}
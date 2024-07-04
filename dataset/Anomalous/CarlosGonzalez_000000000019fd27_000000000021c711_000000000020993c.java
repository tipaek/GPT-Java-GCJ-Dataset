import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        CustomScanner sc = new CustomScanner();
        int cases = Integer.parseInt(sc.next());
        int caseNumber = 1;

        while (cases-- > 0) {
            int l = Integer.parseInt(sc.next());
            int[][] matrix = new int[l][l];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    matrix[i][j] = Integer.parseInt(sc.next());
                }
            }

            int rowDuplicates = countRowDuplicates(matrix, l);
            int colDuplicates = countColDuplicates(matrix, l);
            int diagonalSum = calculateDiagonalSum(matrix, l);

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicates = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    static class CustomScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public boolean hasNext() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}
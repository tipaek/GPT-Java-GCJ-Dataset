import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            int dimension = Integer.parseInt(reader.readLine());
            Integer[][] matrix = new Integer[dimension][dimension];
            for (int r = 0; r < dimension; r++) {
                String input = reader.readLine();
                String[] numbers = input.split(" ", -1);
                for (int t = 0; t < numbers.length; t++) {
                    matrix[r][t] = Integer.valueOf(numbers[t]);
                }
            }
            System.out.println("Case #" + i + ": " + process(matrix));
        }

    }

    public String process(Integer[][] matrix) {
        int trace = 0;
        int r = 0;
        int c = 0;

        boolean[] cd = new boolean[matrix.length];
        Set<Integer>[] cols = new Set[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            Set<Integer> row = new HashSet<>();
            boolean foundDup = false;
            for (int t = 0; t < matrix.length; t++) {
                if (!foundDup) {
                    foundDup = !row.add(matrix[i][t]);
                    if (foundDup) {
                        r++;
                    }
                }
                if (!cd[t]) {
                    cd[t] = !cols[t].add(matrix[i][t]);
                    if (cd[t]) {
                        c++;
                    }
                }
            }
        }

        return trace + " " + r + " " + c;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}

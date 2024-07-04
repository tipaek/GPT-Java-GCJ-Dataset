import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        int testNum = 1;

        while (testCases > 0) {
            int trace = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < N; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int i = 0; i < N; i++) {
                int[] column = new int[N];
                for (int j = 0; j < N; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    columnRepeats++;
                }
            }

            System.out.println("#" + testNum + ": " + trace + " " + rowRepeats + " " + columnRepeats);
            testCases--;
            testNum++;
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
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    int[][] arr;
    int nTestCases = 0;
    int matrixSize = 0;

    private void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCasesString = br.readLine();

        if (testCasesString != null) {
            for (int t = 1; t <= Integer.parseInt(testCasesString); t++) { // 1 to n test cases
                String matrixSizeString = br.readLine();

                if (matrixSizeString != null) {
                    int matrixSize = Integer.parseInt(matrixSizeString);
                    arr = new int[matrixSize][matrixSize];

                    int i = 0;
                    for (int n = 1; n <= matrixSize; n++) { // 1 to
                        String matrixLineString = br.readLine();
                        StringTokenizer st = new StringTokenizer(matrixLineString, " ");

                        int j = 0;
                        while (st.hasMoreTokens()) {
                            arr[i][j++] = Integer.parseInt(st.nextElement().toString());
                        }
                        i++;
                    }
                }

                String testCaseOutput = isLatinSquare();
                System.out.println("Case #" + t + ": " + testCaseOutput);
            }
        }
    }

    private String isLatinSquare() {
        int trace = 0;
        Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        int rDupCount = 0, cDupCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean rDupFound = false, cDupFound = false;

            for (int j = 0; j < arr.length; j++) {
                // Calculate trace
                if ( i == j) {
                    trace += arr[i][j];
                }

                // Check if row has duplicates
                if (rowSet.contains(arr[i][j]) && !rDupFound) {
                    rDupCount++; rDupFound = true;
                } else {
                    rowSet.add(arr[i][j]);
                }

                // Check if col has duplicates
                if (colSet.contains(arr[j][i]) && !cDupFound) {
                    cDupCount++; cDupFound = true;
                } else {
                    colSet.add(arr[j][i]);
                }
            }
            rowSet.clear(); colSet.clear();
        }

        return trace + " " + rDupCount + " " + cDupCount;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.readInput();
    }
}

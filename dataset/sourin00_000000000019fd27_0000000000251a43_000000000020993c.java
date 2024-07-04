import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(scanner.readLine());
        String[] testResults = new String[testCases];
        int[][] testArr;
        Set<Integer> testSetRow;
        Set<Integer> testSetColumn;
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(scanner.readLine());
            testArr = new int[n][n];
            testSetRow = new HashSet<>(n);
            testSetColumn = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                String[] row = scanner.readLine().split(" ");
                testArr[j] = Stream.of(row).mapToInt(Integer::parseInt).toArray();
            }
            int sum = 0;
            int rowDuplicates = 0;
            boolean isRowDuplicate = false, isColumnDuplicate;
            int columnDuplicates = 0;
            for (int k = 0; k < testArr.length; k++) {
                for (int l = 0; l < testArr[k].length; l++) {
                    isColumnDuplicate = false;
                    if (k == 0) {
                        for (int f = 0; f < n; f++) {
                            if (testSetColumn.contains(testArr[f][l])) {
                                isColumnDuplicate = true;
                                break;
                            } else
                                testSetColumn.add(testArr[f][l]);
                        }
                        if (isColumnDuplicate)
                            columnDuplicates++;
                        testSetColumn.clear();
                    }
                    if (k == l)
                        sum += testArr[k][l];
                    if (testSetRow.contains(testArr[k][l]))
                        isRowDuplicate = true;
                    else
                        testSetRow.add(testArr[k][l]);
                }
                if (isRowDuplicate) {
                    rowDuplicates++;
                    isRowDuplicate = false;
                }
                testSetRow.clear();
            }
            testResults[i] = "Case #" + (i+1) + ":" + " " + sum + " " + rowDuplicates + " " + columnDuplicates;
        }
        for (String testResult : testResults) {
            System.out.println(testResult);
        }
    }
}

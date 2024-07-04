import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    public String solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        String[] solutions = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(in.nextLine());
            TestCase testCase = new TestCase(matrixSize);
            for (int line = 0; line < matrixSize; line++) {
                String lineValue = in.nextLine();
                testCase.addLine(line, lineValue);
            }
            StringBuilder caseResult = new StringBuilder();
            caseResult.append("Case #").append(i + 1).append(": ").append(testCase.solve());
            solutions[i] = caseResult.toString();
        }
        return String.join("\n", solutions);
    }

    static class TestCase {
        int[][] attendanceRow;
        int[][] attendanceCol;
        int trace = 0;

        public TestCase(int matrixSize) {
            attendanceRow = new int[matrixSize][matrixSize];
            attendanceCol = new int[matrixSize][matrixSize];
            init(attendanceRow);
            init(attendanceCol);
        }

        private void init(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        public void addLine(int row, String lineValue) {
            String[] parts = lineValue.split(" ");
            for (int col = 0; col < parts.length; col++) {
                int integer = Integer.parseInt(parts[col]);
                if (row == col) {
                    trace += integer;
                }
                attendanceRow[row][integer - 1]++;
                attendanceCol[col][integer - 1]++;
            }
        }

        public String solve() {
            int rowsWithRepeatedElements = computeRows();
            int columnsWithRepeatedElements = computeColumns();
            return trace + " " + rowsWithRepeatedElements + " " + columnsWithRepeatedElements;
        }

        private int computeColumns() {
            return countDifferences(attendanceCol);
        }

        private int computeRows() {
            return countDifferences(attendanceRow);
        }

        private int countDifferences(int[][] arr) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] != 1) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    }
}

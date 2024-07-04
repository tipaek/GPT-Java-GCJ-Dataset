import java.util.*;
public class Solution {

    private static int[][] getGivenMatrix(int nValue, Scanner scanner) {
        int[][] givenMatrix = new int[nValue][nValue];
        for(int rowIdx = 0; rowIdx < nValue; rowIdx++) {
            for(int colIdx = 0; colIdx < nValue; colIdx++) {
                givenMatrix[rowIdx][colIdx] = scanner.nextInt();
            }
        }
        return givenMatrix;
    }

    private static int getTraceValue(int[][] givenMatrix, int nValue) {
        int traceSum = 0;
        for(int rowIdx = 0, colIdx = 0; rowIdx < nValue && colIdx < nValue; rowIdx++, colIdx++) {
            traceSum = traceSum + givenMatrix[rowIdx][colIdx];
        }
        return traceSum;
    }

    private static boolean findIfItContainsRepeatedValues(int[][] givenMatrix, int givenIdx, int nValue, boolean isRow) {
        Set<Integer> curSet = new HashSet<>();
        for(int curIdx = 0; curIdx < nValue; curIdx++) {
            int curValue = (isRow ? givenMatrix[givenIdx][curIdx] : givenMatrix[curIdx][givenIdx]);
            if(curSet.contains(curValue)) return true;
            curSet.add(curValue);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestcases = scanner.nextInt();

        for(int testcase = 1; testcase <= numTestcases; testcase++) {
            int nValue = scanner.nextInt();
            int[][] givenMatrix = getGivenMatrix(nValue, scanner);
            int traceValue = getTraceValue(givenMatrix, nValue);
            int numRowsWithRepeatedValues = 0;
            int numColsWithRepeatedValues = 0;

            for(int row=0; row < nValue; row++) {
                boolean isRepeated = findIfItContainsRepeatedValues(givenMatrix, row, nValue, true);
                numRowsWithRepeatedValues+=(isRepeated ? 1: 0);
            }

            for(int col=0; col < nValue; col++) {
                boolean isRepeated = findIfItContainsRepeatedValues(givenMatrix, col, nValue, false);
                numColsWithRepeatedValues+=(isRepeated ? 1: 0);
            }

            System.out.println("Case #" + testcase + ": " + traceValue + " " + numRowsWithRepeatedValues + " " + numColsWithRepeatedValues);
        }
    }
}
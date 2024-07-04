import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();
        for(int caseNum=1;caseNum<=numCases;caseNum++) {
            int[][] matrix = readMatrix(s);

            int trace = computeTrace(matrix);
            int repeatingRows = computeRepeatingRows(matrix);
            int repeatingColumns = computeRepeatingColumns(matrix);

            System.out.format("Case #%d: %d %d %d\n", caseNum, trace, repeatingRows, repeatingColumns);
        }
    }

    private static int computeRepeatingColumns(int[][] matrix) {
        int result = 0;
        for(int i=0;i<matrix.length;i++) {
            Set<Integer> knownNumbers = new HashSet<>();
            boolean foundDuplicate = false;
            for(int j=0;j<matrix.length;j++) {
                int next = matrix[j][i];
                if(knownNumbers.contains(next)) {
                    foundDuplicate = true;
                }

                knownNumbers.add(next);
            }

            if(foundDuplicate) result++;
        }
        return result;
    }

    private static int computeRepeatingRows(int[][] matrix) {
        int result = 0;
        for(int i=0;i<matrix.length;i++) {
            Set<Integer> knownNumbers = new HashSet<>();
            boolean foundDuplicate = false;
            for(int j=0;j<matrix.length;j++) {
                int next = matrix[i][j];
                if(knownNumbers.contains(next)) {
                    foundDuplicate = true;
                }

                knownNumbers.add(next);
            }

            if(foundDuplicate) result++;
        }
        return result;
    }

    private static int computeTrace(int[][] matrix) {
        int trace = 0;
        for(int i=0;i<matrix.length;i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int[][] readMatrix(Scanner s) {
        int size = s.nextInt();
        int[][] result = new int[size][size];

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                result[i][j] = s.nextInt();
            }
        }

        return result;
    }
}

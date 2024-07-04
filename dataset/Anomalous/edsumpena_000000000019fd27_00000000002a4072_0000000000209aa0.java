import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; ++caseIndex) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] latinSquare = generateLatinSquare(n, k);
            if (latinSquare == null) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": POSSIBLE");
                printLatinSquare(latinSquare);
            }
        }
    }

    private static int[][] generateLatinSquare(int n, int k) {
        if (n + 1 == k) {
            return null;
        }

        int[] diagonal = new int[n];
        for (int i = 0; i < n; i++) {
            diagonal[i] = (k / n) + k % (n - i);
        }

        int[][] latinSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            latinSquare[i][i] = diagonal[i];
        }

        for (int i = 0; i < n; i++) {
            latinSquare[i] = generateValidRow(latinSquare, i, n);
        }

        return latinSquare;
    }

    private static int[] generateValidRow(int[][] latinSquare, int rowIndex, int n) {
        List<Integer> possibleValues = new ArrayList<>();
        int[] row = latinSquare[rowIndex];

        for (int colIndex = 0; colIndex < n; colIndex++) {
            possibleValues.clear();
            for (int value = n; value >= 1; value--) {
                possibleValues.add(value);
            }

            int[] column = getColumn(latinSquare, colIndex);
            int zeroCount = 0;
            int zeroIndex = 0;

            for (int i = 0; i < column.length; i++) {
                if (column[i] == 0) {
                    zeroCount++;
                    zeroIndex = i;
                }
            }

            if (zeroCount == 1 && zeroIndex == rowIndex) {
                for (int val : column) {
                    possibleValues.remove((Integer) val);
                }
                if (!possibleValues.isEmpty()) {
                    row[colIndex] = possibleValues.get(0);
                }
            }
        }

        possibleValues.clear();
        for (int value = n; value >= 1; value--) {
            possibleValues.add(value);
        }

        for (int val : row) {
            possibleValues.remove((Integer) val);
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (row[colIndex] == 0) {
                int[] column = getColumn(latinSquare, colIndex);
                for (int i = 0; i < possibleValues.size(); i++) {
                    boolean contains = false;
                    for (int val : column) {
                        if (possibleValues.get(i) == val) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        row[colIndex] = possibleValues.remove(i);
                        break;
                    }
                }
            }
        }

        return row;
    }

    private static int[] getColumn(int[][] latinSquare, int colIndex) {
        int[] column = new int[latinSquare.length];
        for (int i = 0; i < latinSquare.length; i++) {
            column[i] = latinSquare[i][colIndex];
        }
        return column;
    }

    private static void printLatinSquare(int[][] latinSquare) {
        for (int[] row : latinSquare) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
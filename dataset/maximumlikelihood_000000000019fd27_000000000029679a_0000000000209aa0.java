import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCase = scanner.nextInt();
        for (int testCase = 1; testCase <= numTestCase; ++testCase) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            printResult(testCase, bruteForceSolve(n, k));
        }
    }

    private static String bruteForceSolve(int n, int k) {

        int [][] matrix = new int[n][n];
        for (int iteration = 0; iteration < 10000; ++iteration) {
            boolean success = fillMatrix2(matrix);
            if (success && isLatinSquare(matrix) && getTrace(matrix) == k) {
                return "POSSIBLE\n" + printMatrix(matrix);
            }
        }
        return "IMPOSSIBLE";
    }

    private static String printMatrix(int[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                output.append(matrix[i][j]);
                if (j != matrix.length - 1) {
                    output.append(" ");
                }
            }
            if (i != matrix.length - 1) {
                output.append("\n");
            }
        }

        return output.toString();
    }

    private static int getTrace(int[][] matrix) {
        int total = 0;
        for (int i = 0; i < matrix.length; ++i) {
            total += matrix[i][i];
        }

        return total;
    }

    private static boolean isLatinSquare(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            int[] row = new int[matrix.length];
            for (int j = 0; j < matrix.length; ++j) {
                int value = matrix[i][j] - 1;
                row[value]++;
                if (row[value] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            int[] col = new int[matrix.length];
            for (int j = 0; j < matrix.length; ++j) {
                int value = matrix[j][i] - 1;
                col[value]++;
                if (col[value] > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void fillMatrix(int[][] matrix) {
        List<LinkedList<Integer>> possibleRowValues = new ArrayList<>();
        for (int i = 0; i < matrix.length; ++i) {
            LinkedList<Integer> values = new LinkedList<>();
            for (int j = 0; j < matrix.length; ++j) {
                values.add(j + 1);
            }
            Collections.shuffle(values);
            possibleRowValues.add(values);
        }

        for (int i = 0; i < matrix.length; ++i) {
            LinkedList<Integer> rowValues = possibleRowValues.get(i);
            for (int j = 0; j < matrix.length; ++j) {
                int rowValue = rowValues.removeFirst();
                matrix[i][j] =  rowValue;
            }
        }
    }

    private static boolean fillMatrix2(int[][] matrix) {
        List[][] possibleValues = new List[matrix.length][matrix.length];
        List<Integer> values = IntStream.range(1, matrix.length + 1).boxed()
            .collect(Collectors.toList());
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                List<Integer> copy = new ArrayList<>(values);
                Collections.shuffle(copy);
                possibleValues[i][j] = copy;
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                List<Integer> list = possibleValues[i][j];
                if (list.size() == 0) {
                    return false;
                }
                int value = list.remove(random.nextInt(list.size()));
                matrix[i][j] = value;
                removeValue(i, j, value, possibleValues);
            }
        }

        return true;
    }

    private static void removeValue(int row, int col, Integer value, List[][] possibleValues) {
        for (int i = 0; i < possibleValues.length; ++i) {
            List<Integer> list = possibleValues[row][i];
            list.remove(value);
        }

        for (int i = 0; i < possibleValues.length; ++i) {
            List<Integer> list = possibleValues[i][col];
            list.remove(value);
        }
    }


    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}
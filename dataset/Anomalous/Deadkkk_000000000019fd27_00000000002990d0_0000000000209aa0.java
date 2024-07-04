import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static List<List<Integer>> combinations = null;
    private static int size = 0;
    private static int[][] sudokuMatrix = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            size = n;
            combinations = new ArrayList<>();
            generateCombinations(k, n);
            boolean solutionFound = false;
            for (List<Integer> combination : combinations) {
                sudokuMatrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    sudokuMatrix[i][i] = combination.get(i);
                }
                if (solveSudoku()) {
                    solutionFound = true;
                    break;
                }
            }
            if (solutionFound) {
                System.out.println("Case #" + tc + ": POSSIBLE");
                printMatrix(sudokuMatrix, n);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static void generateCombinations(int sum, int digits) {
        int[] arr = new int[sum];
        findCombinations(arr, 0, sum, sum, digits);
    }

    private static void findCombinations(int[] arr, int index, int num, int reducedNum, int digit) {
        if (reducedNum < 0) return;
        if (reducedNum == 0 && index == digit) {
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (arr[i] > digit) return;
                combination.add(arr[i]);
            }
            combinations.add(combination);
            return;
        }
        int prev = (index == 0) ? 1 : arr[index - 1];
        for (int k = prev; k <= num; k++) {
            arr[index] = k;
            findCombinations(arr, index + 1, num, reducedNum - k, digit);
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(matrix[r][d] + " ");
            }
            System.out.println();
        }
    }

    private static int[] findUnassignedLocation() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (sudokuMatrix[i][j] == 0) {
                    return new int[]{1, i, j};
                }
            }
        }
        return new int[]{0, -1, -1};
    }

    private static boolean isSafe(int num, int row, int col) {
        for (int i = 0; i < size; i++) {
            if (sudokuMatrix[row][i] == num || sudokuMatrix[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveSudoku() {
        int[] unassigned = findUnassignedLocation();
        if (unassigned[0] == 0) return true;
        int row = unassigned[1];
        int col = unassigned[2];
        for (int num = 1; num <= size; num++) {
            if (isSafe(num, row, col)) {
                sudokuMatrix[row][col] = num;
                if (solveSudoku()) return true;
                sudokuMatrix[row][col] = 0;
            }
        }
        return false;
    }
}
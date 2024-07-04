import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    static List<int[][]> naturalLatinSquares = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        int id = 0;
        naturalLatinSquares.add(new int[][]{{1}});

        while (id < testCases) {
            String[] input = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[][] current = getNaturalLatinSquare(n);
            int[] positions = new int[current.length];

            for (int i = 0; i < current.length; i++) {
                positions[i] = -1;
            }

            if (isTracePossible(current, k, 0, new boolean[current.length], positions)) {
                System.out.println("Case #" + (id + 1) + ": POSSIBLE");
                int[][] reordered = new int[current.length][];
                for (int i = 0; i < current.length; i++) {
                    reordered[positions[i]] = current[i];
                }
                printMatrix(reordered);
            } else {
                System.out.println("Case #" + (id + 1) + ": IMPOSSIBLE");
            }
            id++;
        }
        scanner.close();
    }

    static boolean isTracePossible(int[][] matrix, int k, int rowIndex, boolean[] columnVisited, int[] positions) {
        if (rowIndex == matrix.length) {
            return k == 0;
        }

        for (int j = 0; j < matrix.length; j++) {
            int digit = matrix[rowIndex][j];
            if (!columnVisited[j]) {
                columnVisited[j] = true;
                positions[rowIndex] = j;
                if (isTracePossible(matrix, k - digit, rowIndex + 1, columnVisited, positions)) {
                    return true;
                }
                columnVisited[j] = false;
                positions[rowIndex] = -1;
            }
        }
        return false;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (int val : row) {
                line.append(val).append(" ");
            }
            System.out.println(line.toString().trim());
        }
    }

    static int[][] getNaturalLatinSquare(int n) {
        while (naturalLatinSquares.size() < n) {
            int[][] prev = naturalLatinSquares.get(naturalLatinSquares.size() - 1);
            int[][] curr = computeCurrent(prev);
            naturalLatinSquares.add(curr);
        }
        return naturalLatinSquares.get(n - 1);
    }

    private static int[][] computeCurrent(int[][] prev) {
        int size = prev.length + 1;
        int[][] current = new int[size][size];
        int rowSum = size * (size + 1) / 2;
        boolean[] isVisited = new boolean[size];
        boolean[] addedToColumn = new boolean[size];

        System.arraycopy(prev[0], 0, current[0], 0, size - 1);
        current[0][size - 1] = size;

        for (int i = 1; i < size - 1; i++) {
            int toAdd = -1;
            boolean fixed = false;
            for (int j = size - 2; j >= 0; j--) {
                int digit = prev[i][j];
                if (!fixed && !isVisited[digit - 1] && !addedToColumn[j]) {
                    toAdd = digit;
                    isVisited[digit - 1] = true;
                    addedToColumn[j] = true;
                    fixed = true;
                    current[i][j] = size;
                } else {
                    current[i][j] = prev[i][j];
                }
            }
            current[i][size - 1] = toAdd;
        }

        for (int j = 0; j < size; j++) {
            int sum = 0;
            for (int i = 0; i < size - 1; i++) {
                sum += current[i][j];
            }
            current[size - 1][j] = rowSum - sum;
        }

        return current;
    }
}
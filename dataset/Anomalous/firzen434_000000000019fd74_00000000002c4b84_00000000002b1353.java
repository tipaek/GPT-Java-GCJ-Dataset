import java.util.*;
import java.io.*;

public class Solution {

    private static String findPath(int N) {
        List<List<Integer>> triangle = initializeTriangle(6);
        int sum = 1, r = 0, k = 0, prevRow = 0, prevCol = 0, prevSum = 1;
        Stack<int[]> path = new Stack<>();
        path.push(new int[] {0, 0});

        while (sum < N) {
            int diff = N - sum;
            int[] neighbor = findBiggestNeighbor(r, k, triangle, diff);
            int newRow = neighbor[0], newCol = neighbor[1], value = neighbor[2];

            if (newRow == triangle.size() - 1) {
                appendRow(triangle);
            }

            if (value != -1) {
                prevSum = sum;
                sum += value;
                prevRow = r;
                prevCol = k;
                r = newRow;
                k = newCol;
                triangle.get(r).set(k, -1); // mark as visited
                path.push(new int[] {r, k});
            } else {
                // backtrack
                r = prevRow;
                k = prevCol;
                sum = prevSum;
                if (!path.isEmpty()) {
                    path.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] coordinates : path) {
            result.append(String.format("%d %d\n", coordinates[0] + 1, coordinates[1] + 1));
        }
        return result.toString();
    }

    private static List<List<Integer>> initializeTriangle(int size) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(1));
        for (int i = 1; i < size; i++) {
            appendRow(triangle);
        }
        return triangle;
    }

    private static void appendRow(List<List<Integer>> triangle) {
        List<Integer> newRow = new ArrayList<>();
        int rowIndex = triangle.size();
        for (int colIndex = 0; colIndex <= rowIndex; colIndex++) {
            if (colIndex == 0 || colIndex == rowIndex) {
                newRow.add(1);
            } else {
                int left = triangle.get(rowIndex - 1).get(colIndex - 1);
                int right = triangle.get(rowIndex - 1).get(colIndex);
                newRow.add(left + right);
            }
        }
        triangle.add(newRow);
    }

    private static int[] findBiggestNeighbor(int row, int col, List<List<Integer>> triangle, int diff) {
        int[] directions = {-1, 0, 1};
        int maxNeighbor = -1;
        int[] bestLocation = {row, col};

        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) continue;
                int newRow = row + dr;
                int newCol = col + dc;
                int value = getValue(newRow, newCol, triangle);
                if (value <= diff && value > maxNeighbor) {
                    maxNeighbor = value;
                    bestLocation = new int[] {newRow, newCol};
                }
            }
        }
        return new int[] {bestLocation[0], bestLocation[1], maxNeighbor};
    }

    private static int getValue(int row, int col, List<List<Integer>> triangle) {
        if (row < 0 || col < 0 || row >= triangle.size() || col >= triangle.get(row).size()) {
            return -1;
        }
        return triangle.get(row).get(col);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + i + ":\n" + findPath(N));
        }
    }
}
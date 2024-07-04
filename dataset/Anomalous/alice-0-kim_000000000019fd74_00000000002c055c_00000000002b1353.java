import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            List<int[]> path = new ArrayList<>();
            Map<String, Integer> valueMap = new HashMap<>();
            path.add(new int[]{1, 1});
            findPath(path, valueMap, 1, 1, N);
            System.out.printf("Case #%d:%n", t);
            System.out.println(formatPath(path));
        }
    }

    private static String formatPath(List<int[]> path) {
        StringJoiner result = new StringJoiner("\n");
        for (int[] coordinates : path) {
            result.add(coordinates[0] + " " + coordinates[1]);
        }
        return result.toString();
    }

    private static int calculateValue(Map<String, Integer> valueMap, int row, int col) {
        if (col == 1 || row == col) return 1;
        int topLeft = (col - 1 == 1) ? 1 : valueMap.getOrDefault((row - 1) + "#" + (col - 1), 0);
        int topRight = (row - 1 == col) ? 1 : valueMap.getOrDefault((row - 1) + "#" + col, 0);
        return topLeft + topRight;
    }

    private static boolean findPath(List<int[]> path, Map<String, Integer> valueMap, int row, int col, int remainingSum) {
        if (remainingSum < 0 || row < 1 || col < 1 || row < col || valueMap.containsKey(row + "#" + col)) return false;
        int value = calculateValue(valueMap, row, col);
        valueMap.put(row + "#" + col, value);
        remainingSum -= value;
        if (remainingSum == 0) return true;

        List<int[]> candidates = Arrays.asList(
            new int[]{row - 1, col - 1},
            new int[]{row - 1, col},
            new int[]{row, col - 1},
            new int[]{row, col + 1},
            new int[]{row + 1, col},
            new int[]{row + 1, col + 1}
        );

        for (int[] candidate : candidates) {
            path.add(candidate);
            if (findPath(path, valueMap, candidate[0], candidate[1], remainingSum)) return true;
            path.remove(path.size() - 1);
        }
        return false;
    }
}
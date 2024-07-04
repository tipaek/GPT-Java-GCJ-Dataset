import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final Map<String, Integer> valueCache = new HashMap<>();
    private static final Map<String, Boolean> visitedNodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= testCases; ++i) {
            int targetSum = Integer.parseInt(scanner.nextLine());
            List<String> path = findPath(targetSum);
            System.out.println("Case #" + i + ":");
            for (String step : path) {
                System.out.println(step);
            }
        }
    }

    private static List<String> findPath(int targetSum) {
        List<List<String>> allPaths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        currentPath.add("1 1");
        visitedNodes.put("1 1", true);
        depthFirstSearch(targetSum, 1, 1, 1, currentPath, allPaths);
        return allPaths.isEmpty() ? Collections.emptyList() : allPaths.get(0);
    }

    private static void depthFirstSearch(int targetSum, int row, int col, int currentSum, List<String> currentPath, List<List<String>> allPaths) {
        if (currentSum > targetSum) return;
        if (currentSum == targetSum) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] direction : directions) {
            if (!allPaths.isEmpty()) break;
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            String newNode = newRow + " " + newCol;
            if (newRow <= 0 || newCol <= 0 || newRow < newCol || visitedNodes.getOrDefault(newNode, false)) continue;

            currentPath.add(newNode);
            visitedNodes.put(newNode, true);
            int nodeValue = getValueInTriangle(newRow, newCol);
            depthFirstSearch(targetSum, newRow, newCol, currentSum + nodeValue, currentPath, allPaths);
            currentPath.remove(currentPath.size() - 1);
            visitedNodes.put(newNode, false);
        }
    }

    private static int getValueInTriangle(int row, int col) {
        String key = row + "-" + col;
        if (valueCache.containsKey(key)) return valueCache.get(key);
        if (row == 0 || col == 0) return 0;
        if (col == 1 || row == col) return 1;

        int value = getValueInTriangle(row - 1, col - 1) + getValueInTriangle(row - 1, col);
        valueCache.put(key, value);
        return value;
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            solution.processTestCase(i + 1, scanner);
        }
    }

    private void processTestCase(int caseNumber, Scanner scanner) {
        int targetSum = scanner.nextInt();
        Map<Integer, Map<Integer, Integer>> triangleValues = new HashMap<>();
        triangleValues.put(1, new HashMap<>(Map.of(1, 1)));

        Set<String> resultPath = findPath(targetSum, 1, 1, triangleValues, new LinkedHashSet<>());
        System.out.println("Case #" + caseNumber + ":");
        for (String position : resultPath) {
            int row = Character.getNumericValue(position.charAt(0));
            int col = Character.getNumericValue(position.charAt(2));
            System.out.println(row + " " + col);
        }
    }

    private Set<String> findPath(int remainingSum, int row, int col, Map<Integer, Map<Integer, Integer>> triangleValues, Set<String> visitedPositions) {
        String currentPosition = row + "_" + col;
        if (remainingSum == 0 && visitedPositions.size() <= 500) {
            return visitedPositions;
        }
        if (remainingSum < 0 || visitedPositions.size() == 501 || visitedPositions.contains(currentPosition) || !isPositionValid(row, col)) {
            return null;
        }

        int currentValue = getValue(triangleValues, row, col);
        visitedPositions.add(currentPosition);
        
        Set<String> newPath;
        newPath = findPath(remainingSum - currentValue, row - 1, col - 1, triangleValues, new LinkedHashSet<>(visitedPositions));
        if (newPath != null) return newPath;
        newPath = findPath(remainingSum - currentValue, row - 1, col, triangleValues, new LinkedHashSet<>(visitedPositions));
        if (newPath != null) return newPath;
        newPath = findPath(remainingSum - currentValue, row, col - 1, triangleValues, new LinkedHashSet<>(visitedPositions));
        if (newPath != null) return newPath;
        newPath = findPath(remainingSum - currentValue, row, col + 1, triangleValues, new LinkedHashSet<>(visitedPositions));
        if (newPath != null) return newPath;
        newPath = findPath(remainingSum - currentValue, row + 1, col, triangleValues, new LinkedHashSet<>(visitedPositions));
        if (newPath != null) return newPath;
        newPath = findPath(remainingSum - currentValue, row + 1, col + 1, triangleValues, new LinkedHashSet<>(visitedPositions));
        return newPath;
    }

    private boolean isPositionValid(int row, int col) {
        return col >= 1 && col <= row;
    }

    private int getValue(Map<Integer, Map<Integer, Integer>> triangleValues, int row, int col) {
        if (col < 1 || col > row) {
            return 0;
        }
        if (triangleValues.containsKey(row) && triangleValues.get(row).containsKey(col)) {
            return triangleValues.get(row).get(col);
        } else {
            int value1 = getValue(triangleValues, row - 1, col - 1);
            int value2 = getValue(triangleValues, row - 1, col);
            int result = value1 + value2;

            triangleValues.computeIfAbsent(row, k -> new HashMap<>()).put(col, result);
            return result;
        }
    }
}
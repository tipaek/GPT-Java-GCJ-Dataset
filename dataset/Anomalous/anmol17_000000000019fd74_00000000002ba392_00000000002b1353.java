import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            solution.processTestCase(i + 1, scanner);
        }
    }

    private void processTestCase(int testCaseNumber, Scanner scanner) {
        int targetSum = scanner.nextInt();
        Map<Integer, Map<Integer, Integer>> pascalTriangle = new HashMap<>();
        pascalTriangle.put(1, new HashMap<>());
        pascalTriangle.get(1).put(1, 1);

        Set<String> result = findPath(targetSum, 1, 1, pascalTriangle, new LinkedHashSet<>());
        if (testCaseNumber != 1) {
            System.out.println();
        }
        System.out.println("Case #" + testCaseNumber + ":");
        int counter = 0;
        for (String position : result) {
            int underscoreIndex = position.indexOf('_');
            int row = Integer.parseInt(position.substring(0, underscoreIndex));
            int column = Integer.parseInt(position.substring(underscoreIndex + 1));
            System.out.print(row + " " + column);
            if (++counter < result.size()) {
                System.out.println();
            }
        }
    }

    private Set<String> findPath(int remainingSum, int row, int column, Map<Integer, Map<Integer, Integer>> pascalTriangle, Set<String> visitedPositions) {
        String currentPosition = row + "_" + column;
        if (remainingSum == 0 && visitedPositions.size() <= 500) {
            return visitedPositions;
        }
        if (remainingSum < 0 || visitedPositions.size() == 501 || visitedPositions.contains(currentPosition) || !isValidPosition(row, column)) {
            return null;
        }

        int value = getPascalValue(pascalTriangle, row, column);
        visitedPositions.add(currentPosition);
        Set<String> newPath;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}
        };

        for (int[] direction : directions) {
            newPath = findPath(remainingSum - value, row + direction[0], column + direction[1], pascalTriangle, new LinkedHashSet<>(visitedPositions));
            if (newPath != null) return newPath;
        }

        return null;
    }

    private boolean isValidPosition(int row, int column) {
        return column >= 1 && column <= row;
    }

    private int getPascalValue(Map<Integer, Map<Integer, Integer>> pascalTriangle, int row, int column) {
        if (column < 1 || column > row) {
            return 0;
        }
        if (pascalTriangle.containsKey(row) && pascalTriangle.get(row).containsKey(column)) {
            return pascalTriangle.get(row).get(column);
        } else {
            Map<Integer, Integer> previousRow = pascalTriangle.get(row - 1);
            previousRow.putIfAbsent(column - 1, getPascalValue(pascalTriangle, row - 1, column - 1));
            int value1 = previousRow.get(column - 1);
            previousRow.putIfAbsent(column, getPascalValue(pascalTriangle, row - 1, column));
            int value2 = previousRow.get(column);
            pascalTriangle.putIfAbsent(row, new HashMap<>());
            int result = value1 + value2;
            pascalTriangle.get(row).put(column, result);
            return result;
        }
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);
            System.out.println("Case #" + (i + 1) + ": " + calculateTotalComplexity(scanner, row, col));
        }
    }

    private static int calculateTotalComplexity(Scanner scanner, int row, int col) {
        Set<String> locationsSet = new HashSet<>();
        Map<String, Integer> complexityMap = new HashMap<>();
        int totalComplexity = 0;

        for (int i = 0; i < row; i++) {
            String[] complexities = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String location = formatLocation(i, j);
                int complexity = Integer.parseInt(complexities[j]);
                locationsSet.add(location);
                complexityMap.put(location, complexity);
                totalComplexity += complexity;
            }
        }

        boolean isValid = true;
        while (isValid) {
            int tempComplexity = 0;
            boolean hasChanged = false;
            Set<String> validLocations = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String location = formatLocation(i, j);
                    if (locationsSet.contains(location) && isValidNeighbor(i, j, row, col, locationsSet, complexityMap)) {
                        validLocations.add(location);
                        tempComplexity += complexityMap.get(location);
                    } else {
                        hasChanged = true;
                    }
                }
            }

            locationsSet = validLocations;
            isValid = hasChanged;
            if (isValid) {
                totalComplexity += tempComplexity;
            }
        }

        return totalComplexity;
    }

    private static boolean isValidNeighbor(int i, int j, int row, int col, Set<String> locationsSet, Map<String, Integer> complexityMap) {
        int sum = 0;
        int count = 0;

        sum += getNeighborComplexity(i, j - 1, row, col, locationsSet, complexityMap, true);
        sum += getNeighborComplexity(i, j + 1, row, col, locationsSet, complexityMap, true);
        sum += getNeighborComplexity(i - 1, j, row, col, locationsSet, complexityMap, false);
        sum += getNeighborComplexity(i + 1, j, row, col, locationsSet, complexityMap, false);

        count = sum == 0 ? 0 : 1;
        if (count == 0) {
            return true;
        } else {
            return complexityMap.get(formatLocation(i, j)) >= (float) sum / count;
        }
    }

    private static int getNeighborComplexity(int i, int j, int row, int col, Set<String> locationsSet, Map<String, Integer> complexityMap, boolean isHorizontal) {
        int sum = 0;
        while (isWithinBounds(i, j, row, col)) {
            String location = formatLocation(i, j);
            if (locationsSet.contains(location)) {
                sum += complexityMap.get(location);
                break;
            }
            if (isHorizontal) {
                j += j < col ? 1 : -1;
            } else {
                i += i < row ? 1 : -1;
            }
        }
        return sum;
    }

    private static boolean isWithinBounds(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    private static String formatLocation(int i, int j) {
        return i + "," + j;
    }
}
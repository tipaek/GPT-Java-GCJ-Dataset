import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);
            
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(scanner, row, col));
        }
    }

    public static int calculateResult(Scanner scanner, int row, int col) {
        Set<String> locations = new HashSet<>();
        Map<String, Integer> values = new HashMap<>();
        int totalSum = 0;

        for (int i = 0; i < row; i++) {
            String[] lineValues = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String location = formatLocation(i, j);
                int value = Integer.parseInt(lineValues[j]);
                locations.add(location);
                values.put(location, value);
                totalSum += value;
            }
        }

        boolean hasChanges;
        do {
            hasChanges = false;
            int tempSum = 0;
            Set<String> validLocations = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String currentLocation = formatLocation(i, j);
                    if (locations.contains(currentLocation) && isValidNeighbor(i, j, row, col, locations, values)) {
                        validLocations.add(currentLocation);
                        tempSum += values.get(currentLocation);
                    } else {
                        hasChanges = true;
                    }
                }
            }

            locations = validLocations;
            if (hasChanges) {
                totalSum += tempSum;
            }
        } while (hasChanges);

        return totalSum;
    }

    public static boolean isValidNeighbor(int i, int j, int row, int col, Set<String> locations, Map<String, Integer> values) {
        int sum = 0;
        int count = 0;

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            while (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                String neighborLocation = formatLocation(newRow, newCol);
                if (locations.contains(neighborLocation)) {
                    sum += values.get(neighborLocation);
                    count++;
                    break;
                }
                newRow += direction[0];
                newCol += direction[1];
            }
        }

        return count == 0 || (float) values.get(formatLocation(i, j)) >= (float) sum / count;
    }

    public static String formatLocation(int i, int j) {
        return i + "," + j;
    }
}
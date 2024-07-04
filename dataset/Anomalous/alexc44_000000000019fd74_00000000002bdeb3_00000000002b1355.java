import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;
        
        for (int i = 0; i < cases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            
            System.out.println("Case #" + (i + 1) + ": " + calculateOutput(scanner, row, col));
        }
    }

    private static String calculateOutput(Scanner scanner, int row, int col) {
        Set<String> coordinates = new HashSet<>();
        Map<String, Integer> valueMap = new HashMap<>();
        int totalSum = 0;

        for (int i = 0; i < row; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String location = getLocation(i, j);
                int value = Integer.parseInt(values[j]);
                coordinates.add(location);
                valueMap.put(location, value);
                totalSum += value;
            }
        }

        boolean isValid = true;
        while (isValid) {
            int tempSum = 0;
            boolean hasInvalid = false;
            Set<String> validCoordinates = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String location = getLocation(i, j);
                    if (coordinates.contains(location) && hasValidNeighbors(i, j, row, col, coordinates, valueMap)) {
                        validCoordinates.add(location);
                        tempSum += valueMap.get(location);
                    } else {
                        hasInvalid = true;
                    }
                }
            }

            coordinates = validCoordinates;
            isValid = hasInvalid;
            if (isValid) {
                totalSum += tempSum;
            }
        }

        return Integer.toString(totalSum);
    }

    private static boolean hasValidNeighbors(int i, int j, int row, int col, Set<String> coordinates, Map<String, Integer> valueMap) {
        int sum = 0;
        int count = 0;

        sum += getNeighborSum(i, j - 1, row, col, coordinates, valueMap, count);
        sum += getNeighborSum(i, j + 1, row, col, coordinates, valueMap, count);
        sum += getNeighborSum(i - 1, j, row, col, coordinates, valueMap, count);
        sum += getNeighborSum(i + 1, j, row, col, coordinates, valueMap, count);

        if (count == 0) {
            return true;
        }

        return (double) valueMap.get(getLocation(i, j)) >= (double) sum / count;
    }

    private static int getNeighborSum(int i, int j, int row, int col, Set<String> coordinates, Map<String, Integer> valueMap, int count) {
        int sum = 0;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            String location = getLocation(i, j);
            if (coordinates.contains(location)) {
                sum += valueMap.get(location);
                count++;
                break;
            }
            if (i < 0 || i >= row || j < 0 || j >= col) break;
        }
        return sum;
    }

    private static String getLocation(int i, int j) {
        return i + "," + j;
    }
}
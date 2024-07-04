import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);
            System.out.println("Case #" + (i + 1) + ": " + calculateCompensation(scanner, row, col));
        }
    }

    private static String calculateCompensation(Scanner scanner, int row, int col) {
        Set<String> positions = new HashSet<>();
        Map<String, Integer> values = new HashMap<>();
        int totalCompensation = 0;

        for (int i = 0; i < row; i++) {
            String[] lineValues = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String position = formatPosition(i, j);
                int value = Integer.parseInt(lineValues[j]);
                positions.add(position);
                values.put(position, value);
                totalCompensation += value;
            }
        }

        boolean updated = true;
        while (updated) {
            updated = false;
            int tempCompensation = 0;
            Set<String> validPositions = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String position = formatPosition(i, j);
                    if (positions.contains(position) && isValidNeighbor(i, j, row, col, positions, values)) {
                        validPositions.add(position);
                        tempCompensation += values.get(position);
                    } else {
                        updated = true;
                    }
                }
            }

            positions = validPositions;
            if (updated) {
                totalCompensation += tempCompensation;
            }
        }

        return Integer.toString(totalCompensation);
    }

    private static boolean isValidNeighbor(int i, int j, int row, int col, Set<String> positions, Map<String, Integer> values) {
        long neighborSum = 0;
        int neighborCount = 0;

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            while (x >= 0 && x < row && y >= 0 && y < col) {
                String neighborPos = formatPosition(x, y);
                if (positions.contains(neighborPos)) {
                    neighborSum += values.get(neighborPos);
                    neighborCount++;
                    break;
                }
                x += direction[0];
                y += direction[1];
            }
        }

        return neighborCount == 0 || (long) values.get(formatPosition(i, j)) * neighborCount >= neighborSum;
    }

    private static String formatPosition(int i, int j) {
        return i + "," + j;
    }
}
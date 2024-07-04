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

    public static int calculateCompensation(Scanner scanner, int row, int col) {
        Set<String> positions = new HashSet<>();
        Map<String, Integer> compensationMap = new HashMap<>();
        int totalCompensation = 0;

        for (int i = 0; i < row; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String position = getPosition(i, j);
                int value = Integer.parseInt(values[j]);
                positions.add(position);
                compensationMap.put(position, value);
                totalCompensation += value;
            }
        }

        boolean isValid = true;
        while (isValid) {
            int tempCompensation = 0;
            boolean needsUpdate = false;
            Set<String> validPositions = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String position = getPosition(i, j);
                    if (positions.contains(position) && isValidNeighbor(i, j, row, col, positions, compensationMap)) {
                        validPositions.add(position);
                        tempCompensation += compensationMap.get(position);
                    } else {
                        needsUpdate = true;
                    }
                }
            }

            positions = validPositions;
            isValid = needsUpdate;
            if (isValid) {
                totalCompensation += tempCompensation;
            }
        }

        return totalCompensation;
    }

    public static boolean isValidNeighbor(int i, int j, int row, int col, Set<String> positions, Map<String, Integer> compensationMap) {
        int sum = 0;
        int count = 0;

        int[] directions = {-1, 1};
        for (int d : directions) {
            if (j + d >= 0 && j + d < col && positions.contains(getPosition(i, j + d))) {
                sum += compensationMap.get(getPosition(i, j + d));
                count++;
            }
            if (i + d >= 0 && i + d < row && positions.contains(getPosition(i + d, j))) {
                sum += compensationMap.get(getPosition(i + d, j));
                count++;
            }
        }

        if (count == 0) {
            return true;
        } else {
            return compensationMap.get(getPosition(i, j)) >= (double) sum / count;
        }
    }

    public static String getPosition(int i, int j) {
        return i + "," + j;
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String curr = scanner.nextLine();
            String[] dimensions = curr.split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);

            System.out.println("Case #" + (i + 1) + ": " + computeOutput(scanner, row, col));
        }
    }

    public static String computeOutput(Scanner scanner, int row, int col) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int totalSum = 0;

        for (int i = 0; i < row; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String loc = getLocation(i, j);
                int value = Integer.parseInt(values[j]);
                set.add(loc);
                map.put(loc, value);
                totalSum += value;
            }
        }

        boolean valid = true;
        while (valid) {
            int tempSum = 0;
            boolean hasChanges = false;
            Set<String> keep = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String loc = getLocation(i, j);
                    if (set.contains(loc) && isValidNeighbor(i, j, row, col, set, map)) {
                        keep.add(loc);
                        tempSum += map.get(loc);
                    } else {
                        hasChanges = true;
                    }
                }
            }

            set = keep;
            valid = hasChanges;
            if (valid) {
                totalSum += tempSum;
            }
        }

        return Integer.toString(totalSum);
    }

    public static boolean isValidNeighbor(int i, int j, int row, int col, Set<String> set, Map<String, Integer> map) {
        int sum = 0;
        int count = 0;

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            while (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                String neighborLoc = getLocation(ni, nj);
                if (set.contains(neighborLoc)) {
                    sum += map.get(neighborLoc);
                    count++;
                    break;
                }
                ni += dir[0];
                nj += dir[1];
            }
        }

        return count == 0 || map.get(getLocation(i, j)) * count >= sum;
    }

    public static String getLocation(int i, int j) {
        return i + "," + j;
    }
}
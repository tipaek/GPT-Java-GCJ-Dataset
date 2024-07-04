import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<List<Integer>> pascalTriangle = generatePascalTriangle();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<Integer> path = findPascalPath(n, pascalTriangle);
            System.out.println("Case #" + i + ":");
            for (int position : path) {
                int row = position / 100 + 1;
                int col = position % 100 + 1;
                System.out.println(row + " " + col);
            }
        }
    }

    private static List<List<Integer>> generatePascalTriangle() {
        List<List<Integer>> pascalTriangle = new ArrayList<>(31);
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);

        for (int i = 1; i < 31; i++) {
            List<Integer> currentRow = new ArrayList<>(i + 1);
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
        }

        return pascalTriangle;
    }

    private static List<Integer> findPascalPath(int n, List<List<Integer>> pascalTriangle) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        visited.add(0);

        if (explorePath(n - 1, pascalTriangle, path, visited)) {
            return path;
        }

        return Collections.emptyList();
    }

    private static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

    private static boolean explorePath(int remaining, List<List<Integer>> pascalTriangle, List<Integer> path, Set<Integer> visited) {
        if (remaining == 0) {
            return true;
        }

        if (path.size() >= 500) {
            return false;
        }

        int currentRow = path.get(path.size() - 1) / 100;
        int currentCol = path.get(path.size() - 1) % 100;

        for (int[] direction : DIRECTIONS) {
            int newRow = currentRow + direction[0];
            int newCol = currentCol + direction[1];

            if (newRow >= 0 && newRow < 31 && newCol >= 0 && newCol <= newRow) {
                int value = pascalTriangle.get(newRow).get(newCol);
                if (remaining >= value) {
                    int hash = newRow * 100 + newCol;
                    if (!visited.contains(hash)) {
                        path.add(hash);
                        visited.add(hash);

                        if (explorePath(remaining - value, pascalTriangle, path, visited)) {
                            return true;
                        }

                        path.remove(path.size() - 1);
                        visited.remove(hash);
                    }
                }
            }
        }

        return false;
    }
}
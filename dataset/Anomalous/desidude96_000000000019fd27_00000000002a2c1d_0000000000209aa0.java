import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static int[][] finalGrid;
    private static boolean done;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            Map<Integer, HashSet<Integer>> mapRows = initializeMap(n);
            Map<Integer, HashSet<Integer>> mapCols = initializeMap(n);
            String[] positions = generatePositions(n);
            int[][] grid = new int[n][n];
            finalGrid = new int[n][n];
            done = false;
            build(n, k, 0, positions, grid, mapRows, mapCols);
            printResult(i, n);
        }
    }

    private static Map<Integer, HashSet<Integer>> initializeMap(int n) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(j, new HashSet<>());
        }
        return map;
    }

    private static String[] generatePositions(int n) {
        String[] positions = new String[n * n];
        int index = 0;
        for (int j = 0; j < n; j++) {
            for (int z = 0; z < n; z++) {
                positions[index++] = j + " " + z;
            }
        }
        return positions;
    }

    private static void build(int n, int k, int pos, String[] positions, int[][] grid, 
                              Map<Integer, HashSet<Integer>> mapRows, Map<Integer, HashSet<Integer>> mapCols) {
        if (done || pos >= positions.length || k < 0) {
            return;
        }
        String[] coordinates = positions[pos].split(" ");
        int curX = Integer.parseInt(coordinates[0]);
        int curY = Integer.parseInt(coordinates[1]);

        for (int i = 1; i <= n; i++) {
            if (mapRows.get(curX).contains(i) || mapCols.get(curY).contains(i)) {
                continue;
            }
            Map<Integer, HashSet<Integer>> newRows = copyMap(mapRows);
            Map<Integer, HashSet<Integer>> newCols = copyMap(mapCols);
            newRows.get(curX).add(i);
            newCols.get(curY).add(i);
            int[][] newGrid = cloneGrid(grid);
            newGrid[curX][curY] = i;
            if (i == k && pos == positions.length - 1) {
                finalGrid = newGrid;
                done = true;
                return;
            }
            build(n, (curX == curY) ? k - i : k, pos + 1, positions, newGrid, newRows, newCols);
        }
    }

    private static int[][] cloneGrid(int[][] grid) {
        int[][] newGrid = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }
        return newGrid;
    }

    private static Map<Integer, HashSet<Integer>> copyMap(Map<Integer, HashSet<Integer>> map) {
        Map<Integer, HashSet<Integer>> copy = new HashMap<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        return copy;
    }

    private static void printResult(int caseNumber, int n) {
        String result = done ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + caseNumber + ": " + result);
        if (done) {
            for (int[] row : finalGrid) {
                for (int i = 0; i < row.length; i++) {
                    System.out.print(row[i]);
                    if (i < row.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
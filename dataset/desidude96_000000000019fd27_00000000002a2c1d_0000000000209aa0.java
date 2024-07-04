import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static int[][] finalGrid;
    private static boolean done = false;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            Map<Integer, HashSet<Integer>> mapRows = new HashMap<>();
            Map<Integer, HashSet<Integer>> mapCols = new HashMap<>();
            for (int j = 0; j < n; j++) {
                mapCols.put(j, new HashSet<>());
                mapRows.put(j, new HashSet<>());
            }
            String[] positions = new String[n*n];
            int index = 0;
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    positions[index] = j + " " + z;
                    index++;
                }
            }
            int[][] grid = new int[n][n];
            finalGrid = new int[n][n];
            done = false;
            build(n, k, 0, positions, grid, mapRows, mapCols);
            String result = (!done) ? "IMPOSSIBLE" : "POSSIBLE";
            System.out.println("Case #" + i + ": " + result);
            if (result.equals("POSSIBLE")) {
                for (int j = 0; j < n; j++) {
                    String row = "";
                    for (int z = 0; z < finalGrid[j].length; z++) row += finalGrid[j][z] + " ";
                    System.out.println(row.substring(0, row.length()-1));
                }
            }
        }
    }

    private static void build(int n,
                              int S,
                              int pos,
                              String[] positions,
                              int[][] grid,
                              Map<Integer, HashSet<Integer>> mapRows,
                              Map<Integer, HashSet<Integer>> mapCols) {

        //print(grid);
        //System.out.println("NEXT");
        //System.out.println("N: " + n + " S: " + S + " pos: " + pos + " ROWS: " + mapRows + " COLS: " + mapCols);
        if (done || pos >= positions.length || S < 0) {
            return;
        }
        String[] xAndY = positions[pos].split(" ");
        int curX = Integer.valueOf(xAndY[0]);
        int curY = Integer.valueOf(xAndY[1]);

        for (int i = 1; i <= n; i++) {
            if (mapRows.get(curX).contains(i) || mapCols.get(curY).contains(i)) {
                //System.out.println("EXIT HERE");
                continue;
            }
            Map<Integer, HashSet<Integer>> newRows = copyMap(mapRows);
            Map<Integer, HashSet<Integer>> newCols = copyMap(mapCols);
            newRows.get(curX).add(i);
            newCols.get(curY).add(i);
            int[][] newGrid = cloneGrid(grid);
            newGrid[curX][curY] = i;
            if (i == S && pos == positions.length-1) {
                finalGrid = newGrid;
                done = true;
                return;
            }
            build(n, (curX == curY) ? S-i : S, pos+1, positions, newGrid, newRows, newCols);
        }
    }

    private static int[][] cloneGrid(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) newGrid[i][j] = grid[i][j];
        }
        return newGrid;
    }

    private static Map<Integer, HashSet<Integer>> copyMap(Map<Integer, HashSet<Integer>> map) {
        Map<Integer, HashSet<Integer>> copy = new HashMap<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet()) {
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        return copy;
    }
}
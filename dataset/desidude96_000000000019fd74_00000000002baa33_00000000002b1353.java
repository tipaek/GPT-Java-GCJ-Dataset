import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;


public class Solution {

    private static List<String> steps = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        int[][] triangle = buildPascalTriangle();
        for (int i = 1; i <= numCases; i++) {
            int sum = in.nextInt();
            outputPath(sum, new LinkedHashSet<>(), 0, 0, triangle);
            System.out.println("Case #" + i + ":");
            for (String step: steps) System.out.println(step);
            steps = new ArrayList<>();
        }
    }

    private static void outputPath(int n, LinkedHashSet<String> visited, int x, int y, int[][] triangle) {
        if (x < 0 || x >= triangle.length || y < 0 || y >= triangle.length || visited.contains((x+1) + " " + (y+1)) || !steps.isEmpty() || n < 0) return;
        visited.add((x+1) + " " + (y+1));
        if (n-triangle[x][y] == 0) {
            steps = new ArrayList<>(visited);
            return;
        }
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x-1, y-1, triangle);
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x, y-1, triangle);
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x-1, y, triangle);
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x+1, y, triangle);
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x, y+1, triangle);
        outputPath(n-triangle[x][y], new LinkedHashSet<>(visited), x+1, y+1, triangle);
    }

    private static int[][] buildPascalTriangle() {
        int size = 500;
        int[][] grid = new int[size][size];
        grid[0][0] = grid[1][0] = grid[1][1] = 1;
        for (int i = 2; i < size; i++) {
            grid[i][0] = grid[i][i] = 1;
            for (int j = 1; j <= i-1; j++) {
                grid[i][j] = grid[i-1][j] + grid[i-1][j-1];
            }
        }
        return grid;
    }
}    
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Solution {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static final PrintWriter writer = new PrintWriter(System.out);
  private static int[][] grid;
  private static int targetSum;
  
  public static void main(String[] args) throws IOException {
    process();
    writer.flush();
    writer.close();
    reader.close();
  }

  private static boolean isValidPlacement(int row, int col, int num) {
    for (int i = 0; i < grid.length; i++) {
      if (grid[row][i] == num || grid[i][col] == num) {
        return false;
      }
    }
    return true;
  }

  private static boolean hasValidSum() {
    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      sum += grid[i][i];
    }
    return sum == targetSum;
  }

  private static void displayGrid() {
    for (int[] row : grid) {
      for (int cell : row) {
        writer.print(cell + " ");
      }
      writer.println();
    }
  }

  private static boolean fillGrid(int row, int col) {
    if (row == grid.length) {
      return hasValidSum();
    }
    for (int num = 1; num <= grid.length; num++) {
      if (isValidPlacement(row, col, num)) {
        grid[row][col] = num;
        if (fillGrid(col == grid.length - 1 ? row + 1 : row, (col + 1) % grid.length)) {
          return true;
        }
        grid[row][col] = 0;
      }
    }
    return false;
  }

  private static void process() throws IOException {
    int testCases = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= testCases; t++) {
      String[] input = reader.readLine().split(" ");
      int size = Integer.parseInt(input[0]);
      targetSum = Integer.parseInt(input[1]);
      grid = new int[size][size];
      boolean possible = fillGrid(0, 0);
      if (possible) {
        writer.println("Case #" + t + ": POSSIBLE");
        displayGrid();
      } else {
        writer.println("Case #" + t + ": IMPOSSIBLE");
      }
    }
  }
}
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int i = 0; i < t; i++) {
            int dim = in.nextInt();
            int[][] grid = new int[dim][dim];
            for (int x = 0; x < dim; x++){
                for (int y = 0; y < dim; y++){
                    grid[x][y] = in.nextInt();
                }
            }
            int sum = 0;
            for (int x = 0; x < dim; x++){
                sum += grid[x][x];
            }
            int row = 0;
            int column = 0;
            for (int x = 0; x < dim; x++){
                Set<Integer> a = new HashSet<>();
                for (int y = 0; y < dim; y++){
                    a.add(grid[x][y]);
                }
                if (a.size() != dim) {
                    row++;
                }
            }
            for (int x = 0; x < dim; x++){
                Set<Integer> a = new HashSet<>();
                for (int y = 0; y < dim; y++){
                    a.add(grid[y][x]);
                }
                if (a.size() != dim) {
                    column++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + row + " " + column);
      }
  }
}
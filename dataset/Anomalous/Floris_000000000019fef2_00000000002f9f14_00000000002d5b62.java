import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        final int GRID_SIZE = 512;
        final int OFFSET = 256;
        String[][] grid = new String[GRID_SIZE][GRID_SIZE];
        grid[OFFSET][OFFSET] = "";

        for (int i = 0; i < 10; i++) {
            String[][] newGrid = new String[GRID_SIZE][GRID_SIZE];
            int distance = 1 << i;

            for (int y = 0; y < GRID_SIZE; y++) {
                for (int x = 0; x < GRID_SIZE; x++) {
                    if (grid[y][x] != null) {
                        newGrid[y][x] = grid[y][x];
                        if (y - distance >= 0 && grid[y - distance][x] == null) {
                            newGrid[y - distance][x] = grid[y][x] + "S";
                        }
                        if (y + distance < GRID_SIZE && grid[y + distance][x] == null) {
                            newGrid[y + distance][x] = grid[y][x] + "N";
                        }
                        if (x - distance >= 0 && grid[y][x - distance] == null) {
                            newGrid[y][x - distance] = grid[y][x] + "W";
                        }
                        if (x + distance < GRID_SIZE && grid[y][x + distance] == null) {
                            newGrid[y][x + distance] = grid[y][x] + "E";
                        }
                    }
                }
            }
            grid = newGrid;
        }

        int cases = sc.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int adjustedX = x + OFFSET;
            int adjustedY = y + OFFSET;

            if (adjustedX >= 0 && adjustedX < GRID_SIZE && adjustedY >= 0 && adjustedY < GRID_SIZE && grid[adjustedY][adjustedX] != null) {
                System.out.printf("Case #%d: %s%n", cs, grid[adjustedY][adjustedX]);
            } else {
                System.out.printf("Case #%d: %s%n", cs, "IMPOSSIBLE");
            }
        }
    }
}
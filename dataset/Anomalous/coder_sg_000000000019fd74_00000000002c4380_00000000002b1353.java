import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private static int[][] pascalTriangle;
    private static ArrayList<Pair> path;
    private static boolean foundPath;

    private static void generatePascalTriangle(int size) {
        pascalTriangle = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    pascalTriangle[row][col] = 1;
                } else {
                    pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col];
                }
            }
        }
    }

    private static void findPath(int currentSum, Pair currentCell, ArrayList<Pair> currentPath, int targetSum) {
        if (currentSum == targetSum) {
            path = new ArrayList<>();
            for (Pair cell : currentPath) {
                path.add(new Pair(cell.row + 1, cell.col + 1));
            }
            foundPath = true;
            return;
        }

        int row = currentCell.row;
        int col = currentCell.col;
        int[][] directions = {
                {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < targetSum && newCol >= 0 && newCol < targetSum && pascalTriangle[newRow][newCol] > 0) {
                int temp = pascalTriangle[newRow][newCol];
                pascalTriangle[newRow][newCol] = -1;
                Pair newCell = new Pair(newRow, newCol);
                currentPath.add(newCell);
                findPath(currentSum + temp, newCell, currentPath, targetSum);
                if (foundPath) return;
                currentPath.remove(currentPath.size() - 1);
                pascalTriangle[newRow][newCol] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            generatePascalTriangle(n);
            foundPath = false;
            ArrayList<Pair> initialPath = new ArrayList<>();
            Pair start = new Pair(0, 0);
            pascalTriangle[0][0] = -1;
            initialPath.add(start);
            findPath(1, start, initialPath, n);

            System.out.println("Case #" + t + ":");
            for (Pair cell : path) {
                System.out.println(cell.row + " " + cell.col);
            }
        }
    }
}
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
    private static ArrayList<Pair> resultPath;
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

    private static void findPascalPath(int currentSum, Pair currentCell, ArrayList<Pair> currentPath, int targetSum) {
        if (currentSum > targetSum || currentPath.size() == 500) {
            return;
        }

        if (currentSum == targetSum) {
            resultPath = new ArrayList<>();
            for (Pair cell : currentPath) {
                resultPath.add(new Pair(cell.row + 1, cell.col + 1));
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

            if (newRow >= 0 && newRow < targetSum && newCol >= 0 && newCol <= newRow) {
                int cellValue = pascalTriangle[newRow][newCol];
                if (cellValue > 0) {
                    pascalTriangle[newRow][newCol] = -1;
                    Pair newCell = new Pair(newRow, newCol);
                    currentPath.add(newCell);
                    findPascalPath(currentSum + cellValue, newCell, currentPath, targetSum);
                    if (foundPath) {
                        return;
                    }
                    currentPath.remove(currentPath.size() - 1);
                    pascalTriangle[newRow][newCol] = cellValue;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int targetSum = Integer.parseInt(reader.readLine());
            generatePascalTriangle(targetSum);

            foundPath = false;
            ArrayList<Pair> path = new ArrayList<>();
            Pair startCell = new Pair(0, 0);
            pascalTriangle[0][0] = -1;
            path.add(startCell);
            findPascalPath(1, startCell, path, targetSum);

            System.out.println("Case #" + (i + 1) + ":");
            for (Pair cell : resultPath) {
                System.out.println(cell.row + " " + cell.col);
            }
        }
    }
}
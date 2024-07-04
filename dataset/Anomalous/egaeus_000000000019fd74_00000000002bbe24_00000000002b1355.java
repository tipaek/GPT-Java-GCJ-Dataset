import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rows = Integer.parseInt(tokenizer.nextToken());
            int cols = Integer.parseInt(tokenizer.nextToken());

            long[][] grid = new long[rows][cols];
            long totalSum = 0, result = 0;
            TreeSet<Integer>[] rowSets = new TreeSet[rows];
            TreeSet<Integer>[] colSets = new TreeSet[cols];

            for (int i = 0; i < rows; i++) rowSets[i] = new TreeSet<>();
            for (int i = 0; i < cols; colSets[i++] = new TreeSet<>());

            for (int i = 0; i < rows; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = Integer.parseInt(tokenizer.nextToken());
                    totalSum += grid[i][j];
                    rowSets[i].add(j);
                    colSets[j].add(i);
                }
            }

            while (true) {
                result += totalSum;
                long sumToRemove = 0;
                ArrayList<int[]> cellsToDelete = new ArrayList<>();

                for (int i = 0; i < rows; i++) {
                    for (int j : rowSets[i]) {
                        double neighborCount = 0;
                        long neighborSum = 0;

                        Integer left = rowSets[i].floor(j - 1);
                        Integer right = rowSets[i].ceiling(j + 1);
                        Integer below = colSets[j].ceiling(i + 1);
                        Integer above = colSets[j].floor(i - 1);

                        if (left != null) {
                            neighborCount++;
                            neighborSum += grid[i][left];
                        }
                        if (right != null) {
                            neighborCount++;
                            neighborSum += grid[i][right];
                        }
                        if (below != null) {
                            neighborCount++;
                            neighborSum += grid[below][j];
                        }
                        if (above != null) {
                            neighborCount++;
                            neighborSum += grid[above][j];
                        }

                        if (neighborCount > 0 && grid[i][j] < neighborSum / neighborCount) {
                            cellsToDelete.add(new int[]{i, j});
                        }
                    }
                }

                for (int[] cell : cellsToDelete) {
                    sumToRemove += grid[cell[0]][cell[1]];
                    rowSets[cell[0]].remove(cell[1]);
                    colSets[cell[1]].remove(cell[0]);
                }

                totalSum -= sumToRemove;
                if (sumToRemove == 0) break;
            }

            output.append(result).append("\n");
        }

        System.out.print(output.toString());
    }
}
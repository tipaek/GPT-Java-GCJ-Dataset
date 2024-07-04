import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void process() {
        int[] rowDelta = {0, -1, 0, 1};
        int[] colDelta = {1, 0, -1, 0};
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long[][] grid = new long[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            long total = 0;
            boolean[][] eliminated = new boolean[rows][cols];
            boolean[][][] noNeighbor = new boolean[rows][cols][4];
            Queue<Integer> removalQueue = new LinkedList<>();
            
            while (true) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!eliminated[i][j]) {
                            total += grid[i][j];
                            int neighborCount = 0;
                            long neighborSum = 0;
                            
                            for (int direction = 0; direction < 4; direction++) {
                                if (!noNeighbor[i][j][direction]) {
                                    int newRow = i + rowDelta[direction];
                                    int newCol = j + colDelta[direction];
                                    
                                    while (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                                        if (!eliminated[newRow][newCol]) {
                                            neighborCount++;
                                            neighborSum += grid[newRow][newCol];
                                            break;
                                        }
                                        newRow += rowDelta[direction];
                                        newCol += colDelta[direction];
                                    }

                                    if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols) {
                                        noNeighbor[i][j][direction] = true;
                                    }
                                }
                            }

                            if (neighborCount > 0 && neighborCount * grid[i][j] < neighborSum) {
                                removalQueue.add(i);
                                removalQueue.add(j);
                            }
                        }
                    }
                }

                if (removalQueue.isEmpty()) break;
                
                while (!removalQueue.isEmpty()) {
                    int i = removalQueue.poll();
                    int j = removalQueue.poll();
                    eliminated[i][j] = true;
                }
            }

            System.out.printf("Case #%d: %d\n", caseIndex, total);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().process();
    }
}
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                System.out.print("Case #" + t + ": ");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                int[][] matrix = new int[rows][cols];
                int[][][] neighborData = new int[rows][cols][2];
                int totalElements = rows * cols;
                int score = 0;
                Set<Integer> activeElements = new HashSet<>();
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = scanner.nextInt();
                        activeElements.add(i * cols + j);
                        if (i > 0) {
                            neighborData[i - 1][j][0] += matrix[i][j];
                            neighborData[i - 1][j][1]++;
                        }
                        if (i < rows - 1) {
                            neighborData[i + 1][j][0] += matrix[i][j];
                            neighborData[i + 1][j][1]++;
                        }
                        if (j > 0) {
                            neighborData[i][j - 1][0] += matrix[i][j];
                            neighborData[i][j - 1][1]++;
                        }
                        if (j < cols - 1) {
                            neighborData[i][j + 1][0] += matrix[i][j];
                            neighborData[i][j + 1][1]++;
                        }
                    }
                }
                
                boolean updated;
                do {
                    updated = false;
                    Set<Integer> toRemove = new HashSet<>();
                    for (int index : activeElements) {
                        int r = index / cols;
                        int c = index % cols;
                        score += matrix[r][c];
                        if (neighborData[r][c][0] > matrix[r][c] * neighborData[r][c][1]) {
                            toRemove.add(index);
                        }
                    }
                    
                    for (int index : toRemove) {
                        int r = index / cols;
                        int c = index % cols;
                        updateNeighbors(neighborData, matrix, activeElements, toRemove, r, c, rows, cols);
                    }
                    
                    if (!toRemove.isEmpty()) {
                        activeElements.removeAll(toRemove);
                        updated = true;
                    }
                } while (updated);
                
                System.out.println(score);
            }
        }
    }
    
    private static void updateNeighbors(int[][][] neighborData, int[][] matrix, Set<Integer> activeElements, Set<Integer> toRemove, int r, int c, int rows, int cols) {
        updateDirection(neighborData, matrix, activeElements, toRemove, r, c, rows, cols, -1, 0);
        updateDirection(neighborData, matrix, activeElements, toRemove, r, c, rows, cols, 1, 0);
        updateDirection(neighborData, matrix, activeElements, toRemove, r, c, rows, cols, 0, -1);
        updateDirection(neighborData, matrix, activeElements, toRemove, r, c, rows, cols, 0, 1);
    }
    
    private static void updateDirection(int[][][] neighborData, int[][] matrix, Set<Integer> activeElements, Set<Integer> toRemove, int r, int c, int rows, int cols, int dr, int dc) {
        int nr = r + dr;
        int nc = c + dc;
        while (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
            int index = nr * cols + nc;
            if (activeElements.contains(index)) {
                neighborData[nr][nc][0] -= matrix[r][c];
                neighborData[nr][nc][1]--;
                int newNr = r - dr;
                int newNc = c - dc;
                while (newNr >= 0 && newNr < rows && newNc >= 0 && newNc < cols) {
                    int newIndex = newNr * cols + newNc;
                    if (activeElements.contains(newIndex) && !toRemove.contains(newIndex)) {
                        neighborData[nr][nc][0] += matrix[newNr][newNc];
                        neighborData[nr][nc][1]++;
                        break;
                    }
                    newNr -= dr;
                    newNc -= dc;
                }
                break;
            }
            nr += dr;
            nc += dc;
        }
    }
}